package hu.temetkezes.demo.utils;

import hu.temetkezes.demo.models.CredentialEntity;
import hu.temetkezes.demo.models.Role;
import hu.temetkezes.demo.models.User;
import org.springframework.beans.BeanUtils;

import static java.time.LocalDateTime.now;

public class UserUtils {

    public static User fromUser(User userEntity, Role role, CredentialEntity credentialEntity) {
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        user.setLastLogin(userEntity.getLastLogin());
        user.setCredentialsNonExpired(isCredentialsNonExpired(credentialEntity));
        user.setRole(role);
        System.out.println("fromUser: "+user.getId());
        return user;
    }

    private static boolean isCredentialsNonExpired(CredentialEntity credentialEntity) {
        return credentialEntity.getUpdatedAt().plusDays(90).isAfter(now());
    }
}