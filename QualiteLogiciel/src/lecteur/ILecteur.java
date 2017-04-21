package lecteur;

import carte.Carte;
import ticket.Ticket;

public interface ILecteur {

  public void demandeInsertionCarte(Carte carte);

  public Ticket restitutionTicket();
  
  public boolean verificationTicket(Ticket ticket);
  
  public Carte restitutionCarte();
  
  public boolean contacterBanque(Carte carte);
}
