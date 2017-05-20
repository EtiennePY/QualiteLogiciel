package ticket.inter;

import date.inter.IDateTicket;

// TODO: Auto-generated Javadoc
/**
 * The Interface ITicketWith.
 */
public interface ITicketWith extends IAbstractTicket {
	
	/**
	 * Gets the date ticket.
	 *
	 * @return the date ticket
	 */
	IDateTicket getDateTicket();
	
	/**
	 * Sets the date ticket.
	 *
	 * @param dateTicket the new date ticket
	 */
	void setDateTicket(IDateTicket dateTicket);
}
