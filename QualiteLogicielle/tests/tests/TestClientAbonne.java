package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import abonnement.Abonnement;
import cartes.impl.CarteWithout;
import cartes.inter.ICarteAbonnement;
import clients.impl.ClientAbonne;
import clients.inter.IClientAbonne;
import erreurs.CarteAbonnementErreur;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import mocks.cartes.MockCarteAbonnement;
import mocks.lecteurs.MockLecteurCarteAbonnement;
import mocks.vehicule.MockVehicule;
import vehicule.impl.CategorieVehicule;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class TestClientAbonne.
 */
public class TestClientAbonne {
	
	/** The client. */
	private IClientAbonne client;
	
	/** The expected ex. */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	
	/**
	 * Instanciation.
	 */
	@Before
	public void instanciation() {
		Integer immatriculationClient = 696969;
		
		
		//On definit les véhicules qu'il possède
		IVehicule voiturette = new MockVehicule(CategorieVehicule.VOITURE, immatriculationClient);
		
		this.client = new ClientAbonne(voiturette, CarteWithout.instance());
	}
	
	/**
	 * Insere carte abonnement.
	 *
	 * @throws CarteAbonnementErreur the carte abonnement erreur
	 */
	@Test
	public void insereCarteAbonnement() throws CarteAbonnementErreur {
		Integer idClient = 69;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		client.setCarteAbonnement(carteAbonnement);
		ILecteurCarteAbonnement lecteur = new MockLecteurCarteAbonnement();
		client.insereCarteAbonnement(lecteur);
		Assert.assertEquals(CarteWithout.instance(), client.getCarteAbonnement());
	}
	
	/**
	 * Recupere carte abonnement.
	 */
	@Test
	public void recupereCarteAbonnement() {
		Integer idClient = 69;
		Abonnement abonnement = Abonnement.REGULIER;
		
		//On definit sa carte d'abonnement
		ICarteAbonnement carteAbonnement = new MockCarteAbonnement(idClient, abonnement);
		ILecteurCarteAbonnement lecteur = new MockLecteurCarteAbonnement();
		lecteur.setCarteClient(carteAbonnement);
		client.recupereCarteAbonnement(lecteur);
		Assert.assertEquals(carteAbonnement, client.getCarteAbonnement());
	}
	
	/**
	 * Est abonne.
	 */
	@Test
	public void estAbonne() {
		Assert.assertEquals(true, client.isAbonne());
	}
	
	/**
	 * Se place devant barriere.
	 */
	@Test
	public void sePlaceDevantBarriere() {
		Assert.assertEquals("Le client se positionne devant la barrière", client.sePlaceDevantBarriere());
	}
	
	/**
	 * Passe.
	 */
	@Test
	public void passe() {
		Assert.assertEquals("Le client passe", client.passe());
	}

	/**
	 * Erreur carte abonnement.
	 *
	 * @throws CarteAbonnementErreur the carte abonnement erreur
	 */
	@Test
	public void erreurCarteAbonnement() throws CarteAbonnementErreur {
		expectedEx.expect(CarteAbonnementErreur.class);
		String message = "Le client n'a pas de carte d'abonnement.";
	    expectedEx.expectMessage(message);
		ILecteurCarteAbonnement lecteurAbo = new MockLecteurCarteAbonnement();
		client.setCarteAbonnement(CarteWithout.instance());
	    client.insereCarteAbonnement(lecteurAbo);
	}
}
