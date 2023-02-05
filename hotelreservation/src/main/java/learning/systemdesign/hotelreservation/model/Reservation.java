package learning.systemdesign.hotelreservation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "reservations")
@Setter @Getter
public class Reservation {
    @Column(name = "reservation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    int id;

    @Column(name = "reservation_time")
    java.sql.Date reservationTime;

    @Column(name = "in_date")
    java.sql.Date dateTimeIn;

    @Column(name = "out_date")
    Date dateTimeOut;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "guest_id")
    Guest guest;
}
