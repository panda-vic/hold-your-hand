package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.User;

import java.util.List;

public interface UserService {

    User add(User user);

    User get(Integer id);

    List<User> list();

    void delete(Integer id);

    User getByEmail(String email);

    boolean EmailInUse(String email);

}
