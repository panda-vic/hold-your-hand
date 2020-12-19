package org.academiadecodigo.hackaton.utils;

import org.academiadecodigo.hackaton.persistence.model.User;

public interface SecurityService {

    void add(Integer id, String password);

    String get(Integer id);

    void delete(Integer id);
}
