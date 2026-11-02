package fr.efrei.residence;

public class StrategieBoursier implements StrategieProfil {
    @Override
    public double appliquerRemise(double montant, int echelon) {
        double taux = Math.min(echelon * REMISE_PAR_ECHELON,
                REMISE_BOURSIER_MAXIMALE);
        return montant * (1 - taux);
    }
    @Override
    public boolean estSolvable(double ressources, double loyerCC) { return true; }
    @Override
    public double calculerCaution(double loyerHC) { return 0; }
    @Override
    public double fraisDossier() { return 0; }
    @Override
    public int dureePreavis() { return PREAVIS_REDUIT_JOURS; }
    @Override
    public double penaliteRetard(double loyerCC) { return 0; }
    @Override
    public String erreurInscription(int echelon, String telephone) {
        if (echelon < ECHELON_BOURSE_MINIMUM
                || echelon > ECHELON_BOURSE_MAXIMUM) {
            return "Inscription refusée : échelon de bourse invalide";
        }
        return null;
    }
}
