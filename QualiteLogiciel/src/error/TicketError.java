package error;

public class TicketError extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TicketError(){
		super("Le client n'a pas de ticket !");
	}
	
}
