package detecteur.inter;

import barriere.inter.IBarriereSortie;
import erreurs.BarriereErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.ticket.inter.ILecteurTicket;
import panneau.inter.IPanneauAffichage;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.inter.IVehicule;

public interface IDetecteurSortie {
	public boolean isPresent();
	public void setPresent(final boolean present);
	public boolean fermeBarriere(final IBarriereSortie barriere) throws BarriereErreur;
	public void metAJourPanneauAffichage(final IPanneauAffichage panneau);
	public boolean detecteImmatriculationVehicule(final IVehicule vehicule,final ISystemeInformatique sys, final ILecteurCarteAbonnement lecteur);
	public void detecteClient(final IVehicule vehicule, final ILecteurTicket lecteur);
}
