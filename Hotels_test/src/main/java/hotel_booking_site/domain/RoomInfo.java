package hotel_booking_site.domain;

public class RoomInfo {
	
	public Room room;
	public Hotel hotel;
	
	public RoomInfo() { }
	
	public RoomInfo(Room room, Hotel hotel)
	{
		this.room = room;
		this.hotel = hotel;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
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
		RoomInfo other = (RoomInfo) obj;
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
