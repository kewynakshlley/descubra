package br.mock.descubra;
/**
 * API for a service that provide data about events theirs respective administrators.
 * 
 * @author Kewyn Akshlley
 */

import java.util.List;

public interface DescubraService {

	/**
	 * Retrieve an event.
	 * 
	 * @param eventId The id of an event.
	 * 
	 * @return The event identified by an id.
	 * 
	 * @throws DataNotFoundException if an event is not found.
	 */
	public Event getEvent(long eventId) throws DataNotFoundException;

	/**
	 * Retrieve all events.
	 * 
	 * @return An list with all events.
	 */
	public List<Event> getAllEvents();

	/**
	 * Inserts a new event into database.
	 * 
	 * @param event The event that will be inserted.
	 * 
	 * @throws DataAlreadyExistsException When the evet being added already exists.
	 */
	public void addEvent(Event event) throws DataAlreadyExistsException;

	/**
	 * Update an event.
	 * 
	 * @param event   The event already updated.
	 * 
	 * @param eventId The id of the event that will be updated.
	 * 
	 * @throws DataNotFoundException if the event is not found.
	 */
	public void updateEvent(Event event, long eventId) throws DataNotFoundException;

	/**
	 * Deletes an event by his id.
	 * 
	 * @param eventId The id of the event that will be deleted.
	 * 
	 * @throws DataNotFoundException if the event is not found.
	 */
	public void deleteEvent(long eventId) throws DataNotFoundException;

	/**
	 * Retrieve all events of a given administrator.
	 * 
	 * @return All events of a given administrator.
	 * @param administratorId The id of an administrator.
	 */
	public List<Event> getAllEventsOfAdministrator(long administratorId);

	/**
	 * Retrieve an administrator.
	 * 
	 * @param id The id of an administrator.
	 * 
	 * @return The administrator related by a given id.
	 * 
	 * @throws DataNotFoundException if an administrator is not found.
	 */
	public Administrator getAdministrator(long administratorId) throws DataNotFoundException;

	/**
	 * Retrieve a list with all administrators.
	 * 
	 * @return An list with all administrators.
	 */
	public List<Administrator> getAllAdministrators();

	/**
	 * Inserts an new administrator into database.
	 * 
	 * @param administrator The administrator that will be added into database.
	 * 
	 * @throws DataAlreadyExistsException if the administrator being added already
	 *                                    exists.
	 */
	public void addAdministrator(Administrator administrator) throws DataAlreadyExistsException;

	/**
	 * Updates an administrator by his id.
	 * 
	 * @param administrator   The administrator with updated informations.
	 * 
	 * @param administratorId The id of the administrator that will be updated.
	 * 
	 * @throws DataNotFoundException if the administrator being added is not found.
	 */
	public void updateAdministrator(Administrator administrator, long administratorId) throws DataNotFoundException;

	/**
	 * Deletes an administrator by his id.
	 * 
	 * @param administratorId The id of the administrator being deleted.
	 * 
	 * @throws DataNotFoundException if the administrator being added is not found.
	 */
	public void deleteAdministrator(long administratorId) throws DataNotFoundException;

}
