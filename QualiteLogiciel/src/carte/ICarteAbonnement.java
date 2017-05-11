package carte;

import abonnement.Abonnement;

public interface ICarteAbonnement extends IAbstractCarte {
	Abonnement getAbonnement();
	void setAbonnement(final Abonnement abonnement);
}
