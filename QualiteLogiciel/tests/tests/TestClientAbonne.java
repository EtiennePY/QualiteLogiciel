package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abonnement.Abonnement;
import cartes.impl.CarteAbonnement;
import cartes.impl.CarteWithout;
import cartes.inter.ICarteAbonnement;
import clients.impl.ClientAbonne;
import clients.inter.IClientAbonne;
import lecteurs.abonnement.impl.LecteurCarteAbonnement;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

public class TestClientAbonne {
	
	private IClientAbonne client;
	
	@Before
	public void instanciation() {
		Integer immatriculationClient = 696969;
		
		
		//On definit les véhicules qu'il possède
		IVehicule voiturette = new Vehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		this.client = new ClientAbonne(voiturette, CarteWithout.instance());
	}
	
	@Test
	public void insereCarteAbonnement() {
		Integer idClient = 69;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		client.setCarteAbonnement(carteAbonnement);
		ILecteurCarteAbonnement lecteur = new LecteurCarteAbonnement();
		client.insereCarteAbonnement(lecteur);
		Assert.assertEquals(CarteWithout.instance(), client.getCarteAbonnement());
	}
	
	@Test
	public void recupereCarteAbonnement() {
		Integer idClient = 69;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new CarteAbonnement(idClient, abonnement);
		ILecteurCarteAbonnement lecteur = new LecteurCarteAbonnement();
		lecteur.setCarteClient(carteAbonnement);
		client.recupereCarteAbonnement(lecteur);
		Assert.assertEquals(carteAbonnement, client.getCarteAbonnement());
	}
	
	@Test
	public void estAbonne() {
		Assert.assertEquals(true, client.isAbonne());
	}
	
	@Test
	public void sePlaceDevantBarriere() {
		Assert.assertEquals("Le client se positionne devant la barrière", client.sePlaceDevantBarriere());
	}
	
	@Test
	public void passe() {
		Assert.assertEquals("Le client passe", client.passe());
	}

}
