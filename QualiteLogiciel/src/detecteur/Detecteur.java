package detecteur;

import barriere.Barriere;
import panneau.PanneauAffichage;

public abstract class Detecteur implements IDetecteur {
	protected boolean present; 

	
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}



	@Override
	public void fermeBarriere(Barriere barriere) {
		barriere.fermer();
		System.out.println("Le detecteur provoque la fermeture de la barrière");

	}

	@Override
	public void metAJourPanneauAffichage(PanneauAffichage panneau) {
		panneau.minus();
		System.out.println("Le détecteur met à jour le panneau d'affichage");
		
	}

	@Override
	public void compterVoiture() {
		// TODO Auto-generated method stub
		
	}
}
