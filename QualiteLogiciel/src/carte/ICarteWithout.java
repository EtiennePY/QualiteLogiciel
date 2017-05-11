package carte;

public interface ICarteWithout extends IAbstractCarte {
	
	//instance() est static donc pas dans l'interface (faiblesse de Java pour la maintenance)
	boolean isWithout();
}
