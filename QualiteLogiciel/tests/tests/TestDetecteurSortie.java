package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.ICarteAbonnement;
import clients.inter.IClientAbonne;
import detecteur.impl.DetecteurSortie;
import detecteur.inter.IDetecteurSortie;
import erreurs.BarriereErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.ticket.inter.ILecteurTicket;
import mocks.barriere.MockBarriereSortie;
import mocks.cartes.MockCarteAbonnement;
import mocks.clients.MockClientAbonne;
import mocks.lecteurs.MockLecteurCarteAbonnement;
import mocks.lecteurs.MockLecteurTicket;
import mocks.panneauaffichage.MockPanneauAffichage;
import mocks.systemeinfo.MockSystemeInformatique;
import mocks.vehicule.MockVehicule;
import panneau.inter.IPanneauAffichage;
import systemeinfo.inter.ISystemeInformatique;
import vehicule.impl.CategorieVehicule;
import vehicule.inter.IVehicule;

public class TestDetecteurSortie {


	private IDetecteurSortie detecteur;
	
	
	@Before
	public void instanciationDetecteur() {
		this.detecteur = new DetecteurSortie();
	}
	

	@Test
	public void detecteClient() {
		Integer idClient = 1;
		Integer immatriculationClient = 123456789;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		IVehicule vehicule = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		//On définit maintenant le client lui-meme
		IClientAbonne clientAbonne =  new MockClientAbonne(vehicule, carteAbonnement);
		ILecteurTicket lecteur = new MockLecteurTicket();
		clientAbonne.sePlaceDevantBarriere();
		Assert.assertEquals(true, this.detecteur.detecteClient(vehicule, lecteur));
	}
	@Test
	public void aDetecteImmatriculation() {
		ISystemeInformatique sys = new MockSystemeInformatique();
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 1;
		Integer immatriculationClient = 123456789;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède
		IVehicule vehicule = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		//On définit maintenant le client lui-meme
		IClientAbonne clientAbonne =  new MockClientAbonne(vehicule, carteAbonnement);
		
		sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);
		clientAbonne.sePlaceDevantBarriere();
		Assert.assertEquals(true, this.detecteur.detecteImmatriculationVehicule(vehicule, sys, lecteurAbo));
	}
	
	@Test
	public void neDetectePasImmatriculation() {
		ISystemeInformatique sys = new MockSystemeInformatique();
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		
		//On definit ici l'identifiant du client, son immatriculation, et son abonnement.
		Integer idClient = 1;
		Integer immatriculationClient = 123456789;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		
		//On definit les véhicules qu'il possède

		IVehicule vehicule = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		//On définit maintenant le client lui-meme
		IClientAbonne clientAbonne =  new MockClientAbonne(vehicule, carteAbonnement);
		
		sys.enregistreClientAbonne(132456788, idClient, abonnement);
		clientAbonne.sePlaceDevantBarriere();
		
		Assert.assertEquals(false, this.detecteur.detecteImmatriculationVehicule(vehicule, sys, lecteurAbo));
	}
	
	@Test
	public void fermeLaBarriere() throws BarriereErreur {
		IBarriereSortie barriere = new MockBarriereSortie();
		barriere.ouvrir();
		this.detecteur.fermeBarriere(barriere);
		Assert.assertEquals(false, barriere.isOuverte());
	}
	
	@Test
	public void majPanneau() {
		IPanneauAffichage panneau = new MockPanneauAffichage();
		int avant = panneau.getNombrePlacesLibres();
		this.detecteur.metAJourPanneauAffichage(panneau);
		int apres = panneau.getNombrePlacesLibres();
		Assert.assertEquals(avant, apres - 1);
	}
	
	
}
