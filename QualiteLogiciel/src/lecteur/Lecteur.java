package lecteur;

import carte.Carte;
import ticket.Ticket;

public abstract class Lecteur {

  public Ticket restitutionTicket() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public boolean verificationTicket(Ticket ticket) {
    // TODO Auto-generated method stub
    return false;
  }
  
  public Carte restitutionCarte() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public boolean contacterBanque(int prix) {
    // TODO Auto-generated method stub
    return false;
  }

  public void demandeInsertionCarte(boolean detecte) {

  }
  
}