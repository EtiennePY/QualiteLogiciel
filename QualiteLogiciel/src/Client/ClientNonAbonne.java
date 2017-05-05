package client;

import java.util.List;

import carte.CarteBancaire;
import lecteur.LecteurBancaire;
import ticket.Ticket;
import ticket.TicketWithout;
import vehicule.Vehicule;


public class ClientNonAbonne extends Client {
	protected CarteBancaire carteBancaire;
	protected Ticket ticket;
	public ClientNonAbonne(List<Vehicule> vehicules, CarteBancaire carteBancaire) {
		super.vehicules = vehicules;
		this.carteBancaire = carteBancaire;
		this.ticket = TicketWithout.instance();
	}
	
	
	public Ticket insereTicket() {
		if (this.getTicket().isTicketWith()) {
			System.out.println("Le client non-abonné a inséré son ticket.");
		}
		Ticket res = this.getTicket();
		this.setTicket(TicketWithout.instance());
		return res;
	}
	
	public void insereCarteBancaire(LecteurBancaire lecteur){
		System.out.println("Le client non-abonné a inséré sa carte.");
	}
	


	public CarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(CarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
}
