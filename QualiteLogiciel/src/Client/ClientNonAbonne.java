package client;

import java.util.Set;

import carte.CarteBancaire;
import ticket.Ticket;
import vehicule.Vehicule;

public class ClientNonAbonne extends Client {
	protected CarteBancaire carteBancaire;
	protected Ticket ticket;
	public ClientNonAbonne(Set<Vehicule> vehicules, CarteBancaire carteBancaire, Ticket ticket) {
		super.vehicules = vehicules;
		this.carteBancaire = carteBancaire;
		this.ticket = null;
	}
	public void insereTicket(Ticket ticket){
		
	}
	
	public void insereCarteBancaire(CarteBancaire carte){
		
	}
	
	public void demandeTicket() {
		
	}
	
	public void prendTicket() {
		
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
