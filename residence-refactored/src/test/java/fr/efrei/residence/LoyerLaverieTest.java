package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerLaverieTest {
    @Test
    void appliqueLaCoucheAuLoyerExistant() {
        Loyer loyer = new LoyerLaverie(new LoyerBase(100));
        assertEquals(112, loyer.montant(), 0.000001);
    }
}
