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

import hotel_booking_site.domain.Hotel;
import hotel_booking_site.domain.Room;
import hotel_booking_site.domain.RoomInfo;
import hotel_booking_site.repository.HotelsRepository;
import hotel_booking_site.repository.RoomsRepository;
import hotel_booking_site.services.AvailableRoomsService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class AvailableRoomsServiceTest {
	
	//Use MockBeans to stub out classes required by AvailableRoomsService
	@MockBean
	private RoomsRepository roomsRepository;
	
	@MockBean
	private HotelsRepository hotelsRepository;
	
	//This is the service being tested
	@Autowired
	private AvailableRoomsService availableRoomsService;
	
	@BeforeEach
	public void setUpEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void availableRoomsServiceShouldReturnValidRoomInfoList() {
	
		//create data to be returned by Mock classes
		Room room = new Room(1, 1, 199.00, 3, "King", 2);
		Hotel hotel = new Hotel(1, "TestHotel", "111 Avenue", "Las Vegas", "Nevada",
				"USA", "10001", "777-777-7777", 5, "img", 5, "Pool", "The Strip");
				
		List<RoomInfo> roomInfoListExpectedResult = new ArrayList<>();
		List<Room> rooms = new ArrayList<>();
		rooms.add(room);
	
		//create stubs for values returned from database by repository classes
		given(roomsRepository.findByCityName("Las Vegas")).willReturn(rooms);
		given(hotelsRepository.findById(1)).willReturn(hotel);
		
		//expected RoomInfo and RoomInfoList objects
		RoomInfo roomInfo = new RoomInfo(room, hotel);
		roomInfoListExpectedResult.add(roomInfo);
		
		List<RoomInfo> roomInfoListActualResult = availableRoomsService.getRoomInfo("Las Vegas");
		assertThat(roomInfoListExpectedResult).isEqualTo(roomInfoListActualResult);
		
	}
}
