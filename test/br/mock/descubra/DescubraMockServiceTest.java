package br.mock.descubra;
/**
 * @author Kewyn Akshlley
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DescubraMockServiceTest {
	private DescubraMockService descubraMockService;
	
	@Before
	public void beforeTests() {
		descubraMockService = new DescubraMockService();
	}

	@Test
	public void testEventMethods() throws DataAlreadyExistsException, DataNotFoundException {
		assertTrue(descubraMockService.getAllEvents().size() == 0);
		descubraMockService.addAdministrator(new Administrator(123, "Kewyn", null, null, null, null, null));
		Event event = new Event(1, 123, "OIP", null, null, null, null, 0, 0);
		descubraMockService.addEvent(event);
		assertTrue(descubraMockService.getAllEvents().size() == 1);		
		try {
			descubraMockService.addEvent(event);
			fail("Should throw exception");
		} catch (DataAlreadyExistsException e) {
			e.printStackTrace();
		}
		assertTrue(descubraMockService.getAllEvents().size() == 1);
		Event event2 = new Event(2, 123, "Hackfest", null, null, null, null, 0, 0);
		descubraMockService.addEvent(event2);
		assertTrue(descubraMockService.getAllEvents().size() == 2);
		
		descubraMockService.updateEvent(new Event(1, 123, "OIPUPDATED", null, null, null, null, 0, 0), 1);
		Event e = descubraMockService.getEvent(1);
		assertTrue(e.getName().equals("OIPUPDATED"));
		
		assertTrue(descubraMockService.getAllEvents().size() == 2);
		assertEquals(2, descubraMockService.getAllEventsOfAdministrator(123).size());
		descubraMockService.deleteEvent(1);
		assertTrue(descubraMockService.getAllEvents().size() == 1);
		
		
		
	}
	
	@Test
	public void testAdministratorMethods() throws DataAlreadyExistsException, DataNotFoundException {
		assertTrue(descubraMockService.getAllAdministrators().size() == 0);
		Administrator adm = new Administrator(123, "Kewyn", null, null, null, null, null);
		descubraMockService.addAdministrator(adm);
		Event event = new Event(1, 123, "OIP", null, null, null, null, 0, 0);
		descubraMockService.addEvent(event);
		assertTrue(descubraMockService.getAllEvents().size() == 1);		
		try {
			descubraMockService.addAdministrator(adm);
			fail("Should throw exception");
		} catch (DataAlreadyExistsException e) {
			e.printStackTrace();
		}
		assertTrue(descubraMockService.getAllAdministrators().size() == 1);
		Administrator adm2 = new Administrator(12, "Lucas", null, null, null, null, null);
		descubraMockService.addAdministrator(adm2);
		assertTrue(descubraMockService.getAllAdministrators().size() == 2);
		
		descubraMockService.updateAdministrator(new Administrator(12, "Gabriel", null, null, null, null, null), 12);
		Administrator a = descubraMockService.getAdministrator(12);
		assertTrue(a.getName().equals("Gabriel"));
		
		assertTrue(descubraMockService.getAllAdministrators().size() == 2);
		assertEquals(1, descubraMockService.getAllEventsOfAdministrator(123).size());
		descubraMockService.deleteAdministrator(12);
		assertTrue(descubraMockService.getAllAdministrators().size() == 1);
	}

}

