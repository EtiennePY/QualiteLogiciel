package lecteurCarteAbonnement.impl;

import java.util.logging.Logger;

import cartes.impl.AbstractCarte;
import cartes.impl.AbstractCarteWith;
import cartes.impl.CarteWithout;
import clients.impl.ClientAbonne;
import erreurs.CarteInsereeErreur;
import lecteurCarteAbonnement.inter.ILecteurCarteAbonnement;
import systemeInformatique.impl.SystemeInformatique;

public class LecteurCarteAbonnement implements ILecteurCarteAbonnement {

  public LecteurCarteAbonnement() {
    this.carteClient = CarteWithout.instance();
  }

  private AbstractCarte carteClient;
  /** The logger. */

  private static final Logger LOG = Logger.getLogger(ClientAbonne.class.getName());

  public void restitutionCarte(boolean retour) { 
    if(retour) {
      LOG.info("Un message s'affiche : \"OK\" sur l'écran du lecteur et la carte sort" );
    } else {
      LOG.info("Un message s'affiche : \"Carte erronée\" sur l'écran du lecteur et la carte sort" );
    }
  }
  
  
public void demandeInsertionCarte(boolean detecte) {
    if (detecte) {
      LOG.info("L'écran du lecteur de carte d'abonnement affiche \"Insérez votre carte d'abonnement\"");
    }
  }
  
  public boolean checkAbonnement(SystemeInformatique sys) throws CarteInsereeErreur {
	if (this.getCarteClient().isWith()) {
		this.setCarteClient(this.getCarteClient());
		LOG.info("Le lecteur de carte d'abonnement reçoit la carte d'abonnement.");
		return sys.checkAbonnement((AbstractCarteWith) this.getCarteClient(), this);
	} else {
		throw new CarteInsereeErreur();
	}
  }
  
  public AbstractCarte getCarteClient() {
    return carteClient;
  }

  public void setCarteClient(final AbstractCarte carteClient) {
    this.carteClient = carteClient;
  }
}