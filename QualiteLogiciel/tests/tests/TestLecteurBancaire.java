package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import barriere.impl.BarriereSortie;
import barriere.inter.IBarriereSortie;
import cartes.impl.CarteBancaire;
import cartes.impl.CarteWithout;
import cartes.inter.IAbstractCarte;
import date.impl.DateTicket;
import erreurs.BanqueErreur;
import erreurs.BarriereErreur;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.impl.LecteurBancaire;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.impl.LecteurTicket;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.impl.SystemeInformatique;
import systemeinfo.inter.ISystemeInformatique;
import ticket.impl.TicketWith;

public class TestLecteurBancaire {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	private ILecteurBancaire lecteur;
	@Before 
	public void instanciationLecteur() {
		this.lecteur = new LecteurBancaire();
	}
	
	@Test
	public void instanciationCorrecte() {
		Assert.assertEquals(CarteWithout.instance(), this.lecteur.getCarteBancaire());
	}
	
	@Test
	public void demandeInsertionCorrecte() {
		Assert.assertEquals(true, this.lecteur.demandeInsertionCarte(true));
	}
	@Test
	public void demandeInsertionIncorrecte() {
		Assert.assertEquals(false, this.lecteur.demandeInsertionCarte(false));
	}
	
	@Test
	public void restitutionSansProblemes() {
		Assert.assertEquals(true, this.lecteur.restitutionCarteBancaire(true));
	}
	
	@Test
	public void restitutionAvecProblemes() {
		Assert.assertEquals(false, this.lecteur.restitutionCarteBancaire(false));
	}
	
	@Test
	public void checkCarteCorrect() throws BarriereErreur, BanqueErreur, TicketErreur, CarteBancaireErreur {
		IAbstractCarte carte = new CarteBancaire(123456789);
		this.lecteur.setCarteBancaire(carte);
		ILecteurTicket lecteurTicket = new LecteurTicket();
		lecteurTicket.setTicketClient(new TicketWith(new DateTicket(16, 4, 16, 30, 30)));
		ISystemeInformatique sys = new SystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		Assert.assertEquals(true, this.lecteur.realiseTransaction(sys, lecteurTicket, barriere));
	}
	
	
	@Test
	public void checkSansCarte() throws BarriereErreur, TicketErreur, BanqueErreur, CarteBancaireErreur {
		expectedEx.expect(CarteBancaireErreur.class);
		String message = "Aucune carte n'a ete inseree !";
	    expectedEx.expectMessage(message);
	    
		ILecteurTicket lecteurTicket = new LecteurTicket();
		lecteurTicket.setTicketClient(new TicketWith(new DateTicket(16, 4, 16, 30, 30)));
		ISystemeInformatique sys = new SystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		this.lecteur.realiseTransaction(sys, lecteurTicket, barriere);	}


	@Test
	public void checkSansTicket() throws BarriereErreur, TicketErreur, BanqueErreur, CarteBancaireErreur {
		expectedEx.expect(TicketErreur.class);
		String message = "Pas de ticket dans le lecteur de ticket.";
	    expectedEx.expectMessage(message);
	    
		IAbstractCarte carte = new CarteBancaire(123456789);
		this.lecteur.setCarteBancaire(carte);

		ILecteurTicket lecteurTicket = new LecteurTicket();
		ISystemeInformatique sys = new SystemeInformatique();
		
		IBarriereSortie barriere = new BarriereSortie(); 
		this.lecteur.realiseTransaction(sys, lecteurTicket, barriere);	}


}
