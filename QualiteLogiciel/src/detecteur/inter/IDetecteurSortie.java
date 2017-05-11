package detecteur.inter;

import barriere.inter.IBarriereSortie;
import clients.impl.AbstractClient;
import lecteurCarteAbonnement.inter.ILecteurCarteAbonnement;
import panneau.inter.IPanneauAffichage;
import systemeInformatique.impl.SystemeInformatique;
import vehicule.inter.IVehicule;

public interface IDetecteurSortie {
	public boolean isPresent();
	public void setPresent(final boolean present);
	public void fermeBarriere(final IBarriereSortie barriere);
	public void metAJourPanneauAffichage(final IPanneauAffichage panneau);
	public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final SystemeInformatique sys,final ILecteurCarteAbonnement lecteur);
	public void detecteClient(final AbstractClient client);
}
