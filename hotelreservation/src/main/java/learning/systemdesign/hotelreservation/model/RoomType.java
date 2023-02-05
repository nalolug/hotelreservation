package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "room_types")
@Setter @Getter
public class RoomType {
    @Column(name = "room_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "room_type")
    String type;

    @OneToMany(targetEntity = Room.class)
    List<Room> rooms;
}
