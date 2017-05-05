package detecteur;

import barriere.Barriere;
import client.IClient;
import panneau.PanneauAffichage;
import vehicule.Vehicule;

public interface IDetecteur {
	public void detecteClient(IClient client);
	public void fermeBarriere(Barriere barriere);
	public void metAJourPanneauAffichage(PanneauAffichage panneau);
	public void compterVoiture();
	public boolean isPresent();
	public void setPresent(boolean present);
	public void detecteImmatriculationVehicule(Vehicule vehicule, IClient client);
}
