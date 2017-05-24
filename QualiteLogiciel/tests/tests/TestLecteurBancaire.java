package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import banque.impl.MockBanque;
import banque.inter.IBanque;
import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import date.impl.DateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.impl.LecteurBancaire;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import mocks.cartes.MockCarteBancaire;
import mocks.lecteurs.MockLecteurTicket;
import mocks.systemeinfo.MockSystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;

// TODO: Auto-generated Javadoc
/**
 * The Class TestLecteurBancaire.
 */
public class TestLecteurBancaire {

	/** The expected ex. */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	/** The lecteur. */
	private ILecteurBancaire lecteur;
	
	/**
	 * Instanciation lecteur.
	 */
	@Before 
	public void instanciationLecteur() {
		this.lecteur = new LecteurBancaire();
	}
	
	/**
	 * Instanciation correcte.
	 */
	@Test
	public void instanciationCorrecte() {
		Assert.assertEquals(CarteWithout.instance(), this.lecteur.getCarteBancaire());
	}
	
	/**
	 * Settergetterbanque.
	 */
	@Test
	public void settergetterbanque() {

		IBanque banque = new MockBanque();
		lecteur.setBanque(banque);
		Assert.assertEquals(lecteur.getBanque(), banque);
	}
	
	/**
	 * Demande insertion correcte.
	 */
	@Test
	public void demandeInsertionCorrecte() {
		Assert.assertEquals(true, this.lecteur.demandeInsertionCarte(true));
	}
	
	/**
	 * Demande insertion incorrecte.
	 */
	@Test
	public void demandeInsertionIncorrecte() {
		Assert.assertEquals(false, this.lecteur.demandeInsertionCarte(false));
	}
	
	/**
	 * Restitution sans problemes.
	 */
	@Test
	public void restitutionSansProblemes() {
		Assert.assertEquals(true, this.lecteur.restitutionCarteBancaire(true));
	}
	
	/**
	 * Restitution avec problemes.
	 */
	@Test
	public void restitutionAvecProblemes() {
		Assert.assertEquals(false, this.lecteur.restitutionCarteBancaire(false));
	}
	
	/**
	 * Check carte correct.
	 *
	 * @throws BarriereErreur the barriere erreur
	 * @throws TicketErreur the ticket erreur
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void checkCarteCorrect() throws BarriereErreur, TicketErreur, CarteBancaireErreur {
		IAbstractCarte carte = new MockCarteBancaire(123456789);
		this.lecteur.setCarteBancaire(carte);
		ILecteurTicket lecteurTicket = new MockLecteurTicket();
		lecteurTicket.setTicketClient(new TicketWith(new DateTicket(16, 4, 16, 30, 30)));
		ISystemeInformatique sys = new MockSystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		Assert.assertEquals(true, this.lecteur.realiseTransaction(sys, lecteurTicket, barriere));
	}
	
	
	/**
	 * Check sans carte.
	 *
	 * @throws BarriereErreur the barriere erreur
	 * @throws TicketErreur the ticket erreur
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void checkSansCarte() throws BarriereErreur, TicketErreur, CarteBancaireErreur {
		expectedEx.expect(CarteBancaireErreur.class);
		String message = "Aucune carte n'a ete inseree !";
	    expectedEx.expectMessage(message);
	    
		ILecteurTicket lecteurTicket = new MockLecteurTicket();
		lecteurTicket.setTicketClient(new TicketWith(new DateTicket(16, 4, 16, 30, 30)));
		ISystemeInformatique sys = new MockSystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		this.lecteur.realiseTransaction(sys, lecteurTicket, barriere);	}


	/**
	 * Check sans ticket.
	 *
	 * @throws BarriereErreur the barriere erreur
	 * @throws TicketErreur the ticket erreur
	 * @throws CarteBancaireErreur the carte bancaire erreur
	 */
	@Test
	public void checkSansTicket() throws BarriereErreur, TicketErreur, CarteBancaireErreur {
		expectedEx.expect(TicketErreur.class);
		String message = "Pas de ticket dans le lecteur de ticket.";
	    expectedEx.expectMessage(message);
	    
		IAbstractCarte carte = new MockCarteBancaire(123456789);
		this.lecteur.setCarteBancaire(carte);

		ILecteurTicket lecteurTicket = new MockLecteurTicket();
		ISystemeInformatique sys = new MockSystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		this.lecteur.realiseTransaction(sys, lecteurTicket, barriere);	}


}
