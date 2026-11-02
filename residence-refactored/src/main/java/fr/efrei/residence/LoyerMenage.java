package fr.efrei.residence;

public final class LoyerMenage extends DecorateurLoyer {
    private final StrategieLogement strategie;

    public LoyerMenage(Loyer loyer, StrategieLogement strategie) {
        super(loyer);
        this.strategie = strategie;
    }

    @Override
    public double montant() {
        return loyer.montant() * strategie.coefficientMenage();
    }
}
