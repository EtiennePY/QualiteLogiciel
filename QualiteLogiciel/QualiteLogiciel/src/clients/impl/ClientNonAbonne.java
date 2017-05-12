package clients.impl;

import java.util.List;

import cartes.impl.CarteBancaire;
import clients.inter.IClientNonAbonne;
import lecteurs.bancaire.impl.LecteurBancaire;
import ticket.impl.Ticket;
import ticket.impl.TicketWithout;
import vehicule.inter.IVehicule;


public class ClientNonAbonne extends AbstractClient implements IClientNonAbonne {
	protected CarteBancaire carteBancaire;
	protected Ticket ticket;
	public ClientNonAbonne(List<IVehicule> vehicules, CarteBancaire carteBancaire) {
		super.vehicules = vehicules;
		this.carteBancaire = carteBancaire;
		this.ticket = TicketWithout.instance();
	}
	
	
	public Ticket insereTicket() {
		if (this.getTicket().isTicketWith()) {
			System.out.println("Le client non-abonn� a ins�r� son ticket.");
		}
		Ticket res = this.getTicket();
		this.setTicket(TicketWithout.instance());
		return res;
	}
	
	public void insereCarteBancaire(LecteurBancaire lecteur){
		System.out.println("Le client non-abonn� a ins�r� sa carte.");
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