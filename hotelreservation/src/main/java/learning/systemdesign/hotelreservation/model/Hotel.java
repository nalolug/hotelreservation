package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Hotels")
public class Hotel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    String name;

    String addressLine;

    String city;

    String state;

    String country;

    int pinCode;
}
