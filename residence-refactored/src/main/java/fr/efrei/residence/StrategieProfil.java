package fr.efrei.residence;

public interface StrategieProfil {
    int ECHELON_BOURSE_MINIMUM = 0;
    int ECHELON_BOURSE_MAXIMUM = 7;
    int MULTIPLICATEUR_SOLVABILITE_ALTERNANT = 2;
    int MULTIPLICATEUR_SOLVABILITE_STANDARD = 3;
    int MOIS_CAUTION_INTERNATIONAL = 2;
    double FRAIS_DOSSIER_INTERNATIONAL = 150;
    double FRAIS_DOSSIER_STANDARD = 100;
    double TAUX_PENALITE_RETARD = 0.05;
    double PENALITE_MINIMALE = 10;
    int PREAVIS_REDUIT_JOURS = 15;
    int PREAVIS_STANDARD_JOURS = 30;
    double REMISE_PAR_ECHELON = 0.05;
    double REMISE_BOURSIER_MAXIMALE = 0.30;
    double COEFFICIENT_ALTERNANT = 0.90;

    default double appliquerRemise(double montant, int echelon) { return montant; }
    default boolean estSolvable(double ressources, double loyerCC) {
        return ressources >= loyerCC * MULTIPLICATEUR_SOLVABILITE_STANDARD;
    }
    default double calculerCaution(double loyerHC) { return loyerHC; }
    default double fraisDossier() { return FRAIS_DOSSIER_STANDARD; }
    default int dureePreavis() { return PREAVIS_STANDARD_JOURS; }
    default double penaliteRetard(double loyerCC) {
        return Utils.arrondir(Math.max(loyerCC * TAUX_PENALITE_RETARD,
                PENALITE_MINIMALE));
    }
    default String erreurInscription(int echelon, String telephone) { return null; }
    default boolean emailSupplementaire() { return false; }
}
