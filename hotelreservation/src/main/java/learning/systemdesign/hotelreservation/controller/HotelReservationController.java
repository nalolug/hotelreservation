package learning.systemdesign.hotelreservation.controller;

import learning.systemdesign.hotelreservation.model.Hotel;
import learning.systemdesign.hotelreservation.repository.HotelReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HotelReservationController {

    @Autowired
    HotelReservationRepository hotelReservationRepository;

    @PostMapping("/reservation") //String city, String startDate, String endDate, int userId
    List<Hotel> searchAvailableRooms() {
        return hotelReservationRepository.findById(0);
    }
}
