
package hu.temetkezes.demo.services;

import hu.temetkezes.demo.cache.CacheStore;
import hu.temetkezes.demo.domain.RequestContext;
import hu.temetkezes.demo.enums.LoginType;
import hu.temetkezes.demo.exception.ApiException;
import hu.temetkezes.demo.models.CredentialEntity;
import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.repository.CredentialRepository;
import hu.temetkezes.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static hu.temetkezes.demo.utils.UserUtils.fromUser;

@Service
public class UserService implements UserDataService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private CredentialRepository credentialRepository;

    private final CacheStore<String,Integer> userCache;

    public UserService(CacheStore<String, Integer> userCache) {
        this.userCache = userCache;
    }

    public List<User> userList(){
        return repo.findAll();
    }



    @Override
    public void updateLoginAttempt(String email, LoginType loginType) {
        var user = getUserByEmail(email);
        RequestContext.setUserId(user.getId());
        switch (loginType){
            case LOGIN_ATTEMPT -> {
                if(userCache.get(user.getEmail()) == null){
                    user.setLoginAttempt(0);
                    user.setAccountNonExpired(true);
                }
                user.setLoginAttempt(user.getLoginAttempt()+1);
                userCache.put(user.getEmail(), user.getLoginAttempt());
                if (userCache.get(user.getEmail()) > 5){
                    user.setAccountNonLocked(false);
                }
            }
            case LOGIN_SUCCESS -> {
                user.setAccountNonLocked(true);
                user.setLoginAttempt(0);
                user.setLastLogin(LocalDateTime.now());
                userCache.evict(user.getEmail());
            }
        }
        repo.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        User userByEmail = repo.getUserByEmail(email);
        return fromUser(userByEmail,userByEmail.getRole(),getUserCredentialsById(userByEmail.getId()));
    }

    @Override
    public User getUserByUserId(String userId) {
        return repo.findByUserId(userId).orElseThrow(() -> new ApiException("User not found"));
    }

    @Override
    public CredentialEntity getUserCredentialsById(Long id) {
        var credentialByUserId = credentialRepository.getByUserId(id);
        return credentialByUserId.orElseThrow(() -> new ApiException("Unable to find user credential"));
    }
}
