package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerAssuranceTest {
    @Test
    void appliqueLaCoucheAuLoyerExistant() {
        Loyer loyer = new LoyerAssurance(new LoyerBase(100));
        assertEquals(109, loyer.montant(), 0.000001);
    }
}
