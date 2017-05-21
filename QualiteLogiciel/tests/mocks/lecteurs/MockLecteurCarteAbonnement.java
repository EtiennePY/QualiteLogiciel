package mocks.lecteurs;

import java.util.logging.Logger;

import barriere.inter.IBarriereSortie;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import systemeinfo.inter.ISystemeInformatique;

// TODO: Auto-generated Javadoc
/**
 * The Class LecteurCarteAbonnement.
 */
public class MockLecteurCarteAbonnement implements ILecteurCarteAbonnement {

	/** The carte client. */
	private IAbstractCarte carteClient;

	/** The logger. */
	private static final Logger LOG = Logger.getLogger(MockLecteurCarteAbonnement.class.getName());

	/**
	 * Instantiates a new lecteur carte abonnement.
	 */
	public MockLecteurCarteAbonnement() {
		this.carteClient = CarteWithout.instance();
	}


	/**
	 * Restitution carte.
	 *
	 * @param retour the retour
	 */
	public boolean restitutionCarte(final boolean retour) { 
		if(retour) {
			LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur et la carte sort" );
		} else {
			LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur et la carte sort" );
		}
		return retour;
	}


	/**
	 * Demande insertion carte.
	 *
	 * @param detecte the detecte
	 */
	public boolean demandeInsertionCarte(final boolean detecte) {
		if (detecte) {
			LOG.info("L'écran du lecteur de carte d'abonnement affiche \"Insérez votre carte d'abonnement\"");
		}
		else {
			LOG.warning("Appel à l'écran du lecteur sans client");
		}
		return detecte;
	}

	/**
	 * Check abonnement.
	 *
	 * @param sys the sys
	 * @return true, if successful
	 * @throws CarteAbonnementErreur the carte inseree erreur
	 * @throws BarriereErreur 
	 */
	public boolean checkAbonnement(final ISystemeInformatique sys, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur {
		if (this.getCarteClient().isWith()) {
			this.setCarteClient(this.getCarteClient());
			LOG.info("Le lecteur de carte d'abonnement reçoit la carte d'abonnement.");
			final IAbstractCarte carte = (IAbstractCarte) this.getCarteClient();
			return sys.checkAbonnement(carte, this, barriere);
		} else {
			throw new CarteAbonnementErreur("Aucune carte d'abonnement n'a ete inseree !");
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