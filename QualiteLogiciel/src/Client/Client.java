package client;

import java.util.List;
import java.util.logging.Logger;

import vehicule.IVehicule;
import vehicule.Vehicule;

public abstract class Client {
  /** The logger. */
  private static final Logger LOG = Logger.getLogger(Client.class.getName());

  protected List<IVehicule> vehicules;
  
  public Client() {}
  
  public List<IVehicule> getVehicules() {
    return vehicules;
  }

  public void setVehicules(final List<IVehicule> vehicules) {
    this.vehicules = vehicules;
    for (IVehicule vehicule : this.vehicules) {
      vehicule.setImmatriculation((int)(Math.random()*10000));  
    }  
  }
  
  public void sePlaceDevantBarriere() {
    LOG.info("Le client se positionne devant la barrière.");
  }

  public void passe() {
    LOG.info("Le client passe");    
  }

}
