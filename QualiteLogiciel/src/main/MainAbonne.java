package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abonnement.Abonnement;
import barriere.BarriereSortie;
import carte.CarteAbonnement;
import client.ClientAbonne;
import detecteur.DetecteurSortie;
import lecteur.LecteurCarteAbonnement;
import panneau.PanneauAffichage;
import systemeInformatique.SystemeInformatique;
import vehicule.Vehicule;
public class MainAbonne {
	public static void main(String[] args) {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		CarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		List<Vehicule> vehicules = new ArrayList<Vehicule>();
		Vehicule voiturette = Vehicule.VOITURE;
		voiturette.setImmatriculation(immatriculationClient);
		vehicules.add(voiturette);
		
		//On définit maintenant le client lui-meme
		ClientAbonne antoine = new ClientAbonne(vehicules, carteAbonnement);
		
		
		//On cree le detecteur
		DetecteurSortie detecteur = new DetecteurSortie();
		
		
		//On cree le lecteur de carte d'abonnement
		LecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();


		//On cree le systeme informatique
		SystemeInformatique sys = new SystemeInformatique();
		//On ajoute au systeme informatique l'identifiant du client et son immatriculation ainsi que son abonnement 
		//(supposons qu'il se soit inscrit auparavant)
		HashMap<Integer, Integer> ids = sys.getIds();
		Integer immatriculationEnregistree = 696969;
		Integer idEnregistree = 69;
		ids.put(idEnregistree, immatriculationEnregistree);
		HashMap<Integer, Abonnement> abonnements = sys.getAbonnements();
		abonnements.put(immatriculationClient, abonnement);
		
		//On cree le panneau d'affichage
		PanneauAffichage panneau = new PanneauAffichage();
		BarriereSortie barriere = new BarriereSortie();

		//Debut de la séquence
		
		
		antoine.sePlaceDevantBarriere();
		boolean estReconnue = detecteur.detecteImmatriculationVehicule(voiturette, sys, lecteurAbo);
		
		//Si immatriculation du client est bien dans le SI
		if (estReconnue) {
			antoine.insereCarteAbonnement(lecteurAbo);
			boolean estBienAbonne = lecteurAbo.checkAbonnement(sys);
			antoine.recupereCarteAbonnement(lecteurAbo);

			//Si sa carte est valide
			if(estBienAbonne){
				sys.ouvreBarriere(barriere);
				antoine.passe();
				detecteur.metAJourPanneauAffichage(panneau);
				detecteur.fermeBarriere(barriere);
			}


		}
	}

}
