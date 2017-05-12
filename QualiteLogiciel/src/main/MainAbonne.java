package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import abonnement.Abonnement;
import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteAbonnement;
import cartes.inter.ICarteAbonnement;
import clients.impl.ClientAbonne;
import detecteur.impl.DetecteurSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.CarteInsereeErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;
public class MainAbonne {
	public static void main(String[] args) throws CarteInsereeErreur {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = Vehicule.VOITURE;
		voiturette.setImmatriculation(immatriculationClient);
		vehicules.add(voiturette);
		
		//On définit maintenant le client lui-meme
		ClientAbonne antoine = new ClientAbonne(vehicules, carteAbonnement);
		
		
		//On cree le detecteur
		IDetecteurSortie detecteur = new DetecteurSortie();
		
		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();


		//On cree le systeme informatique
		ISystemeInformatique sys = new SystemeInformatique();
		//On ajoute au systeme informatique l'identifiant du client et son immatriculation ainsi que son abonnement 
		//(supposons qu'il se soit inscrit auparavant)
		Map<Integer, Integer> ids = sys.getIdentifiants();
		Integer immatriculationEnregistree = 696969;
		Integer idEnregistree = 69;
		ids.put(idEnregistree, immatriculationEnregistree);
		Map<Integer, Abonnement> abonnements = sys.getAbonnements();
		abonnements.put(immatriculationClient, abonnement);
		
		//On cree le panneau d'affichage
		IPanneauAffichage panneau = new PanneauAffichage();
		IBarriereSortie barriere = new BarriereSortie();

		//Debut de la séquence
		
		
		antoine.sePlaceDevantBarriere();
		boolean estReconnue = detecteur.detecteImmatriculationVehicule(voiturette, sys, lecteurAbo);
		
		//Si immatriculation du client est bien dans le SI
		if (estReconnue) {
			antoine.insereCarteAbonnement(lecteurAbo);
			boolean estBienAbonne = lecteurAbo.checkAbonnement(sys, barriere);
			antoine.recupereCarteAbonnement(lecteurAbo);

			//Si sa carte est valide
			if(estBienAbonne){
				antoine.passe();
				detecteur.metAJourPanneauAffichage(panneau);
				detecteur.fermeBarriere(barriere);
			}


		}
	}

}
