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

import hotel_booking_site.domain.Customer;
import hotel_booking_site.repository.CustomersRepository;
import hotel_booking_site.services.CustomerDataService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
public class CustomerDataServiceTest {
	
	@MockBean
	CustomersRepository customersRepository;
	
	@Autowired
	CustomerDataService customerDataService;
	
	@BeforeEach
	public void setUpEach() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void customerDataServiceShouldPersistNewCustomer() {
	
	Customer customer = new Customer("firstName", "lastName", "email@email.com", "password", 0);
	given(customersRepository.save(customer)).willReturn(customer); 
	
	assertThat(true).isEqualTo(customerDataService.persistNewCustomer(customer));

	}
}
