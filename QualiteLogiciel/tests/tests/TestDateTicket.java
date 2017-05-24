package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import date.impl.DateTicket;
import date.inter.IDateTicket;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDateTicket.
 */
public class TestDateTicket {
	
	/** The date. */
	private IDateTicket date;
	
	/**
	 * Instanciation.
	 */
	@Before
	public void instanciation() {
		this.date = new DateTicket(16, 4, 16, 30, 30);
	}
	
	/**
	 * Settersgetters.
	 */
	@Test
	public void settersgetters() {
		date.setJour(1);
		date.setMois(2);
		date.setHeure(3);
		date.setMinute(4);
		date.setSeconde(5);
		Assert.assertEquals(1, date.getJour());
		Assert.assertEquals(2, date.getMois());
		Assert.assertEquals(3, date.getHeure());
		Assert.assertEquals(4, date.getMinute());
		Assert.assertEquals(5, date.getSeconde());
		
	}

}
