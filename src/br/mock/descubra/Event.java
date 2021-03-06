package br.mock.descubra;

/**
 * Represents the event that will be shown to mobile application users of the Descubra.
 * 
 * @author Kewyn Akshlley
 *
 */
public class Event {
	private long eventId;
	private long administratorId;
	private String name;
	private String description;
	private String category;
	private String date;
	private String hour;
	private int latitude;
	private int longitude;

	public static final int DEFAULT_EVENT_COORDINATES = -1;
	public static final long DEFAULT_EVENT_ID = -1;

	/**
	 * Default constructor.
	 */
	public Event() {
		this(DEFAULT_EVENT_ID, Administrator.DEFAULT_ADM_ID, null, null, null, null, null, DEFAULT_EVENT_COORDINATES,
				DEFAULT_EVENT_COORDINATES);
	}

	/**
	 * Constructor
	 * 
	 * @param eventId         The id of this event.
	 * @param administratorId The id of the administrator that created this event.
	 * @param name            The name of this event.
	 * @param description     The description of this event.
	 * @param category        The category of this event.
	 * @param date            The date of this event.
	 * @param hour            The hour of this event.
	 * @param latitude        The latitude of this event.
	 * @param longitude       The longitude of this event.
	 */
	public Event(long eventId, long administratorId, String name, String description, String category, String date,
			String hour, int latitude, int longitude) {
		this.eventId = eventId;
		this.administratorId = administratorId;

		this.name = name;
		this.description = description;
		this.category = category;
		this.date = date;
		this.hour = hour;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Returns the id of this event.
	 * 
	 * @return the id of this event.
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * Changes the id of this event.
	 * 
	 * @param eventId The new id for this event.
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * Returns the id of the administrator that created this event.
	 * 
	 * @return the id of the administrator that created this event.
	 */
	public long getAdministratorId() {
		return administratorId;
	}

	/**
	 * Changes the id of the administrator that created this event.
	 * 
	 * @param administratorId The new id of the administrator that created this
	 *                        event.
	 */
	public void setAdministratorId(long administratorId) {
		this.administratorId = administratorId;
	}

	/**
	 * Returns the name of this event.
	 * 
	 * @return the name of this event.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes the name of this event.
	 * 
	 * @param name The new name for this event.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description of this event.
	 * 
	 * @return the description of this event.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Changes the description of this event.
	 * 
	 * @param description The new description for this event.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the category of this event.
	 * 
	 * @return the category of this event.
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Changes the category of this event.
	 * 
	 * @param category The new category for this event.
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns the date of this event.
	 * 
	 * @return the date of this event.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Changes the date of this event.
	 * 
	 * @param date The new date for this event.
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Returns the hour of this event.
	 * 
	 * @return the hour of this event.
	 */
	public String getHour() {
		return hour;
	}

	/**
	 * Changes the hour of this event.
	 * 
	 * @param hour The new hour for this event.
	 */
	public void setHour(String hour) {
		this.hour = hour;
	}

	/**
	 * Returns the latitude of this event.
	 * 
	 * @return the latitude of this event.
	 */
	public int getLatitude() {
		return latitude;
	}

	/**
	 * Changes the latitude of this event.
	 * 
	 * @param latitude The new latitude for this event.
	 */
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	/**
	 * Returns the longitude of this event.
	 * 
	 * @return the longitude of this event.
	 */
	public int getLongitude() {
		return longitude;
	}

	/**
	 * Changes the longitude of this event.
	 * 
	 * @param longitude The new longitude for this event.
	 */
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", administratorId=" + administratorId + ", name=" + name
				+ ", description=" + description + ", category=" + category + ", date=" + date + ", hour=" + hour
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (administratorId ^ (administratorId >>> 32));
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (eventId ^ (eventId >>> 32));
		result = prime * result + ((hour == null) ? 0 : hour.hashCode());
		result = prime * result + latitude;
		result = prime * result + longitude;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (administratorId != other.administratorId)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventId != other.eventId)
			return false;
		if (hour == null) {
			if (other.hour != null)
				return false;
		} else if (!hour.equals(other.hour))
			return false;
		if (latitude != other.latitude)
			return false;
		if (longitude != other.longitude)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
