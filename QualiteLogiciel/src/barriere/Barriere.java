package barriere;

public abstract class Barriere {
	protected boolean ouverte;



	public boolean isOuverte() {
		return ouverte;
	}

	public void setOuverte(boolean ouverte) {
		this.ouverte = ouverte;
	}
	
	public void ouvrir() {
		this.setOuverte(true);
		System.out.println("La barri�re s'ouvre");
	}
	
	public void fermer() {
		this.setOuverte(false);
		System.out.println("La barri�re se ferme");
	}

}
