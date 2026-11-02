package fr.efrei.residence;

public class StrategieT2 implements StrategieLogement {
    @Override
    public double loyerBase(Logement logement) { return logement.getSurface() * CalculateurLoyer.TARIF_M2_T2 + CalculateurLoyer.FORFAIT_T2; }
}
