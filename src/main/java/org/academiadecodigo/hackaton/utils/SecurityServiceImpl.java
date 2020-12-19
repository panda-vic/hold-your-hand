package org.academiadecodigo.hackaton.utils;

import org.academiadecodigo.hackaton.persistence.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityServiceImpl implements SecurityService{

    private Map<Integer, String> securityMap = new HashMap<>();

    @Override
    public void add(Integer id, String password) {
        securityMap.put(id, Security.getHash(password));
    }

    @Override
    public String get(Integer id) {
        return securityMap.get(id);
    }

    @Override
    public void delete(Integer id) {
        securityMap.remove(id);
    }
}
