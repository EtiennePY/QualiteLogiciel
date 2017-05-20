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
import ticket.inter.IAbstractTicket;
import vehicule.inter.IVehicule;


// TODO: Auto-generated Javadoc
/**
 * The Class ClientNonAbonne.
 */
public class ClientNonAbonne extends AbstractClient implements IClientNonAbonne {
	
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());
	
	/** The carte bancaire. */
	protected IAbstractCarte carteBancaire;
	
	/** The ticket. */
	protected IAbstractTicket ticket;
	
	/** The banque. */
	private IBanque banque;
	
	/**
	 * Sets the banque.
	 *
	 * @param banque the new banque
	 */
	public void setBanque(final IBanque banque) {
		this.banque = banque;
	}


	/**
	 * Instantiates a new client non abonne.
	 *
	 * @param vehicule the vehicule
	 * @param cbClient the cb client
	 * @param banque the banque
	 */
	public ClientNonAbonne(final IVehicule vehicule, final IAbstractCarte cbClient, final IBanque banque) {
		super();
		super.getVehicules().add(vehicule);
		this.carteBancaire = cbClient;
		this.banque=banque;
		this.ticket = TicketWithout.instance();
	}


	/**
	 * Insere ticket.
	 *
	 * @param lecteurTicket the lecteur ticket
	 * @throws TicketErreur the ticket erreur
	 */
	public void insereTicket(final ILecteurTicket lecteurTicket) throws TicketErreur {
		if (this.getTicket().isWith()) {
			LOG.info("Le client non-abonné insére son ticket.");
			final IAbstractTicket ticketClient = this.getTicket();
			this.setTicket(TicketWithout.instance());
			lecteurTicket.setTicketClient(ticketClient);
		} else {
			throw new TicketErreur("Le client n'a pas de ticket.");
		}


	}
	
	/**
	 * Recupere ticket.
	 *
	 * @param lecteur the lecteur
	 */
	public void recupereTicket(final ILecteurTicket lecteur) {

		LOG.info("Le client non-abonné récupère son ticket.");
		final IAbstractTicket ticket = lecteur.getTicketClient();
		this.setTicket(ticket);
		lecteur.setTicketClient(TicketWithout.instance());
	}

	/**
	 * Insere carte bancaire.
	 *
	 * @param carte the carte
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	public void insereCarteBancaire(final ILecteurBancaire lecteur) throws CarteBancaireErreur{
		if (this.getCarteBancaire().isWith()) {
			LOG.info("Le client non-abonné insére sa carte bancaire.");
			final IAbstractCarte carte = this.getCarteBancaire();
			this.setCarteBancaire(carteBancaire);
			lecteur.setCarteBancaire(carte);
		} else {
			throw new CarteBancaireErreur("Le client n'a pas de carte bancaire.");
		}

	}


	/**
	 * Gets the carte bancaire.
	 *
	 * @return the carte bancaire
	 */
	public IAbstractCarte getCarteBancaire() {
		return carteBancaire;
	}

	/**
	 * Sets the carte bancaire.
	 *
	 * @param carteBancaire the new carte bancaire
	 */
	public void setCarteBancaire(final IAbstractCarte carteBancaire) {
		this.carteBancaire = carteBancaire;
	}

	/**
	 * Gets the ticket.
	 *
	 * @return the ticket
	 */
	public IAbstractTicket getTicket() {
		return ticket;
	}

	/**
	 * Sets the ticket.
	 *
	 * @param ticket the new ticket
	 */
	public void setTicket(final IAbstractTicket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Gets the banque.
	 *
	 * @return the banque
	 */
	public IBanque getBanque(){
		return this.banque;
	}


	/**
	* Checks if is abonne.
	*
	* @return true, if is abonne
	*/
	public boolean isAbonne() {
		return false;
	}


	/**
	 * Recupere carte bancaire.
	 *
	 * @param lecteurCarteBancaire the lecteur carte bancaire
	 */
	public void recupereCarteBancaire(final ILecteurBancaire lecteurBancaire) {
		LOG.info("Le client non-abonné récupère sa carte bancaire.");
		final IAbstractCarte carteBancaire = lecteurBancaire.getCarteBancaire();
		this.setCarteBancaire(carteBancaire);
		lecteurBancaire.setCarteBancaire(carteBancaire);
	}
}
