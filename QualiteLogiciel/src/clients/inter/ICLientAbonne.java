package clients.inter;

import cartes.impl.AbstractCarte;
import lecteurCarteAbonnement.inter.ILecteurCarteAbonnement;

public interface ICLientAbonne extends IAbstractClient {
	void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo);
	void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur);
	AbstractCarte getCarteAbonnement();
	void setCarteAbonnement(final AbstractCarte carteAbonnement);
}
