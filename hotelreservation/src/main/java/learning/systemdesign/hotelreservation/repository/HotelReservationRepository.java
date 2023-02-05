package learning.systemdesign.hotelreservation.repository;

import learning.systemdesign.hotelreservation.model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
public interface HotelReservationRepository extends JpaRepository<Hotels, Integer> {
    @Override
    Optional<Hotels> findById(Integer integer);
}
