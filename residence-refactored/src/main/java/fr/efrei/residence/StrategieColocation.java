package fr.efrei.residence;

public class StrategieColocation implements StrategieLogement {
    @Override
    public double loyerBase(Logement logement) {
        return logement.getSurface() * CalculateurLoyer.TARIF_M2_COLOCATION / logement.getNombrePlaces();
    }
    @Override
    public double charges() { return CalculateurLoyer.CHARGES_COLOCATION; }
    @Override
    public double coefficientMenage() { return CalculateurLoyer.COEFFICIENT_MENAGE_COLOCATION; }
    @Override
    public double prixFibre() { return 0; }
    @Override
    public int normaliserParametre(int param) {
        return Math.max(param, GestionResidence.PLACES_COLOCATION_MINIMUM);
    }
    @Override
    public int capacite(Logement logement) { return logement.getNombrePlaces(); }
    @Override
    public int occupation(Logement logement) { return logement.getColocataires().size(); }
}
