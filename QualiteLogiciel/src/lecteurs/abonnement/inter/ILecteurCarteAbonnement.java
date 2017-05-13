package lecteurs.abonnement.inter;

import barriere.inter.IBarriereSortie;
import cartes.inter.IAbstractCarte;
import erreurs.BarriereErreur;
import erreurs.CarteAbonnementErreur;
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
  boolean restitutionCarte(boolean retour);
  
  /**
   * Demande insertion carte.
   *
   * @param detecte the detecte
   * @return true, if successful
   */
  boolean demandeInsertionCarte(boolean detecte);
  
  /**
   * Check abonnement.
   *
   * @param sys the sys
   * @param barriere the barriere
   * @return true, if successful
   * @throws CarteAbonnementErreur the carte inseree erreur
   * @throws BarriereErreur the barriere erreur
   */
  boolean checkAbonnement(ISystemeInformatique sys, final IBarriereSortie barriere) throws CarteAbonnementErreur, BarriereErreur;
  
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
