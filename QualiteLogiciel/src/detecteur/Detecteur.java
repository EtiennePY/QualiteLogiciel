package detecteur;

public abstract class Detecteur implements IDetecteur{
	protected boolean present;

	
	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}


	@Override
	public void detecteClient() {
		
	}

	@Override
	public void fermeBarriere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void metAJourPanneauAffichage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void compterVoiture() {
		// TODO Auto-generated method stub
		
	}
}
