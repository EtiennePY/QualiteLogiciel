package main;

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

// TODO: Auto-generated Javadoc
/**
 * The Class MainAbonneOk.
 */
public class MainAbonneOk {

  /**
   * The main method.
   *
   * @param args the arguments
   * @throws CarteAbonnementErreur the carte abonnement erreur
   * @throws BarriereErreur the barriere erreur
   */
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
    //On ajoute au systeme informatique l'identifiant du client
    //et son immatriculation ainsi que son abonnement 
    //(supposons qu'il se soit inscrit auparavant)
    sys.enregistreClientAbonne(immatriculationClient, idClient, abonnement);

    //On cree le panneau d'affichage
    IPanneauAffichage panneau = new PanneauAffichage();
    IBarriereSortie barriere = new BarriereSortie();

    //Debut de la séquence
    antoine.sePlaceDevantBarriere();
    detecteur.detecteImmatriculationVehicule(voiturette, sys, lecteurAbo);

    //Si immatriculation du client est bien dans le SI
    antoine.insereCarteAbonnement(lecteurAbo);
    lecteurAbo.checkAbonnement(sys, barriere);
    antoine.recupereCarteAbonnement(lecteurAbo);

    //Si sa carte est valide
    antoine.passe();
    detecteur.metAJourPanneauAffichage(panneau);
    detecteur.fermeBarriere(barriere);




  }

}
