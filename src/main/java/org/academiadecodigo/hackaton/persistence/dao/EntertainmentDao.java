package org.academiadecodigo.hackaton.persistence.dao;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;

import java.util.List;

public interface EntertainmentDao extends Dao<Entertainment> {

    List<Entertainment> findAllByType(String entertainmentType);

}
