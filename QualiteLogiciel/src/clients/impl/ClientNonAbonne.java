package clients.impl;

import java.util.List;
import java.util.logging.Logger;

import banque.inter.IBanque;
import cartes.inter.ICarteBancaire;
import clients.inter.IClientNonAbonne;
import lecteurs.bancaire.inter.ILecteurBancaire;
import ticket.impl.TicketWithout;
import ticket.inter.ITicket;
import vehicule.inter.IVehicule;


public class ClientNonAbonne extends AbstractClient implements IClientNonAbonne {
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	protected ICarteBancaire carteBancaire;
	protected ITicket ticket;
	protected IBanque banque;
	public ClientNonAbonne(IVehicule vehicule, ICarteBancaire cbClient, IBanque banque) {
		super.getVehicules().add(vehicule);
		this.carteBancaire = cbClient;
		this.banque=banque;
		this.ticket = TicketWithout.instance();
	}
	
	
	public ITicket insereTicket() {
		if (this.getTicket().isTicketWith()) {
			LOG.info("Le client non-abonné insére son ticket.");
		}
		ITicket res = this.getTicket();
		this.setTicket(TicketWithout.instance());
		return res;
	}
	
	public void insereCarteBancaire(ILecteurBancaire lecteur){
		LOG.info("Le client non-abonné insére sa carte.");
	}


	public ICarteBancaire getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(ICarteBancaire carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	public ITicket getTicket() {
		return ticket;
	}

	public void setTicket(ITicket ticket) {
		this.ticket = ticket;
	}
	
	public IBanque getBanque(){
		return this.banque;
	}


	@Override
	public boolean isAbonne() {
		// TODO Auto-generated method stub
		return false;
	}
}
