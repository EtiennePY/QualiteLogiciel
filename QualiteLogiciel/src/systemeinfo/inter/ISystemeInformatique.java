package systemeinfo.inter;


import java.util.Map;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import cartes.inter.ICarteAbonnement;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import ticket.inter.ITicket;

public interface ISystemeInformatique {
	public boolean checkAbonnement(ICarteAbonnement carte) throws CarteAbonnementErreur ;
	public void enregistrerDateHeure();
	public void ouvreBarriere(IBarriereSortie barriere) throws BarriereErreur;
	public int calcuPrix();
	public int donnePrixAPayer(int prix);
	public boolean mauvaiseCarteAbonnement(ICarteAbonnement carte);
	public boolean carteAbonnementValide(ICarteAbonnement carte);
	public boolean ticketNonValide(ITicket ticket);
	public void addId(int id);
	public void deleteId(int id);
	public void changeAbonnement(int id, Abonnement abonnement);
	void enregistreClientAbonne(Integer immatriculation, Integer id, Abonnement abonnement);
	public Map<Integer, Abonnement> getAbonnements();
	public Map<Integer, Integer> getImmatriculations();
	public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur;
	}
