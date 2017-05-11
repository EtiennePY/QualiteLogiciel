package lecteur;

import carte.AbstractCarte;
import systemeInformatique.SystemeInformatique;

public interface ILecteurCarteAbonnement {
	public void restitutionCarte(boolean retour);
	public void demandeInsertionCarte(boolean detecte);
	public boolean checkAbonnement(SystemeInformatique sys);
	public AbstractCarte getCarteClient();
	public void setCarteClient(final AbstractCarte carteClient);

}
