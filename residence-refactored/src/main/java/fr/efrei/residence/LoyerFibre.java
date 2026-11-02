package fr.efrei.residence;

public final class LoyerFibre extends DecorateurLoyer {
    private final StrategieLogement strategie;

    public LoyerFibre(Loyer loyer, StrategieLogement strategie) {
        super(loyer);
        this.strategie = strategie;
    }

    @Override
    public double montant() {
        return loyer.montant() + strategie.prixFibre();
    }
}
