package systemeInformatique;

import java.util.HashMap;
import java.util.logging.Logger;

import abonnement.Abonnement;
import barriere.IBarriereSortie;
import carte.Carte;
import client.ClientAbonne;
import lecteur.LecteurCarteAbonnement;
import ticket.Ticket;

public class SystemeInformatique implements ISystemeInformatique {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  //a partir de l'immatriculation trouver l'abonnement
  private HashMap<Integer, Abonnement> abonnements;

  
  //a partir de l'id trouver l'immatriculation
  protected HashMap<Integer, Integer> identifiants;

  public SystemeInformatique() {
    this.abonnements = new HashMap<Integer, Abonnement>();
    this.identifiants = new HashMap<Integer, Integer>();

  }
  public HashMap<Integer, Abonnement> getAbonnements() {
    return abonnements;
  }
  
  public void setAbonnements(HashMap<Integer, Abonnement> abonnements) {
    this.abonnements = abonnements;
  }
  
  public HashMap<Integer, Integer> getIds() {
    return identifiants;
  }
  
  public void setIds(HashMap<Integer, Integer> ids) {
    this.identifiants = identifiants;
  }
  
  
  public boolean checkAbonnement(Carte carte, LecteurCarteAbonnement lecteur){
    boolean result = identifiants.containsKey(carte.getIdentifiant());
     if(result) {
       this.carteAbonnementValide(carte);
     }
     else {
       this.mauvaiseCarteAbonnement(carte);
     }
    lecteur.restitutionCarte(result);
    return result;
  }
  
  
  public void enregistrerDateHeure() {
    // TODO Auto-generated method stub
  }
  
  
  public int calcuPrix() {
    // TODO Auto-generated method stub
    return 0;
  }
  
  
  public int donnePrixAPayer(int prix) {
    // TODO Auto-generated method stub
    return 0;
  }
  
  
  public boolean mauvaiseCarteAbonnement(Carte carte) {
    LOG.info("La carte ayant pour id "+carte.getIdentifiant()+" n'est pas reconnue par le système informatique");
    return false;
  }
  
  
  public boolean carteAbonnementValide(Carte carte) {
    LOG.info("La carte ayant pour id "+carte.getIdentifiant()+" est reconnue par le système informatique");
    return true;
  }
  
  
  public boolean ticketNonValide(Ticket ticket) {
    // TODO Auto-generated method stub
    return false;
  }

  
  public void changeAbonnement(int identifiant, Abonnement abonnement) {
    // TODO Auto-generated method stub
    
  }
  
  
  public void ouvreBarriere(IBarriereSortie barriere) {
    LOG.info("Le système informatique provoque l'ouverture de la barrière");
    barriere.ouvrir();    

  }
  
  
  public boolean checkTicket(Ticket ticket, LecteurCarteAbonnement lecteur) {
    // TODO Auto-generated method stub
    return false;
  }
  
  
  public boolean ticketValide(Ticket ticket) {
    // TODO Auto-generated method stub
    return false;
  }
}