package fr.efrei.residence;

public final class LoyerRezDeChaussee extends DecorateurLoyer {
    public LoyerRezDeChaussee(Loyer loyer) {
        super(loyer);
    }

    @Override
    public double montant() {
        return loyer.montant() * CalculateurLoyer.COEFFICIENT_REZ_DE_CHAUSSEE;
    }
}
