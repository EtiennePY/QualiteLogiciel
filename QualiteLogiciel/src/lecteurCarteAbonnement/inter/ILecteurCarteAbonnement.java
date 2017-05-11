package lecteurCarteAbonnement.inter;

import cartes.impl.AbstractCarte;
import erreurs.CarteInsereeErreur;
import systemeInformatique.impl.SystemeInformatique;

public interface ILecteurCarteAbonnement {
	public void restitutionCarte(boolean retour);
	public void demandeInsertionCarte(boolean detecte);
	public boolean checkAbonnement(SystemeInformatique sys) throws CarteInsereeErreur;
	public AbstractCarte getCarteClient();
	public void setCarteClient(final AbstractCarte carteClient);

}
