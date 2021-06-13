//Reference: https://www.baeldung.com/spring-boot-json
package hotel_booking_site.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel_booking_site.domain.Customer;
import hotel_booking_site.domain.PackageBooking;
import hotel_booking_site.domain.RoomInfo;
import hotel_booking_site.services.AvailableRoomsService;
import hotel_booking_site.services.CustomerDataService;
import hotel_booking_site.services.NewBookingService;
/*
 * This HTTP REST Controller provides the following APIs:
 *  
 * 1. Returns list of available rooms as RoomInfo objects via getAvailableRoomsList() 
 * 2. Persists new PackageBooking object to database via ("hotels/api/newPackageBooking") 
 * 3. Deletes booking by PackageBooking via idcancelPackageBookingById() 
 * 4. Persists new Customer object to database via ("/hotels/api/createNewCustomer/") 
 * See individual routes for usage instructions
 */
@RestController
public class HotelsRestController {

	@Autowired 
	AvailableRoomsService availableRoomsService;
	
	@Autowired
	NewBookingService newBookingService;
	
	@Autowired
	CustomerDataService customerDataService;
	
	//getAvailableRoomsList()
	//
	//Required parameters: city, checkInDate, checkOutDate
	//Usage: /hotels/api/getRooms/?city=Las%20Vegas&checkInDate=6/01/2022&checkOutDate=6/07/2021
	//Returns list of available rooms as a RoomInfo object in a JSON array 
	@GetMapping("/hotels/api/getRooms/")
	public ResponseEntity<List<RoomInfo>> getAvailableRoomsList(
			@RequestParam("city") String city, 
			@RequestParam("checkInDate") String checkInDate,
			@RequestParam("checkOutDate") String checkOutDate
			){
	
		//Query database to find available rooms
		List<RoomInfo> roomInfoList = availableRoomsService.getRoomInfo(city);
		
		if (roomInfoList == null) {
			return new ResponseEntity<List<RoomInfo>>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<RoomInfo>>(roomInfoList, HttpStatus.OK);
		}
	}
	
	//Receives PackageBooking object in JSON format from PackageBookings site
	//Converts to a Java PackageBooking object and persists to the database
	@PostMapping("/hotels/api/newPackageBooking/")
	public ResponseEntity<PackageBooking> create(@RequestBody PackageBooking packageBooking){
		
		newBookingService.persistNewPackageBooking(packageBooking);
		return new ResponseEntity<PackageBooking>(HttpStatus.OK);
	}
		
	//cancelPackageBookingById()
	//
	//Deletes existing PackageBooking from database using the id
	//Returns HTTP status code
	@DeleteMapping("/hotels/api/cancelPackageBooking/{id}")
	public ResponseEntity<PackageBooking> cancelPackageBookingById(
			@PathVariable("id") int id) {
		
		//@ToDo: Test try/catch
		try {
		newBookingService.cancelPackageHotelBooking(id);
		return new ResponseEntity<PackageBooking>(HttpStatus.OK);
		}
		catch(Exception ex){
		return new ResponseEntity<PackageBooking>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Receives Customer object in JSON format from PackageBookings site
	//Converts to Java Customer object and persists to database
	@PostMapping("/hotels/api/createNewCustomer/")
	public ResponseEntity<Customer> create(@RequestBody Customer customer){
		
		customerDataService.persistNewCustomer(customer);
		return new ResponseEntity<Customer>(HttpStatus.OK);
	}
	
}
