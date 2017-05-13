package lecteurs.abonnement.inter;

import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import erreurs.BarriereErreur;
import erreurs.CarteInsereeErreur;
import systemeinfo.inter.ISystemeInformatique;

// TODO: Auto-generated Javadoc
/**
 * The Interface ILecteurCarteAbonnement.
 */
public interface ILecteurCarteAbonnement {
  
  /**
   * Restitution carte.
   *
   * @param retour the retour
   */
  void restitutionCarte(boolean retour);
  
  /**
   * Demande insertion carte.
   *
   * @param detecte the detecte
   */
  void demandeInsertionCarte(boolean detecte);
  
  /**
   * Check abonnement.
   *
   * @param sys the sys
   * @return true, if successful
   * @throws CarteInsereeErreur the carte inseree erreur
 * @throws BarriereErreur 
   */
  boolean checkAbonnement(ISystemeInformatique sys, final IBarriereSortie barriere) throws CarteInsereeErreur, BarriereErreur;
  
  /**
   * Gets the carte client.
   *
   * @return the carte client
   */
  IAbstractCarte getCarteClient();
  
  /**
   * Sets the carte client.
   *
   * @param carteClient the new carte client
   */
  void setCarteClient(final IAbstractCarte carteClient);

}
