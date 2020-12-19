package org.academiadecodigo.hackaton.persistence.model.entertainment;

import javax.persistence.Entity;

@Entity
public class Crazy extends Entertainment {

    @Override
    public EntertainmentType getType() {
        return EntertainmentType.CRAZY;
    }

}
