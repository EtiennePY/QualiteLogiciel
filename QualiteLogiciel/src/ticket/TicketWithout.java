package ticket;

public class TicketWithout extends Ticket{
	private final static TicketWithout TICKETWITHOUT = new TicketWithout();
	public TicketWithout() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isTicketWith() {
		return false;
	}
	public static TicketWithout instance(){
		return TicketWithout.TICKETWITHOUT;
	}

}
