package fr.efrei.residence;

public class StrategieAlternant implements StrategieProfil {
    @Override
    public double appliquerRemise(double montant, int echelon) {
        return montant * COEFFICIENT_ALTERNANT;
    }
    @Override
    public boolean estSolvable(double ressources, double loyerCC) {
        return ressources >= loyerCC * MULTIPLICATEUR_SOLVABILITE_ALTERNANT;
    }
    @Override
    public int dureePreavis() { return PREAVIS_REDUIT_JOURS; }
}
