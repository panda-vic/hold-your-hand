package org.academiadecodigo.hackaton.persistence.model;

import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;

import javax.persistence.Entity;

import java.util.ArrayList;
import java.util.List;


public class Pacote extends AbstractModel{

    private List<Entertainment> entertainmentList = new ArrayList<>();

    public void addEntertainment(Entertainment entertainment){
        entertainmentList.add(entertainment);
    }

    public List<Entertainment> getList(){
        return entertainmentList;
    }

}
