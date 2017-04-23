package systemeInformatique;

import abonnement.Abonnement;
import barriere.Barriere;
import carte.CarteAbonnement;
import ticket.Ticket;

public interface ISystemeInformatique {
	public boolean checkAbonnement(CarteAbonnement carte);
	public void enregistrerDateHeure();
	public void ouvreBarriere();
	public int calcuPrix();
	public int donnePrixAPayer(int prix);
	public boolean mauvaiseCarteAbonnement(CarteAbonnement carte);
	public boolean carteAbonnementValide(CarteAbonnement carte);
	public boolean ticketNonValide(Ticket ticket);
	public void addId(int id);
	public void deleteId(int id);
	public void changeAbonnement(int id, Abonnement abonnement);
	}
