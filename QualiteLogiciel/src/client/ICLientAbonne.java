package client;

import carte.AbstractCarte;
import lecteur.ILecteurCarteAbonnement;

public interface ICLientAbonne extends IAbstractClient {
	void insereCarteAbonnement(final ILecteurCarteAbonnement lecteurAbo);
	void recupereCarteAbonnement(final ILecteurCarteAbonnement lecteur);
	AbstractCarte getCarteAbonnement();
	void setCarteAbonnement(final AbstractCarte carteAbonnement);
}
