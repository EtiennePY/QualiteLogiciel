package lecteurs.bancaire.impl;

import java.util.logging.Logger;

import banque.impl.Banque;
import banque.inter.IBanque;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteBancaire;
import clients.impl.ClientAbonne;
import date.inter.IDateTicket;
import erreurs.BanqueErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;

// TODO: Auto-generated Javadoc
/**
 * The Class LecteurBancaire.
 */
public class LecteurBancaire implements ILecteurBancaire {
	
	/** The carte bancaire client. */
	private IAbstractCarte carteBancaire;

	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());



	/** The banque. */
	private IBanque banque;
	
	/**
	 * Instantiates a new lecteur bancaire.
	 */
	public LecteurBancaire() {
		this.carteBancaire = CarteWithout.instance();
		this.banque = new Banque();
	}
	
	/**
	 * Demande insertion carte.
	 *
	 * @param ticketOk the ticket ok
	 * @return true, if successful
	 */
	public boolean demandeInsertionCarte(final boolean ticketOk) {
		if (ticketOk) {
			LOG.info("Le lecteur de carte bancaire demande l'insertion d'une carte bancaire");
		}
		else {
			LOG.warning("Appel à l'écran du lecteur de carte bancaire sans que le ticket ne soit valide au prealable.");
		}
		return ticketOk;
	}


	/**
	 * Contacter banque.
	 *
	 * @param carte the carte
	 * @param prix the prix
	 * @return true, if successful
	 */
	public boolean contacterBanque(final ICarteBancaire carte, final int prix) {
		LOG.info("Le lecteur contacte la banque pour un montant de "+ prix + " euros. C'est cher.");	
		
		return banque.realisePaiement(carte, prix);
	}

	/**
	 * Restitution carte bancaire.
	 *
	 * @param retour the retour
	 * @return true, if successful
	 */
	public boolean restitutionCarteBancaire(final boolean retour){
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur de carte bancaire et la carte sort" );
		} else {
			LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur de carte bancaire et la carte sort" );
		}
		return retour;
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
	 * @param carteClient the new carte bancaire
	 */
	public void setCarteBancaire(final IAbstractCarte carteClient) {
		this.carteBancaire = carteClient;
	}
	
	/**
	 * Gets the banque.
	 *
	 * @return the banque
	 */
	public IBanque getBanque() {
		return banque;
	}

	
	/**
	 * Sets the banque.
	 *
	 * @param banque the new banque
	 */
	public void setBanque(final IBanque banque){
		this.banque=banque;
	}


	/**
	 * Realise transaction.
	 *
	 * @param sys the sys, lecteurTicket the lecteur ticket
	 * @return true, if successful
	 * @throws TicketErreur the ticket erreur
	 * @throws BanqueErreur the banque erreur
	 */
	public boolean realiseTransaction(final ISystemeInformatique sys, final ILecteurTicket lecteurTicket) throws TicketErreur, BanqueErreur {
		if(lecteurTicket.getTicketClient().isWith()) {
			final IDateTicket date = ((TicketWith) lecteurTicket.getTicketClient()).getDateTicket();
			final int prix = sys.calculPrix(date);
			final boolean transaction = this.contacterBanque((ICarteBancaire) this.getCarteBancaire(), prix);
			if (transaction) {
				this.restitutionCarteBancaire(transaction);
				return transaction;
			} else {
				throw new BanqueErreur("La transaction n'a pas pu être effectuée");
			}

		} else {
			throw new TicketErreur("Pas de ticket dans le lecteur de ticket.");
		}
	}


}