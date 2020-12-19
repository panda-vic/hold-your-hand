package org.academiadecodigo.hackaton.persistence.model.entertainment;

public class Transport extends Entertainment{
    @Override
    public EntertainmentType getType() {
        return EntertainmentType.TRANSPORT;
    }
}
