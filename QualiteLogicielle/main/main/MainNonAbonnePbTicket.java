package main;

import banque.impl.MockBanque;
import banque.inter.IBanque;
import cartes.impl.CarteBancaire;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientNonAbonne;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import detecteur.impl.DetecteurSortie;
import detecteur.inter.IDetecteurSortie;
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
import ticket.inter.IAbstractTicket;
import ticket.inter.ITicketWith;
import vehicule.impl.CategorieVehicule;
import vehicule.impl.Vehicule;
import vehicule.inter.IVehicule;

// TODO: Auto-generated Javadoc
/**
 * The Class MainNonAbonnePbTicket.
 */
public class MainNonAbonnePbTicket {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws BarriereErreur the barriere erreur
   * @throws TicketErreur the ticket erreur
   * @throws CarteBancaireErreur the carte bancaire erreur
   */
  public static void main(String[] args) throws BarriereErreur, TicketErreur, CarteBancaireErreur {

    //Nous sommes le 16 mai
    IDateTicket dateDuJour = new DateTicket(16,04, 16, 30, 30);

    //Carte Bancaire et ticket du client
    Integer idCarteBancaire = 1337;
    IAbstractCarte cbClient = new CarteBancaire(idCarteBancaire);
    IAbstractTicket ticketClient = 
        new TicketWith(new DateTicket(02,04, 16, 30, 30)); //entré dans le parking le 2 mai

    //Véhicule du client
    Integer immatriculationGrosHummer = 420;

    IVehicule grosHummer = new Vehicule(CategorieVehicule.CAMION, immatriculationGrosHummer);

    //Banque du client
    IBanque banqueClient = new MockBanque();

    //Client
    ClientNonAbonne etienne = new ClientNonAbonne(grosHummer,cbClient, banqueClient);
    etienne.setTicket(new TicketWith(new DateTicket(02,  03, 16, 30, 30)));

    //On cree le detecteur
    IDetecteurSortie detecteur = new DetecteurSortie();


    //On cree les lecteurs de carte bancaire et de ticket
    ILecteurBancaire lecteurCarteBancaire = new LecteurBancaire();
    ILecteurTicket lecteurTicket = new LecteurTicket();


    //On cree le systeme informatique
    ISystemeInformatique sys = new SystemeInformatique();
    sys.enregistreClientNonAbonne(((ITicketWith)ticketClient).getDateTicket());
    sys.setDateDuJour(dateDuJour);

    //Début de la séquence
    etienne.sePlaceDevantBarriere();
    detecteur.detecteClient(grosHummer, lecteurTicket);

    etienne.insereTicket(lecteurTicket);
    lecteurTicket.verificationTicket(sys, lecteurCarteBancaire);

    

  }

}
