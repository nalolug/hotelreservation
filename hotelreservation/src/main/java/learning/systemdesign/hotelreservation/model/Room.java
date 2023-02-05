package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "rooms")
@Setter @Getter
public class Room {
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "room_number")
    int roomNumber;

    @Column(name = "room_name")
    String roomName;

    @JoinColumn(name = "hotel_id")
    @ManyToOne(cascade = CascadeType.ALL)
    Hotel hotel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_type_id")
    RoomType roomType;
}
