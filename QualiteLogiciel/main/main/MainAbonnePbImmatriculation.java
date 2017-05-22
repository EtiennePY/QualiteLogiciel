package main;

import abonnement.Abonnement;
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
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;
public class MainAbonnePbImmatriculation {
	public static void main(String[] args) throws CarteAbonnementErreur, BarriereErreur {
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 69;
		Integer immatriculationClient = 696969;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		
	
		//On définit maintenant le client lui-meme
		IClientAbonne antoine = new ClientAbonne(voiturette, carteAbonnement);
		
		
		
		//On cree le detecteur
		IDetecteurSortie detecteur = new DetecteurSortie();
		
		
		//On cree le lecteur de carte d'abonnement
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();


		//On cree le systeme informatique
		ISystemeInformatique sys = new SystemeInformatique();
		//On ajoute au systeme informatique l'identifiant du client et son immatriculation ainsi que son abonnement 
		//(supposons qu'il se soit inscrit auparavant)
		sys.enregistreClientAbonne(696968, idClient, abonnement);

		//Debut de la séquence
		
		
		antoine.sePlaceDevantBarriere();
		detecteur.detecteImmatriculationVehicule(voiturette, sys, lecteurAbo);
		
			}

}
