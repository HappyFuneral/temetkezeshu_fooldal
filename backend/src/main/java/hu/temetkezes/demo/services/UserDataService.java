package hu.temetkezes.demo.services;

import hu.temetkezes.demo.enums.LoginType;
import hu.temetkezes.demo.models.CredentialEntity;
import hu.temetkezes.demo.models.User;

public interface UserDataService {
    void updateLoginAttempt(String email, LoginType loginType);
    User getUserByEmail(String email);
    User getUserByUserId(String userId);
    CredentialEntity getUserCredentialsById(Long id);
}
