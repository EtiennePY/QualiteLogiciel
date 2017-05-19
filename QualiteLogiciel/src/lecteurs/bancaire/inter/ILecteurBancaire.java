package lecteurs.bancaire.inter;

import banque.inter.IBanque;
import cartes.impl.AbstractCarte;
import cartes.inter.IAbstractCarte;
import clients.impl.ClientNonAbonne;
import clients.inter.IClientNonAbonne;

public interface ILecteurBancaire {
	
	public void demandeInsertionCarte(IAbstractCarte carte);
	
	public boolean contacterBanque(int prix);
	
	public IAbstractCarte restitutionCarteBancaire(boolean ok, ClientNonAbonne client);
	
	public void setBanque(IBanque banque);

}
