package lecteur;

import carte.Carte;
import ticket.Ticket;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILecteur.
 */
public interface ILecteur {

  /**
   * Demande insertion carte.
   *
   * @param carte the carte
   */
  public void demandeInsertionCarte(Carte carte);

  /**
   * Restitution ticket.
   *
   * @return the ticket
   */
  public Ticket restitutionTicket();
  
  /**
   * Verification ticket.
   *
   * @param ticket the ticket
   * @return true, if successful
   */
  public boolean verificationTicket(Ticket ticket);
  
  /**
   * Restitution carte.
   *
   * @return the carte
   */
  public Carte restitutionCarte();
  
  /**
   * Contacter banque.
   *
   * @param carte the carte
   * @return true, if successful
   */
  public boolean contacterBanque(Carte carte);
}
