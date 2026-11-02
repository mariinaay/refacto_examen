package fr.efrei.residence;

public final class LoyerAssurance extends DecorateurLoyer {
    public LoyerAssurance(Loyer loyer) {
        super(loyer);
    }

    @Override
    public double montant() {
        return loyer.montant() + CalculateurLoyer.PRIX_ASSURANCE;
    }
}
