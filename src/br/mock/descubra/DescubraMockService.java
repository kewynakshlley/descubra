package br.mock.descubra;
/**
 * A mock implementation of the Descubra Service interface, which only uses data in memory.
 * 
 * @author Kewyn Akshlley
 */

import java.util.ArrayList;


import java.util.List;

public class DescubraMockService implements DescubraService{
	private List<Administrator> administrators;
	private List<Event> events;
	private static int nextAdministratorId = 0;
	private static int nextEventId = 0;
	
	private synchronized static int getNextEventId() {
		int id =  nextEventId++;
		return id;
	}
	
	private synchronized static int getNextAdministratorId() {
		int id = nextAdministratorId++;
		return id;
	}
	
	public DescubraMockService() {
		this.events = new ArrayList<>();
		this.administrators = new ArrayList<>();
	}

	@Override
	public Event getEvent(long eventId) throws DataNotFoundException {
		for(Event evt: this.events) {
			if(evt.getEventId() == eventId)
				return evt;
		}
		throw new DataNotFoundException("The event that you are trying to retrieve dont exists.");
	}

	@Override
	public List<Event> getAllEvents() {
		return this.events;
	}

	@Override
	public void addEvent(Event event) throws DataAlreadyExistsException {

		if(this.events.contains(event)) {
			throw new DataAlreadyExistsException("The event being added into database already exists.");
		}else {
			if(event.getEventId() == Event.DEFAULT_EVENT_ID) {
				event.setEventId(getNextEventId());
			}
			this.events.add(event);
		}
	}

	@Override
	public void updateEvent(Event event, long eventId) throws DataNotFoundException {
		for(Event evt: this.events) {
			if(evt.getEventId() == eventId) {
				this.events.remove(evt);
				this.events.add(event);
				return;
			}
		}throw new DataNotFoundException("The event being updated dont exists.");
		
	}

	@Override
	public void deleteEvent(long eventId) throws DataNotFoundException {
		for(Event evt: this.events) {
			if(evt.getEventId() == eventId) {
				this.events.remove(evt);
				return;
			}
		}throw new DataNotFoundException("The event being deleted dont exists.");
		
	}

	@Override
	public List<Event> getAllEventsOfAdministrator(long administratorId) {
		List<Event> eventAux = new ArrayList<>();
		for(Event evt: this.events) {
			if(evt.getAdministratorId() == administratorId) {
				eventAux.add(evt);
			}
		}return eventAux;
		
		
		
	}

	@Override
	public Administrator getAdministrator(long admnistratorId) throws DataNotFoundException {
		for(Administrator admnt: this.administrators) {
			if(admnt.getAdministratorId() == admnistratorId) {
				return admnt;
			}
		}
		throw new DataNotFoundException("The admnistrator that you are tryng to retrieve dont exists.");
	}

	@Override
	public List<Administrator> getAllAdministrators() {
		return this.administrators;
	}

	@Override
	public void addAdministrator(Administrator administrator) throws DataAlreadyExistsException {
		if(!this.administrators.contains(administrator)) {
			if(administrator.getAdministratorId() == Administrator.DEFAULT_ADM_ID) {
				administrator.setAdministratorId(getNextAdministratorId());
			}
			this.administrators.add(administrator);
		}else {
			throw new DataAlreadyExistsException("The administrator being added already exists.");
		}
		
	}

	@Override
	public void updateAdministrator(Administrator administrator, long administratorId) throws DataNotFoundException {
		for(Administrator admnt: this.administrators) {
			if(admnt.getAdministratorId() == administratorId) {
				this.administrators.remove(admnt);
				try {
					addAdministrator(administrator);
				} catch (DataAlreadyExistsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}throw new DataNotFoundException("The admnistrator being updated dont exists.");
		
	}

	@Override
	public void deleteAdministrator(long administratorId) throws DataNotFoundException {
		for(Administrator admnt: this.administrators) {
			if(admnt.getAdministratorId() == administratorId) {
				this.administrators.remove(admnt);
				return;
			}
		}throw new DataNotFoundException("The administrator being deleted dont exists.");
		
	}

}
