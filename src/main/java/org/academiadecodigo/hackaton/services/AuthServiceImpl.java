package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.User;

import org.academiadecodigo.hackaton.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An {@link AuthService} implementation
 */
@Service
public class AuthServiceImpl implements AuthService {

    private UserService userService;
    private User accessingUser;

    /**
     * Sets the customer service
     *
     * @param userService the customer service to set
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean authenticate(String email, String password) {

        User user = userService.getByEmail(email);
        String pass = Security.getHash(password);

        if(user!=null && user.getPassword().equals(pass)){
            accessingUser = user;
            return true;
        }

        return false;
    }

    /**
     * @see AuthService#getAccessingUser()
     */
    @Override
    public User getAccessingUser() {
        return accessingUser;
    }

    @Override
    public void signOut() {
        accessingUser = null;
    }

    @Override
    public void setAccessingUser(User user) {
        accessingUser = user;
    }

    @Override
    public boolean loggedIn() {
        return accessingUser != null;
    }
}
