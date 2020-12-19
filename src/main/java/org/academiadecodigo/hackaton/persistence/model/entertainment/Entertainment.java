package org.academiadecodigo.hackaton.persistence.model.entertainment;


import org.academiadecodigo.hackaton.persistence.model.AbstractModel;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity(name = "entertainment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Entertainment extends AbstractModel {

    private String name;
    private String description;
    private Integer avgPrice;
    private String email;
    private String phone;
    private String workingHours;
    private String closed;
    private EntertainmentType Type;

    public abstract EntertainmentType getType();

    public void setEntertainmentType(EntertainmentType entertainmentType) {
        this.Type = entertainmentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Integer avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    @Override
    public String toString() {
        return "Entertainment{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", avgPrice=" + avgPrice +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", workingHours='" + workingHours + '\'' +
                '}';
    }
}
