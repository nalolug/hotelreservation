package learning.systemdesign.hotelreservation.controller;

import learning.systemdesign.hotelreservation.model.Hotels;
import learning.systemdesign.hotelreservation.repository.HotelReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HotelReservationController {

    @Autowired
    HotelReservationRepository hotelReservationRepository;

    @PostMapping("/reservation") //String city, String startDate, String endDate, int userId
    Optional<Hotels> searchAvailableRooms() {
        return hotelReservationRepository.findById(0);
    }
}
