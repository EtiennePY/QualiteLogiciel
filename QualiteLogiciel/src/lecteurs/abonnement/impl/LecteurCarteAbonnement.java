package lecteurs.abonnement.impl;

import java.util.logging.Logger;

import barriere.inter.IBarriereSortie;
import cartes.impl.AbstractCarte;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientAbonne;
import erreurs.BarriereErreur;
import erreurs.CarteInsereeErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import systemeinfo.inter.ISystemeInformatique;

// TODO: Auto-generated Javadoc
/**
 * The Class LecteurCarteAbonnement.
 */
public class LecteurCarteAbonnement implements ILecteurCarteAbonnement {

	/** The carte client. */
	private IAbstractCarte carteClient;

	/** The logger. */
	private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

	/**
	 * Instantiates a new lecteur carte abonnement.
	 */
	public LecteurCarteAbonnement() {
		this.carteClient = CarteWithout.instance();
	}


	/**
	 * Restitution carte.
	 *
	 * @param retour the retour
	 */
	public void restitutionCarte(final boolean retour) { 
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur et la carte sort" );
		} else {
			LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur et la carte sort" );
		}
	}


	/**
	 * Demande insertion carte.
	 *
	 * @param detecte the detecte
	 */
	public void demandeInsertionCarte(final boolean detecte) {
		if (detecte) {
			LOG.info("L'écran du lecteur de carte d'abonnement affiche \"Insérez votre carte d'abonnement\"");
		}
	}

	/**
	 * Check abonnement.
	 *
	 * @param sys the sys
	 * @return true, if successful
	 * @throws CarteInsereeErreur the carte inseree erreur
	 * @throws BarriereErreur 
	 */
	public boolean checkAbonnement(final ISystemeInformatique sys, final IBarriereSortie barriere) throws CarteInsereeErreur, BarriereErreur {
		if (this.getCarteClient().isWith()) {
			this.setCarteClient(this.getCarteClient());
			LOG.info("Le lecteur de carte d'abonnement reçoit la carte d'abonnement.");
			final IAbstractCarte carte = (AbstractCarte) this.getCarteClient();
			return sys.checkAbonnement(carte, this, barriere);
		} else {
			throw new CarteInsereeErreur();
		}
	}

	/**
	 * Gets the carte client.
	 *
	 * @return the carte client
	 */
	public IAbstractCarte getCarteClient() {
		return carteClient;
	}

	/**
	 * Sets the carte client.
	 *
	 * @param carteClient the new carte client
	 */
	public void setCarteClient(final IAbstractCarte carteClient) {
		this.carteClient = carteClient;
	}
}