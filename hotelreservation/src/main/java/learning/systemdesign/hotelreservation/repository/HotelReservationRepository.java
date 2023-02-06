package learning.systemdesign.hotelreservation.repository;

import learning.systemdesign.hotelreservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface HotelReservationRepository extends JpaRepository<Hotel, Integer> {
    @Query(value = "SELECT h FROM Hotel h WHERE h.city = ?1")
    List<Hotel> findByCity(String city);
}
