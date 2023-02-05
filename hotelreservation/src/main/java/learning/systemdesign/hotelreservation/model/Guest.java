package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "guests")
@Setter @Getter
public class Guest {
    @Column(name = "guest_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "guest_name")
    String name;

    @Column(name = "guest_address_line")
    String address;

    @Column(name = "guest_phone_number")
    String phoneNumber;

    @OneToMany(targetEntity = Reservation.class)
    List<Reservation> reservations;
}
