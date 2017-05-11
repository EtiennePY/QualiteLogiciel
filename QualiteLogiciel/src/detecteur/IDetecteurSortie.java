package detecteur;

import barriere.IBarriereSortie;
import client.AbstractClient;
import lecteur.ILecteurCarteAbonnement;
import panneau.IPanneauAffichage;
import systemeInformatique.SystemeInformatique;
import vehicule.IVehicule;

public interface IDetecteurSortie {
	public boolean isPresent();
	public void setPresent(final boolean present);
	public void fermeBarriere(final IBarriereSortie barriere);
	public void metAJourPanneauAffichage(final IPanneauAffichage panneau);
	public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final SystemeInformatique sys,final ILecteurCarteAbonnement lecteur);
	public void detecteClient(final AbstractClient client);
}
