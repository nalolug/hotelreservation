package learning.systemdesign.hotelreservation.controller;

import learning.systemdesign.hotelreservation.model.Hotel;
import learning.systemdesign.hotelreservation.repository.HotelReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelReservationController {

    @Autowired
    HotelReservationRepository hotelReservationRepository;

    @GetMapping("/reservation") //String city, String startDate, String endDate, int userId
    List<Hotel> searchAvailableRooms(@RequestParam String city) {
        System.out.println("city name: " + city);
        return hotelReservationRepository.findByCity(city);
    }
}
