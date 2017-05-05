package systemeInformatique;

import abonnement.Abonnement;
import barriere.Barriere;
import carte.Carte;
import ticket.Ticket;

public interface ISystemeInformatique {
	public boolean checkAbonnement(Carte carte);
	public void enregistrerDateHeure();
	public void ouvreBarriere(Barriere barriere);
	public int calcuPrix();
	public int donnePrixAPayer(int prix);
	public boolean mauvaiseCarteAbonnement(Carte carte);
	public boolean carteAbonnementValide(Carte carte);
	public boolean ticketNonValide(Ticket ticket);
	public void addId(int id);
	public void deleteId(int id);
	public void changeAbonnement(int id, Abonnement abonnement);
	}
