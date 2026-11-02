package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerRezDeChausseeTest {
    @Test
    void appliqueLaCoucheAuLoyerExistant() {
        Loyer loyer = new LoyerRezDeChaussee(new LoyerBase(100));
        assertEquals(95, loyer.montant(), 0.000001);
    }
}
