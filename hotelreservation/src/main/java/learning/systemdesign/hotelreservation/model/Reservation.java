package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "in_date")
    long dateTimeIn;

    @Column(name = "out_date")
    long dateTimeOut;

    @Column(name = "room_id")
    int roomId;

    @Column(name = "guest_id")
    int guestId;
}
