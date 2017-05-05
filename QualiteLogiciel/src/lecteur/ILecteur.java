package lecteur;

import carte.Carte;
import error.TicketError;
import ticket.Ticket;

public interface ILecteur {

  public void demandeInsertionCarte();

  public Ticket restitutionTicket();
  
  public boolean verificationTicket(Ticket ticket) throws TicketError;
  
  public Carte restitutionCarte();
  
  public boolean contacterBanque(int prix);
}
