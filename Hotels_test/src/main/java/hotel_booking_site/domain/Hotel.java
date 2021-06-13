package hotel_booking_site.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hotels_table")
public class Hotel {
	
	@Id
	private int id;
	private String name;
	private String street_address;
	private String city;
	private String state;
	private String country;
	private String zip_code;
	private String phone;
	private int number_of_stars;
	private String image;
	private double average_rating;
	private String amenities;
	private String landmarks;
	
	public Hotel() { }

	public Hotel(int id, String name, String street_address, String city, String state, String country, String zip_code,
	      String phone, int number_of_stars, String image, double average_rating, String amenities, String landmarks)
	{
		super();
		this.id = id;
		this.name = name;
		this.street_address = street_address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip_code = zip_code;
		this.phone = phone;
		this.number_of_stars = number_of_stars;
		this.image = image;
		this.average_rating = average_rating;
		this.amenities = amenities;
		this.landmarks = landmarks;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStreet_address()
	{
		return street_address;
	}

	public void setStreet_address(String street_address)
	{
		this.street_address = street_address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getZip_code()
	{
		return zip_code;
	}

	public void setZip_code(String zip_code)
	{
		this.zip_code = zip_code;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public int getNumber_of_stars()
	{
		return number_of_stars;
	}

	public void setNumber_of_stars(int number_of_stars)
	{
		this.number_of_stars = number_of_stars;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public double getAverage_rating()
	{
		return average_rating;
	}

	public void setAverage_rating(double average_rating)
	{
		this.average_rating = average_rating;
	}

	public String getAmenities()
	{
		return amenities;
	}

	public void setAmenities(String amenities)
	{
		this.amenities = amenities;
	}

	public String getLandmarks()
	{
		return landmarks;
	}

	public void setLandmarks(String landmarks)
	{
		this.landmarks = landmarks;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amenities == null) ? 0 : amenities.hashCode());
		long temp;
		temp = Double.doubleToLongBits(average_rating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((landmarks == null) ? 0 : landmarks.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number_of_stars;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street_address == null) ? 0 : street_address.hashCode());
		result = prime * result + ((zip_code == null) ? 0 : zip_code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hotel other = (Hotel) obj;
		if (amenities == null)
		{
			if (other.amenities != null)
				return false;
		} else if (!amenities.equals(other.amenities))
			return false;
		if (Double.doubleToLongBits(average_rating) != Double.doubleToLongBits(other.average_rating))
			return false;
		if (city == null)
		{
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null)
		{
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (image == null)
		{
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (landmarks == null)
		{
			if (other.landmarks != null)
				return false;
		} else if (!landmarks.equals(other.landmarks))
			return false;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number_of_stars != other.number_of_stars)
			return false;
		if (phone == null)
		{
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (state == null)
		{
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street_address == null)
		{
			if (other.street_address != null)
				return false;
		} else if (!street_address.equals(other.street_address))
			return false;
		if (zip_code == null)
		{
			if (other.zip_code != null)
				return false;
		} else if (!zip_code.equals(other.zip_code))
			return false;
		return true;
	}

}