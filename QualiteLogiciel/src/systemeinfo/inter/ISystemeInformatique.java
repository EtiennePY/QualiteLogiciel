/*
 * 
 */
package systemeinfo.inter;

import java.util.Map;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import erreurs.CarteInsereeErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;

public interface ISystemeInformatique {
	Map<Integer, Abonnement> getAbonnements();
	void setAbonnements(final Map<Integer, Abonnement> abonnements);
	Map<Integer, Integer> getIdentifiants();
	void setIdentifiants(final Map<Integer, Integer> ids);
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteInsereeErreur;
	void ouvreBarriere(final IBarriereSortie barriere);
	
}
