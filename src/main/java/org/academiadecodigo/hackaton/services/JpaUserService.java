package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.User;

import java.util.List;

public interface JpaUserService {

    /**
     * Gets the customer with the given id
     *
     * @param id the customer id
     * @return the customer
     */
    User get(Integer id);


    /**
     * Saves a customer
     *
     * @param user the customer to save
     * @return the saved customer
     */
    User save(User user);

    /**
     * Deletes a customer
     *
     * @param id the customer id
     */
    void delete(Integer id);

    /**
     * Gets a list of the customers
     *
     * @return the customers list
     */
    List<User> list();
}
