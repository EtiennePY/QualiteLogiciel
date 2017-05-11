package lecteur;

import carte.Carte;
import systemeInformatique.SystemeInformatique;

public interface ILecteurCarteAbonnement {
	public void restitutionCarte(boolean retour);
	public void demandeInsertionCarte(boolean detecte);
	public boolean checkAbonnement(SystemeInformatique sys);
	public Carte getCarteClient();
	public void setCarteClient(Carte carteClient);

}
