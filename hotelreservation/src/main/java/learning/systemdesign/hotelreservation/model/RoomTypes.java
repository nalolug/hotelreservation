package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RoomTypes {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    String type;
}
