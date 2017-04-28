package carte;

public class CarteWithout extends Carte {
	
	public CarteWithout(){}
	
	private final static CarteWithout CARTEWITHOUT = new CarteWithout();
	
	public static CarteWithout instance() {
		return CarteWithout.CARTEWITHOUT;
	}
	public boolean isWithout(){
		return true;
	}
}
