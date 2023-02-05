package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rooms")
public class Room {
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "room_number")
    int roomNumber;

    @Column(name = "room_name")
    String roomName;

    @Column(name = "hotel_id")
    String hotelId;

    @Column(name = "room_type_id")
    int roomType;
}
