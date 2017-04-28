package lecteur;

import carte.Carte;
import carte.CarteAbonnement;
import carte.CarteWithout;
import date.Date;
import error.TicketError;
import ticket.Ticket;
import ticket.TicketWith;
import ticket.TicketWithout;

public class LecteurTicketAbonnement {
	
	public LecteurTicketAbonnement() {
		this.ticketClient = TicketWithout.instance();
		this.carteClient = CarteWithout.instance();
	}
	private Carte carteClient;
	private Ticket ticketClient;
	
	public Ticket restitutionTicket() {
		Ticket res = this.getTicketClient();
		this.ticketClient = TicketWithout.instance();
		return res;
	}
	
	public boolean verificationTicket(Ticket ticket) throws TicketError {
		System.out.println("Le lecteur de ticket vérifie le ticket.");
		// Role du SI ???
		return true;
		
	}
	
	public Ticket donneTicket(Date date) {
		return new TicketWith(date);
		
	}
	public CarteAbonnement restitutionCarteAbonnement(boolean retour) {
		if(retour) {
			System.out.println("Un message s'affiche : \"OK\"" );
		} else {
			System.out.println("Un message s'affiche : \"Carte erronée\"" );

		}
		return (CarteAbonnement) this.getCarteClient();
		
	}
	
	public void demandeInsertionCarteAbonnement(CarteAbonnement carte) {
		System.out.println("Un message s'affiche à l'écran du lecteur de carte d'abonnement : \"Insérez carte\"");
	}
	
	public void checkAbonnement(CarteAbonnement carte) {
		this.setCarteClient(carte);
		System.out.println("Le lecteur de carte d'abonnement reçoit la carte d'abonnement.");
	}
	
	public void demandeInsertionTicket() {
		
	}
	
	public void ouvreBarriere() {
		
	}

	public Carte getCarteClient() {
		return carteClient;
	}

	public void setCarteClient(Carte carteClient) {
		this.carteClient = carteClient;
	}

	public Ticket getTicketClient() {
		return ticketClient;
	}

	public void setTicketClient(Ticket ticketClient) {
		this.ticketClient = ticketClient;
	}
	
}
