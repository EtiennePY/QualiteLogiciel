package Client;

import abonnement.Abonnement;
import vehicule.Vehicule;

public interface IClient {
	public void sePlaceDevantBarriere();
	public void passe();
	public void demandeAbonnement(Client client, Vehicule vehicule, Abonnement abonnement);
	public void payeAbonnement(int prix);
}
