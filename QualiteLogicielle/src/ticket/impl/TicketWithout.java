package ticket.impl;

import ticket.inter.ITicketWithout;

// TODO: Auto-generated Javadoc
/**
 * The Class TicketWithout.
 */
public class TicketWithout extends AbstractTicket implements ITicketWithout {
  
  /** The Constant TICKETWITHOUT. */
  private static final TicketWithout SINGLETON = new TicketWithout();
  
  /**
   * Instantiates a new ticket without.
   */
  public TicketWithout() {
    super();
  }

  /**
   * Checks if is with.
   *
   * @return true, if is with
   */
  public boolean isWith() {
    return false;
  }
  
  /**
   * Instance.
   *
   * @return the ticket without
   */
  public static TicketWithout instance() {
    return TicketWithout.SINGLETON;
  }

  

}
