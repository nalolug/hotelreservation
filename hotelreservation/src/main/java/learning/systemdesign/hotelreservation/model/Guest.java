package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guests")
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
}
