package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo
                .findByUsername(username)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getUsername(),
                        u.getPassword(),
                        u.isActive(),
                        u.isActive(),
                        u.isActive(),
                        u.isActive(),
                        AuthorityUtils.createAuthorityList(
                               u.getRole()
                                )))
                .orElseThrow(() -> new UsernameNotFoundException("No user with "
                        + "the name " + username + "was found in the database"));
    }


    public Optional<User> getUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Optional<User> validUsernameAndPassword(String username, String password) {
        return getUserByUsername(username)
                .filter(user -> new BCryptPasswordEncoder().matches(password, user.getPassword()));
    }

    public User validateAndGetUserByUsername(String username) {
        return getUserByUsername(username)
                .orElseThrow(() -> new NullPointerException(String.format("User with username %s not found", username)));
    }

}
