package ticket;

import date.Date;

/**
 * The Class Ticket.
 */
public class TicketWith extends Ticket{
	
	protected Date date_entree;
	protected Date date_sortie;
	public TicketWith(Date date_entree, Date date_sortie) {
		this.date_entree = date_entree;
		this.date_sortie = date_sortie;
	}
	public Date getDate_entree() {
		return date_entree;
	}
	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}
	public Date getDate_sortie() {
		return date_sortie;
	}
	public void setDate_sortie(Date date_sortie) {
		this.date_sortie = date_sortie;
	}
	@Override
	public boolean isTicketWith() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
