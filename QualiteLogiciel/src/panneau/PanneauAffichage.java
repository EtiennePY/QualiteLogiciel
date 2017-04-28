package panneau;

public class PanneauAffichage {
	protected final int NBPLACES = 400;
	protected int entres;
	protected int sortis;
	public int getSortis() {
		return sortis;
	}
	public void setSortis(int sortis) {
		this.sortis = sortis;
	}
	public int getNombrePlacesLibres() {
		return this.NBPLACES - this.entres + this.sortis;
	}
	public int getEntres() {
		return entres;
	}
	public void setEntres(int entres) {
		this.entres = entres;
	}
	
	public void add(){
		this.setEntres(this.getEntres()+1);
		System.out.println("Le panneau d'affichage incr�mente le nombre de vehicules entr�s");
	}
	
	public void minus(){
		this.setSortis(this.sortis+1);
		System.out.println("Le panneau d'affichage incr�mente le nombre de vehicules sortis");
	}
}
