package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import date.impl.DateTicket;
import date.inter.IDateTicket;
import ticket.impl.TicketWith;
import ticket.inter.ITicketWith;

public class TestTicket {

	private ITicketWith ticket;
	
	@Before
	public void instanciation() {
		this.ticket = new TicketWith(new DateTicket(16, 4, 16, 30, 30));
	}
	
	@Test
	public void setterGetter() {
		IDateTicket date = new DateTicket(18,4,16,30,30);
		ticket.setDateTicket(date);
		Assert.assertEquals(date, ticket.getDateTicket());
	}
	
	@Test
	public void isWith() {
		Assert.assertEquals(true, ticket.isWith());
	}
	
}
