package org.academiadecodigo.hackaton.persistence.model.entertainment;

import javax.persistence.Entity;

@Entity
public class PreDate extends Entertainment {

    @Override
    public EntertainmentType getType() {
        return EntertainmentType.PRE_DATE;
    }
}
