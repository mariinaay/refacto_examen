package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerParkingTest {
    @Test
    void appliqueLaCoucheAuLoyerExistant() {
        Loyer loyer = new LoyerParking(new LoyerBase(100));
        assertEquals(145, loyer.montant(), 0.000001);
    }
}
