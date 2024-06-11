
package hu.temetkezes.demo.services;

import hu.temetkezes.demo.models.User;
import hu.temetkezes.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> userList(){
        return repo.findAll();
    }

}
