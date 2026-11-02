package fr.efrei.residence;

public class StrategieT1 implements StrategieLogement {
    @Override
    public double loyerBase(Logement logement) { return logement.getSurface() * CalculateurLoyer.TARIF_M2_T1 + CalculateurLoyer.FORFAIT_T1; }
}
