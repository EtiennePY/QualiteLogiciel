package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abonnement.Abonnement;
import barriere.Barriere;
import barriere.BarriereSortie;
import carte.CarteAbonnement;
import client.ClientAbonne;
import detecteur.Detecteur;
import detecteur.DetecteurSortie;
import lecteur.LecteurTicketAbonnement;
import panneau.PanneauAffichage;
import systemeInformatique.SystemeInformatique;
import vehicule.Vehicule;
public class MainAbonne {
	public static void main(String[] args) {
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		CarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Vehicule voiturette = Vehicule.VOITURE;
		voiturette.setImmatriculation(immatriculationClient);
		vehicules.add(voiturette);
		ClientAbonne antoine = new ClientAbonne(vehicules, carteAbonnement);
		DetecteurSortie detecteur = new DetecteurSortie();
		LecteurTicketAbonnement lecteurAbo = new LecteurTicketAbonnement();
		
		
		
		SystemeInformatique sys = new SystemeInformatique();
		HashMap<Integer, Integer> ids = sys.getIds();
		ids.put(idClient, immatriculationClient);
		HashMap<Integer, Abonnement> abonnements = sys.getAbonnements();
		abonnements.put(immatriculationClient, abonnement);
		
		PanneauAffichage panneau = new PanneauAffichage();
		Barriere barriere = new BarriereSortie();
		
		//Debut de la séquence
		antoine.sePlaceDevantBarriere();
		detecteur.detecteImmatriculationVehicule(voiturette, sys);
		lecteurAbo.demandeInsertionCarte();
		antoine.insereCarteAbonnement(lecteurAbo);
		lecteurAbo.checkAbonnement();
		boolean result = sys.checkAbonnement(lecteurAbo.getCarteClient());

		lecteurAbo.restitutionCarte(result, antoine);
		
		if(result){
			sys.ouvreBarriere(barriere);
			antoine.passe();
			detecteur.metAJourPanneauAffichage(panneau);
			detecteur.fermeBarriere(barriere);
		}
		
	}
	
}
