package org.academiadecodigo.hackaton.services;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;
import org.academiadecodigo.hackaton.persistence.model.entertainment.EntertainmentType;

import java.util.List;

public interface EntertainmentService {

    Entertainment get(Integer id);

    List<Entertainment> list();

    void delete(Integer id);

    void add(Entertainment entertainment);

    List<Entertainment> listByType(EntertainmentType entertainmentType);
}
