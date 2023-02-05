package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;

@Entity
public class Rooms {
    int id;

    int roomNumber;

    String roomName;

    String hotelId;

    int roomType;
}
