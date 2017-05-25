package clients.inter;

import banque.inter.IBanque;
import cartes.inter.IAbstractCarte;
import erreurs.CarteBancaireErreur;
import erreurs.TicketErreur;
import lecteurs.bancaire.inter.ILecteurBancaire;
import lecteurs.ticket.inter.ILecteurTicket;
import ticket.inter.IAbstractTicket;

// TODO: Auto-generated Javadoc
/**
 * The Interface IClientNonAbonne.
 */
public interface IClientNonAbonne extends IAbstractClient {
  
  
  /**
   * Insere ticket.
   *
   * @param lecteurTicket the lecteur ticket
   * @throws TicketErreur the ticket erreur
   */
  void insereTicket(final ILecteurTicket lecteurTicket) throws TicketErreur;
  
  /**
   * Insere carte bancaire.
   *
   * @param carte the carte
   * @throws CarteBancaireErreur the carte bancaire erreur
   */
  void insereCarteBancaire(ILecteurBancaire carte) throws CarteBancaireErreur;
  
  /**
   * Gets the carte bancaire.
   *
   * @return the carte bancaire
   */
  IAbstractCarte getCarteBancaire();
  
  /**
   * Gets the banque.
   *
   * @return the banque
   */
  IBanque getBanque();
  

  /**
   * Sets the banque.
   *
   * @param banque the new banque
   */
  void setBanque(final IBanque banque);
  
  
  /**
   * Sets the carte bancaire.
   *
   * @param carteBancaire the new carte bancaire
   */
  void setCarteBancaire(IAbstractCarte carteBancaire);
  
  /**
   * Gets the ticket.
   *
   * @return the ticket
   */
  IAbstractTicket getTicket();
  
  /**
   * Sets the ticket.
   *
   * @param ticket the new ticket
   */
  void setTicket(IAbstractTicket ticket);
  
  /**
   * Recupere ticket.
   *
   * @param lecteur the lecteur
   */
  void recupereTicket(final ILecteurTicket lecteur);

  /**
   * Recupere carte bancaire.
   *
   * @param lecteurBancaire the lecteur bancaire
   */
  void recupereCarteBancaire(final ILecteurBancaire lecteurBancaire);
  
}
