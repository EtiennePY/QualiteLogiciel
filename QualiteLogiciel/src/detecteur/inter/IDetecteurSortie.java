package detecteur.inter;

import barriere.inter.IBarriereSortie;
import erreurs.BarriereErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.ticket.inter.ILecteurTicket;
import panneau.inter.IPanneauAffichage;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDetecteurSortie.
 */
public interface IDetecteurSortie {
	
	/**
	 * Checks if is present.
	 *
	 * @return true, if is present
	 */
	boolean isPresent();
	
	/**
	 * Sets the present.
	 *
	 * @param present the new present
	 */
	void setPresent(final boolean present);
	
	/**
	 * Ferme barriere.
	 *
	 * @param barriere the barriere
	 * @return true, if successful
	 * @throws BarriereErreur the barriere erreur
	 */
	boolean fermeBarriere(final IBarriereSortie barriere) throws BarriereErreur;
	
	/**
	 * Met A jour panneau affichage.
	 *
	 * @param panneau the panneau
	 */
	void metAJourPanneauAffichage(final IPanneauAffichage panneau);
	
	/**
	 * Detecte immatriculation vehicule.
	 *
	 * @param vehicule the vehicule
	 * @param sys the sys
	 * @param lecteur the lecteur
	 * @return true, if successful
	 */
	boolean detecteImmatriculationVehicule(final IVehicule vehicule,final ISystemeInformatique sys, final ILecteurCarteAbonnement lecteur);
	
	/**
	 * Detecte client.
	 *
	 * @param vehicule the vehicule
	 * @param lecteur the lecteur
	 * @return true, if successful
	 */
	boolean detecteClient(final IVehicule vehicule, final ILecteurTicket lecteur);
}
