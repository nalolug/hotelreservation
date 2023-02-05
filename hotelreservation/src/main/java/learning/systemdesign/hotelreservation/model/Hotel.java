package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "hotels")
@Setter @Getter
public class Hotel {
    @Column(name = "hotel_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "hotel_name")
    String name;

    @Column(name = "hotel_address_line")
    String addressLine;

    @Column(name = "hotel_city")
    String city;

    @Column(name = "hotel_state")
    String state;

    @Column(name = "hotel_country")
    String country;

    @Column(name = "hotel_pincode")
    int pinCode;

    @OneToMany(targetEntity = Room.class)
    List<Room> rooms;
}
