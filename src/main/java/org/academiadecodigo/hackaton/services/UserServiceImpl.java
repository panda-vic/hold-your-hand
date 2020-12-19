package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.dao.UserDao;
import org.academiadecodigo.hackaton.persistence.model.User;
import org.academiadecodigo.hackaton.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    private Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl(){
        initializeTestUsers();
    }

    @Override
    public User add(User user){

        if (user.getId() == null) {
            user.setId(getNextId());
        }

        userMap.put(user.getId(), user);
        return get(user.getId());
    }

    @Override
    public User get(Integer id){
        return userMap.get(id);
    }

    @Override
    public List<User> list(){
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void delete(Integer id) {
        userMap.remove(id);
    }

    @Override
    public User getByEmail(String email) {

        for (User user: list()){
            if(user.getEmail().equals(email)){
               return user;
            }
        }
        return null;
    }

    @Override
    public boolean EmailInUse(String email) {

        for (User user: list()){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    private Integer getNextId() {
        return userMap.isEmpty() ? 1 : Collections.max(userMap.keySet()) + 1;
    }

    private void initializeTestUsers(){
        User user = new User();
        user.setName("Batata");
        user.setEmail("batata@gmail.com");
        user.setPhone("5345345363");
        user.setPassword(Security.getHash("123"));
        add(user);

        User user1 = new User();
        user1.setName("Alho");
        user1.setEmail("alho@gmail.com");
        user1.setPhone("905345363");
        user1.setPassword(Security.getHash("456"));
        add(user1);
    }
}
