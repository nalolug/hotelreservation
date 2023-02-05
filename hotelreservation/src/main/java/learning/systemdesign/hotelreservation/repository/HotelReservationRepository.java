package learning.systemdesign.hotelreservation.repository;

import learning.systemdesign.hotelreservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface HotelReservationRepository extends JpaRepository<Hotel, Integer> {
    @Override
    Optional<Hotel> findById(Integer integer);
}
