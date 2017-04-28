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
		System.out.println("La barrière s'ouvre");
	}
	
	public void fermer() {
		this.setOuverte(false);
		System.out.println("La barrière se ferme");
	}

}
