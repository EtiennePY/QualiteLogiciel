package systemeinfo.impl;

import abonnement.Abonnement;
import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import cartes.inter.IAbstractCarteWith;
import date.impl.DateTicket;
import date.inter.IDateTicket;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
import erreurs.TicketErreur;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import lecteurs.abonnement.inter.ILecteurCarteAbonnement;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import systemeinfo.inter.ISystemeInformatique;
import ticket.inter.IAbstractTicket;
import ticket.inter.ITicketWith;

// TODO: Auto-generated Javadoc
/**
 * The Class SystemeInformatique.
 */
public class SystemeInformatique implements ISystemeInformatique {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(SystemeInformatique.class.getName());

  /** The abonnements. */
  //a partir de l'immatriculation trouver l'abonnement
  private final Map<Integer, Abonnement> abonnements;


  /** The immatriculations. */
  //a partir de l'id trouver l'immatriculation
  private final Map<Integer, Integer> immatriculations;
    
  /** The dates ticket. */
  private final Set<IDateTicket> datesTicket;
    
  /** The date du jour. */
  private IDateTicket dateDuJour = new DateTicket(16,04, 16, 30, 30);
  
  /**
   * Instantiates a new systeme informatique.
   */
  public SystemeInformatique() {
    this.abonnements = new HashMap<Integer, Abonnement>();
    this.immatriculations = new HashMap<Integer, Integer>();
    this.datesTicket = new HashSet<IDateTicket>();

  }
  
  /**
   * Gets the abonnements.
   *
   * @return the abonnements
   */
  public Map<Integer, Abonnement> getAbonnements() {
    return abonnements;
  }



  /**
   * Gets the immatriculations.
   *
   * @return the immatriculations
   */
  public Map<Integer, Integer> getImmatriculations() {
    return immatriculations;
  }

  /**
   * Enregistre client abonne.
   *
   * @param immatriculation the immatriculation
   * @param identifiant the id
   * @param abonnement the abonnement
   */
  public void enregistreClientAbonne(final Integer immatriculation,
       final Integer identifiant, final Abonnement abonnement) {
    this.getImmatriculations().put(identifiant, immatriculation);
    this.getAbonnements().put(immatriculation, abonnement);
  }
  
  /**
   * Enregistre client non abonne.
   *
   * @param date the date
   */
  public void enregistreClientNonAbonne(final IDateTicket date) {
    this.getDatesTicket().add(date);
  }
  
  /**
   * Gets the date du jour.
   *
   * @return the date du jour
   */
  public IDateTicket getDateDuJour() {
    return dateDuJour;
  }
  
  /**
   * Sets the date du jour.
   *
   * @param dateDuJour the new date du jour
   */
  public void setDateDuJour(final IDateTicket dateDuJour) {
    this.dateDuJour = dateDuJour;
  }
  
  /**
   * Gets the dates ticket.
   *
   * @return the dates ticket
   */
  public Set<IDateTicket> getDatesTicket() {
    return datesTicket;
  }
  
  /**
   * Check abonnement.
   * @param carte lecteur, barriere
   * @return true, if successful
   * @throws CarteAbonnementErreur
   * 
   * @throws BarriereErreur
   * 
   */
  public boolean checkAbonnement(final IAbstractCarte carte, final ILecteurCarteAbonnement lecteur,
      final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur {
    if (carte.isWith()) {
      final IAbstractCarteWith carteWith = (IAbstractCarteWith) carte;
      final Integer identifiant = carteWith.getIdentifiant();
      final boolean result = immatriculations.containsKey(identifiant);
      
      if (result) {
        LOG.info("La carte ayant pour id " + immatriculations 
            + " est reconnue par le système informatique");
        this.ouvreBarriere(barriere);

      } else {
        LOG.info("La carte ayant pour id " + identifiant 
            + " n'est pas reconnue par le système informatique");
      } 
      lecteur.restitutionCarte(result);
      return result;
    } else {
      throw new CarteAbonnementErreur("Aucune carte d'abonnement n'a ete inseree !");
    }
  }


  

  /**
   * Ouvre barriere.
   *
   * @param barriere the barriere
   * @throws BarriereErreur the barriere erreur
   */
  public void ouvreBarriere(final IBarriereSortie barriere) throws BarriereErreur {
    LOG.info("Le système informatique provoque l'ouverture de la barrière");
    barriere.ouvrir();    

  }

  /**
   * Check ticket.
   *
   * @param ticket the ticket, lecteur, barriere, lecteurBancaire
   * @return true, if successful
   * @throws TicketErreur the ticket erreur
   * @throws BarriereErreur the barriere erreur
   */
  public boolean checkTicket(final IAbstractTicket ticket, final ILecteurTicket lecteur,
      final ILecteurBancaire lecteurBancaire) throws TicketErreur {
    if (ticket.isWith()) {
      final ITicketWith ticketWith = (ITicketWith) ticket;
      final IDateTicket date = ticketWith.getDateTicket();
      final boolean result = datesTicket.contains(date);
      
      if (result) {
        LOG.info("Le ticket ayant pour date " + date.toString()
            + " est reconnue par le système informatique");
        lecteurBancaire.demandeInsertionCarte(result);

      } else {
        LOG.info("Le ticket ayant pour date " + date.toString() 
            + " n'est pas reconnue par le système informatique");
      } 
      lecteur.restitutionTicket(result);
      return result;
    } else {
      throw new TicketErreur("Aucun ticket n'a ete insere !");
    }
  }

  /**
   * Calcul prix.
   *
   * @param date the date
   * @return the int
   */
  public int calculPrix(final IDateTicket date) {
    LOG.info("Calcul du prix en fonction de la durée de stationnement ...");
    return (dateDuJour.getHeure() - date.getHeure()) + (dateDuJour.getJour() - date.getJour()) * 24;
  }

  
}