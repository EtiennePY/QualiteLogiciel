package detecteur.inter;

import barriere.inter.IBarriereSortie;
import clients.inter.IAbstractClient;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import panneau.inter.IPanneauAffichage;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.inter.IVehicule;

public interface IDetecteurSortie {
	public boolean isPresent();
	public void setPresent(final boolean present);
	public void fermeBarriere(final IBarriereSortie barriere);
	public void metAJourPanneauAffichage(final IPanneauAffichage panneau);
	public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final ISystemeInformatique sys,final ILecteurCarteAbonnement lecteur);
	public void detecteClient(final IAbstractClient client);
}
