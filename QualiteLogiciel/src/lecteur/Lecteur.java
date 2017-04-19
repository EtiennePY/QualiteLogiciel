package lecteur;

import carte.Carte;
import ticket.Ticket;

// TODO: Auto-generated Javadoc
/**
 * The Class Lecteur.
 */
public class Lecteur implements ILecteur {

	/* (non-Javadoc)
	 * @see lecteur.ILecteur#demandeInsertionCarte(carte.Carte)
	 */
	@Override
	public void demandeInsertionCarte(Carte carte) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see lecteur.ILecteur#restitutionTicket()
	 */
	@Override
	public Ticket restitutionTicket() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lecteur.ILecteur#verificationTicket(ticket.Ticket)
	 */
	@Override
	public boolean verificationTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see lecteur.ILecteur#restitutionCarte()
	 */
	@Override
	public Carte restitutionCarte() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see lecteur.ILecteur#contacterBanque(carte.Carte)
	 */
	@Override
	public boolean contacterBanque(Carte carte) {
		// TODO Auto-generated method stub
		return false;
	}
  
}
