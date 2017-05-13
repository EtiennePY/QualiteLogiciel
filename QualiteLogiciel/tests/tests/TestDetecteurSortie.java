package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import panneau.impl.PanneauAffichage;
import panneau.inter.IPanneauAffichage;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

public class TestDetecteurSortie {


	private IDetecteurSortie detecteur;
	
	
	@Before
	public void instanciationDetecteur() {

		this.detecteur = new DetecteurSortie();
		
	}
	

	@Test
	public void aDetecteImmatriculation() {
		ISystemeInformatique sys = new SystemeInformatique();
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 1;
		Integer immatriculationClient = 123456789;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		IVehicule vehicule = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		//On définit maintenant le client lui-meme
		IClientAbonne clientAbonne =  new ClientAbonne(vehicule, carteAbonnement);
		
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
		clientAbonne.sePlaceDevantBarriere();
		Assert.assertEquals(true, this.detecteur.detecteImmatriculationVehicule(vehicule, sys, lecteurAbo));
	}
	
	@Test
	public void neDetectePasImmatriculation() {
		ISystemeInformatique sys = new SystemeInformatique();
		ILecteurCarteAbonnement lecteurAbo = new LecteurCarteAbonnement();
		
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 1;
		Integer immatriculationClient = 123456789;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède

		IVehicule vehicule = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		//On définit maintenant le client lui-meme
		IClientAbonne clientAbonne =  new ClientAbonne(vehicule, carteAbonnement);
		
		sys.enregistreClientAbonne(132456788, idClient, abonnement);
		clientAbonne.sePlaceDevantBarriere();
		
		Assert.assertEquals(false, this.detecteur.detecteImmatriculationVehicule(vehicule, sys, lecteurAbo));
	}
	
	@Test
	public void fermeLaBarriere() throws BarriereErreur {
		IBarriereSortie barriere = new BarriereSortie();
		barriere.ouvrir();
		this.detecteur.fermeBarriere(barriere);
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	@Test
	public void majPanneau() {
		IPanneauAffichage panneau = new PanneauAffichage();
		int avant = panneau.getNombrePlacesLibres();
		this.detecteur.metAJourPanneauAffichage(panneau);
		int apres = panneau.getNombrePlacesLibres();
		Assert.assertEquals(avant, apres - 1);
	}
	
	
}
