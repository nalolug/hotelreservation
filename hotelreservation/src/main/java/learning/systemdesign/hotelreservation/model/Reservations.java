package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;

@Entity
public class Reservations {
    int id;

    long dateTimeIn;

    long dateTimeOut;

    int roomId;

    int guestId;
}
