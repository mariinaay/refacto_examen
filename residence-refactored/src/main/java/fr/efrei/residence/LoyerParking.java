package fr.efrei.residence;

public final class LoyerParking extends DecorateurLoyer {
    public LoyerParking(Loyer loyer) {
        super(loyer);
    }

    @Override
    public double montant() {
        return loyer.montant() + CalculateurLoyer.PRIX_PARKING;
    }
}
