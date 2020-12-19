package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;

import java.util.List;

public interface JpaEntertainmentService {

    /**
     * Gets the customer with the given id
     *
     * @param id the business id
     * @return the business
     */
    Entertainment get(Integer id);


    /**
     * Saves a business
     *
     * @param business the business to save
     * @return the saved customer
     */
    Entertainment save(Entertainment business);

    /**
     * Deletes a business
     *
     * @param id the business id
     */
    void delete(Integer id);

    /**
     * Gets a list of the business
     *
     * @return the business list
     */
    List<Entertainment> list();

    List<Entertainment> listByType(String businessType);
}
