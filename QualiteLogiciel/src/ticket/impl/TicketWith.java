package ticket.impl;

import date.inter.IDateTicket;
import ticket.inter.ITicketWith;

// TODO: Auto-generated Javadoc
/**
 * The Class Ticket.
 */
public class TicketWith extends AbstractTicket implements ITicketWith {

  
  /** The date ticket. */
  private IDateTicket dateTicket;
  
  /**
   * Instantiates a new ticket with.
   *
   * @param dateTicket the date ticket
   */
  public TicketWith(final IDateTicket dateTicket) {
    super();
    this.dateTicket = dateTicket;
  }

  /**
   * Gets the date ticket.
   *
   * @return the date ticket
   */
  public IDateTicket getDateTicket() {
    return dateTicket;
  }

  /**
   * Sets the date ticket.
   *
   * @param dateTicket the new date ticket
   */
  public void setDateTicket(final IDateTicket dateTicket) {
    this.dateTicket = dateTicket;
  }


  /**
   * Checks if is with.
   *
   * @return true, if is with
   */
  public boolean isWith() {
    return true;
  }


  
  
  

}
