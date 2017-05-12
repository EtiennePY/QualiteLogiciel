/*
 * 
 */
package clients.inter;

import cartes.inter.IAbstractCarte;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;

// TODO: Auto-generated Javadoc
/**
 * The Interface IClientAbonne.
 */
public interface IClientAbonne extends IAbstractClient {
	
	/**
	 * Insere carte abonnement.
	 *
	 * @param lecteurAbo the lecteur abo
	 */
	void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo);
	
	/**
	 * Recupere carte abonnement.
	 *
	 * @param lecteur the lecteur
	 */
	void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur);
	
	/**
	 * Gets the carte abonnement.
	 *
	 * @return the carte abonnement
	 */
	IAbstractCarte getCarteAbonnement();
	
	/**
	 * Sets the carte abonnement.
	 *
	 * @param carteAbonnement the new carte abonnement
	 */
	void setCarteAbonnement(final IAbstractCarte carteAbonnement);
}
