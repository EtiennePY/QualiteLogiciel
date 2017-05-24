package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import date.impl.DateTicket;
import date.inter.IDateTicket;
import ticket.impl.TicketWith;
import ticket.inter.ITicketWith;

// TODO: Auto-generated Javadoc
/**
 * The Class TestTicket.
 */
public class TestTicket {

	/** The ticket. */
	private ITicketWith ticket;
	
	/**
	 * Instanciation.
	 */
	@Before
	public void instanciation() {
		this.ticket = new TicketWith(new DateTicket(16, 4, 16, 30, 30));
	}
	
	/**
	 * Setter getter.
	 */
	@Test
	public void setterGetter() {
		IDateTicket date = new DateTicket(18,4,16,30,30);
		ticket.setDateTicket(date);
		Assert.assertEquals(date, ticket.getDateTicket());
	}
	
	/**
	 * Checks if is with.
	 */
	@Test
	public void isWith() {
		Assert.assertEquals(true, ticket.isWith());
	}
	
}
