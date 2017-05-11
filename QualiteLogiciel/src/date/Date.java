package date;

public class Date implements IDate {
	protected int jour;
	protected int heure;
	
	public Date(int jour, int heure){
		this.jour=jour;
		this.heure=heure;
	}
	public int getJour() {
		return jour;
	}
	public void setJour(int jour) {
		this.jour = jour;
	}
	public int getHeure() {
		return heure;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
}
