package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rooms {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    int roomNumber;

    String roomName;

    String hotelId;

    int roomType;
}
