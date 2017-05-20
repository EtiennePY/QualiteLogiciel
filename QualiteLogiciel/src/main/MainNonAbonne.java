package main;

import banque.impl.Banque;
import banque.inter.IBanque;
import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteBancaire;
import cartes.inter.ICarteBancaire;
import clients.impl.ClientNonAbonne;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import detecteur.impl.DetecteurSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.BanqueErreur;
import erreurs.BarriereErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.impl.LecteurBancaire;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.impl.LecteurTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;
import ticket.inter.ITicket;
import ticket.inter.ITicketWith;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

public class MainNonAbonne {

	public static void main(String[] args) throws BarriereErreur, TicketErreur, CarteBancaireErreur, BanqueErreur{
		
		//Nous sommes le 16 mai
		IDateTicket dateDuJour = new DateTicket(16,04);
		
		//Carte Bancaire et ticket du client
		Integer idCarteBancaire = 1337;
		ICarteBancaire cbClient = new CarteBancaire(idCarteBancaire);
		ITicket ticketClient = new TicketWith(new DateTicket(02,04)); //entré dans le parking le 2 mai

		//Véhicule du client
		Integer immatriculationGrosHummer = 420;

		IVehicule grosHummer = new Vehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

		//Banque du client
		IBanque banqueClient = new Banque();
		
		//Client
		ClientNonAbonne etienne = new ClientNonAbonne(grosHummer,cbClient, banqueClient);
		etienne.setTicket(ticketClient);

		//On cree le detecteur
		IDetecteurSortie detecteur = new DetecteurSortie();


		//On cree les lecteurs de carte bancaire et de ticket
		ILecteurBancaire lecteurCarteBancaire = new LecteurBancaire();
		ILecteurTicket lecteurTicket = new LecteurTicket();


		//On cree le systeme informatique
		ISystemeInformatique sys = new SystemeInformatique();
		sys.enregistreClientNonAbonne(((ITicketWith)ticketClient).getDateTicket());
		sys.setDateDuJour(dateDuJour);
		//On cree le panneau d'affichage et la barriere
		IPanneauAffichage panneau = new PanneauAffichage();
		IBarriereSortie barriere = new BarriereSortie();
		
		//Début de la séquence
		etienne.sePlaceDevantBarriere();
		detecteur.detecteClient(grosHummer, lecteurTicket);
		
		etienne.insereTicket(lecteurTicket);
		boolean ticketValide = lecteurTicket.verificationTicket(sys, barriere, lecteurCarteBancaire);

		if (ticketValide){
			etienne.insereCarteBancaire(lecteurCarteBancaire);
			boolean transaction = lecteurCarteBancaire.realiseTransaction(sys, lecteurTicket);
					
			if (transaction){
				etienne.recupereCarteBancaire(lecteurCarteBancaire);
				etienne.recupereTicket(lecteurTicket);
				barriere.ouvrir();
				etienne.passe();
				detecteur.metAJourPanneauAffichage(panneau);
				detecteur.fermeBarriere(barriere);
			}
			
			
		} 

	}

}
