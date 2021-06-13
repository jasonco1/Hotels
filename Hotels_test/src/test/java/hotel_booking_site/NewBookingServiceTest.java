package hotel_booking_site;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import hotel_booking_site.domain.Booking;
import hotel_booking_site.repository.BookingsRepository;
import hotel_booking_site.services.NewBookingService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class NewBookingServiceTest {

	@MockBean 
	BookingsRepository bookingsRepository;
	
	@Autowired
	NewBookingService newBookingService;
	
	@BeforeEach
	public void setUpEach(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void newBookingServiceShouldPersistNewBooking() {
	
	Booking booking = new Booking(1, 1, 1, 199.0, "6/1/2021", "6/03/2021", 2);
	given(bookingsRepository.save(booking)).willReturn(booking);
	
	assertThat(true).isEqualTo(newBookingService.persistNewBooking(booking));
	
	}
}
