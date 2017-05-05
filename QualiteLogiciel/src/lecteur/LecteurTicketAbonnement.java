package lecteur;

import carte.Carte;
import carte.CarteWithout;
import client.ClientAbonne;
import date.Date;
import error.TicketError;
import ticket.Ticket;
import ticket.TicketWith;
import ticket.TicketWithout;

public class LecteurTicketAbonnement extends Lecteur {
	
	public LecteurTicketAbonnement() {
		this.ticketClient = TicketWithout.instance();
		this.carteClient = CarteWithout.instance();
	}
	private Carte carteClient;
	private Ticket ticketClient;
	
	@Override
	public Ticket restitutionTicket() {
		Ticket res = this.getTicketClient();
		this.ticketClient = TicketWithout.instance();
		return res;
	}
	
	@Override
	public boolean verificationTicket(Ticket ticket) throws TicketError {
		System.out.println("Le lecteur de ticket vérifie le ticket.");
		// Role du SI ???
		return true;
		
	}
	
	public Ticket donneTicket(Date date) {
		return new TicketWith(date);
		
	}
	public void restitutionCarte(boolean retour, ClientAbonne client) {
		client.setCarteAbonnement(this.getCarteClient());
		this.setCarteClient(CarteWithout.instance());
		
		if(retour) {
			System.out.println("Un message s'affiche : \"OK\"" );
		} else {
			System.out.println("Un message s'affiche : \"Carte erronée\"" );

		}

		
	}
	
	public void demandeInsertionCarteAbonnement() {
		System.out.println("Un message s'affiche à l'écran du lecteur de carte d'abonnement : \"Insérez carte\"");
	}
	
	public void checkAbonnement() {
		this.setCarteClient(this.getCarteClient());
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
