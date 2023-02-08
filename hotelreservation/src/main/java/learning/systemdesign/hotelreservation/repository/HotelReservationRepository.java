package learning.systemdesign.hotelreservation.repository;

import learning.systemdesign.hotelreservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface HotelReservationRepository extends JpaRepository<Hotel, Integer> {

    @Query(value =
            "SELECT * FROM hotels " +
                    " WHERE hotel_city = ?1 and hotel_id " +
                    " IN (SELECT hotel_id FROM rooms " +
                    " WHERE room_type_id " +
                    " IN (SELECT room_type_id FROM room_types WHERE room_type = ?2) " +
                    " AND room_id " +
                    " NOT IN (SELECT room_id FROM reservations WHERE in_date between ?3 and ?4" +
                    " OR out_date between ?3 and ?4" +
                    " OR in_date < ?3 and out_date > ?4)" +
                    ")", nativeQuery = true)
    List<Hotel> findAllHotelsWithAvailableRooms(String city, String type, String start, String end);
}
