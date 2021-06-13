package hotel_booking_site.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotel_booking_site.domain.Hotel;

public interface HotelsRepository extends JpaRepository<Hotel, Long> {
	
	Hotel findById(int id); 
}
