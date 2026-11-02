package fr.efrei.residence;

public final class LoyerMeuble extends DecorateurLoyer {
    public LoyerMeuble(Loyer loyer) {
        super(loyer);
    }

    @Override
    public double montant() {
        return loyer.montant() * CalculateurLoyer.COEFFICIENT_MEUBLE;
    }
}
