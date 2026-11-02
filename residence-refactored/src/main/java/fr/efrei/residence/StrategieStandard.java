package fr.efrei.residence;

public class StrategieStandard implements StrategieProfil {
    @Override
    public double appliquerRemise(double montant, int echelon) {
        return montant;
    }

    @Override
    public boolean estSolvable(double ressources, double loyerCC) {
        return ressources >= loyerCC * MULTIPLICATEUR_SOLVABILITE_STANDARD;
    }

    @Override
    public double calculerCaution(double loyerHC) {
        return loyerHC;
    }

    @Override
    public double fraisDossier() {
        return FRAIS_DOSSIER_STANDARD;
    }

    @Override
    public int dureePreavis() {
        return PREAVIS_STANDARD_JOURS;
    }

    @Override
    public double penaliteRetard(double loyerCC) {
        return Utils.arrondir(Math.max(loyerCC * TAUX_PENALITE_RETARD,
                PENALITE_MINIMALE));
    }

    @Override
    public String erreurInscription(int echelon, String telephone) {
        return null;
    }

    @Override
    public boolean emailSupplementaire() {
        return false;
    }
}
