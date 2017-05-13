/*
 * 
 */
package systemeinfo.inter;

import java.util.Map;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;

public interface ISystemeInformatique {
	Map<Integer, Abonnement> getAbonnements();
	Map<Integer, Integer> getImmatriculations();
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur;
	void ouvreBarriere(final IBarriereSortie barriere) throws BarriereErreur;
	
	void enregistreClientAbonne(Integer immatriculation, Integer id, Abonnement abonnement);
}
