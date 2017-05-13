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
import clients.inter.IClientAbonne;
import detecteur.impl.DetecteurSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;
public class MainAbonne {
	public static void main(String[] args) throws CarteAbonnementErreur, BarriereErreur {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les v�hicules qu'il poss�de
		List<IVehicule> vehicules = new ArrayList<IVehicule>();
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		vehicules.add(voiturette);
		
		//On d�finit maintenant le client lui-meme
		IClientAbonne antoine = new ClientAbonne(vehicules, carteAbonnement);
		
		
		//On cree le detecteur
		IDetecteurSortie detecteur = new DetecteurSortie();
		
		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();


		//On cree le systeme informatique
		ISystemeInformatique sys = new SystemeInformatique();
		//On ajoute au systeme informatique l'identifiant du client et son immatriculation ainsi que son abonnement 
		//(supposons qu'il se soit inscrit auparavant)
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
		
		//On cree le panneau d'affichage
		IPanneauAffichage panneau = new PanneauAffichage();
		IBarriereSortie barriere = new BarriereSortie();

		//Debut de la s�quence
		
		
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
