package fr.efrei.residence;

public final class LoyerLaverie extends DecorateurLoyer {
    public LoyerLaverie(Loyer loyer) {
        super(loyer);
    }

    @Override
    public double montant() {
        return loyer.montant() + CalculateurLoyer.PRIX_LAVERIE;
    }
}
