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

    @GetMapping("/hotel/by-city")
    List<Hotel> searchAvailableRooms(@RequestParam String city, @RequestParam String type, @RequestParam String start, @RequestParam String end) {
        System.out.println("city name: " + city + " type: " + type + " start:"+ start + " end:" + end);
        return hotelReservationRepository.findAllHotelsWithAvailableRooms(city, type, start, end);
    }
}
