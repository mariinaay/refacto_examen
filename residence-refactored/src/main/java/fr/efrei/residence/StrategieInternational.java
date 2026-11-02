package fr.efrei.residence;

public class StrategieInternational implements StrategieProfil {
    @Override
    public double calculerCaution(double loyerHC) {
        return loyerHC * MOIS_CAUTION_INTERNATIONAL;
    }
    @Override
    public double fraisDossier() { return FRAIS_DOSSIER_INTERNATIONAL; }
    @Override
    public String erreurInscription(int echelon, String telephone) {
        if (telephone == null || !telephone.startsWith("+")) {
            return "Inscription refusée : numéro international (+XX) obligatoire";
        }
        return null;
    }
    @Override
    public boolean emailSupplementaire() { return true; }
}
