package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservations {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    long dateTimeIn;

    long dateTimeOut;

    int roomId;

    int guestId;
}
