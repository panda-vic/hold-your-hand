package org.academiadecodigo.hackaton.persistence.model.entertainment;

import javax.persistence.Entity;

@Entity
public class Restaurant extends Entertainment {

    @Override
    public EntertainmentType getType() {
        return EntertainmentType.RESTAURANT;
    }
}
