package clients.impl;

import java.util.logging.Logger;

import banque.inter.IBanque;
import cartes.inter.IAbstractCarte;
import clients.inter.IClientNonAbonne;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.impl.TicketWithout;
import ticket.inter.ITicket;
import vehicule.inter.IVehicule;


public class ClientNonAbonne extends AbstractClient implements IClientNonAbonne {
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	protected IAbstractCarte carteBancaire;
	protected ITicket ticket;
	protected IBanque banque;
	public ClientNonAbonne(IVehicule vehicule, IAbstractCarte cbClient, IBanque banque) {
		super.getVehicules().add(vehicule);
		this.carteBancaire = cbClient;
		this.banque=banque;
		this.ticket = TicketWithout.instance();
	}


	public void insereTicket(final ILecteurTicket lecteurTicket) throws TicketErreur {
		if (this.getTicket().isWith()) {
			LOG.info("Le client non-abonné insére son ticket.");
			ITicket ticketClient = this.getTicket();
			this.setTicket(TicketWithout.instance());
			lecteurTicket.setTicketClient(ticketClient);
		} else {
			throw new TicketErreur("Le client n'a pas de ticket.");
		}


	}
	public void recupereTicket(final ILecteurTicket lecteur) {

		LOG.info("Le client non-abonné récupère son ticket.");
		final ITicket ticket = lecteur.getTicketClient();
		this.setTicket(ticket);
		lecteur.setTicketClient(TicketWithout.instance());
	}

	public void insereCarteBancaire(ILecteurBancaire lecteur) throws CarteBancaireErreur{
		if (this.getCarteBancaire().isWith()) {
			LOG.info("Le client non-abonné insére sa carte bancaire.");
			IAbstractCarte carte = this.getCarteBancaire();
			this.setCarteBancaire(carteBancaire);
			lecteur.setCarteBancaireClient(carte);
		} else {
			throw new CarteBancaireErreur("Le client n'a pas de carte bancaire.");
		}

	}


	public IAbstractCarte getCarteBancaire() {
		return carteBancaire;
	}

	public void setCarteBancaire(IAbstractCarte carteBancaire) {
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


	public void recupereCarteBancaire(ILecteurBancaire lecteurCarteBancaire) {
		LOG.info("Le client non-abonné récupère sa carte bancaire.");
		final IAbstractCarte carteBancaire = lecteurCarteBancaire.getCarteBancaireClient();
		this.setCarteBancaire(carteBancaire);
		lecteurCarteBancaire.setCarteBancaireClient(carteBancaire);
	}
}
