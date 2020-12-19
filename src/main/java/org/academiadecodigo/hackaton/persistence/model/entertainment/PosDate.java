package org.academiadecodigo.hackaton.persistence.model.entertainment;

import javax.persistence.Entity;

@Entity
public class PosDate extends Entertainment {

    @Override
    public EntertainmentType getType() {
        return EntertainmentType.POS_DATE;
    }
}
