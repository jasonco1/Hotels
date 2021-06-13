package hotel_booking_site.domain;

public class BookingInfo {
	
	public Booking booking;
	public Room room;
	public Hotel hotel;
	
	public BookingInfo(Booking booking, Room room, Hotel hotel) {
		this.booking = booking;
		this.room = room;
		this.hotel = hotel;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking == null) ? 0 : booking.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		BookingInfo other = (BookingInfo) obj;
		if (booking == null)
		{
			if (other.booking != null)
				return false;
		} else if (!booking.equals(other.booking))
			return false;
		if (hotel == null)
		{
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (room == null)
		{
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

}
