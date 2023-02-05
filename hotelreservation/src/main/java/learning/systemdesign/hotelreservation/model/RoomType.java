package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room_types")
public class RoomType {
    @Column(name = "room_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "room_type")
    String type;
}
