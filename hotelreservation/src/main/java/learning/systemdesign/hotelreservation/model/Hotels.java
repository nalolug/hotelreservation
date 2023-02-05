package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;

@Entity
public class Hotels {
    int id;

    String name;

    String addressLine;

    String city;

    String state;

    String country;

    int pinCode;
}
