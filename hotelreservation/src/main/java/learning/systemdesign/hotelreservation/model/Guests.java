package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;

@Entity
public class Guests {
    int id;

    String name;

    String address;

    String phoneNumber;
}
