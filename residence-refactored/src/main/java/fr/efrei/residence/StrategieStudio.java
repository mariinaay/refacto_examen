package fr.efrei.residence;

public class StrategieStudio implements StrategieLogement {
    @Override
    public double loyerBase(Logement logement) { return Math.max(logement.getSurface() * CalculateurLoyer.TARIF_M2_STUDIO, CalculateurLoyer.LOYER_MINIMUM_STUDIO); }
}
