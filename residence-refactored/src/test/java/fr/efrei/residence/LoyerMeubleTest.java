package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerMeubleTest {
    @Test
    void appliqueLaCoucheAuLoyerExistant() {
        Loyer loyer = new LoyerMeuble(new LoyerBase(100));
        assertEquals(115, loyer.montant(), 0.000001);
    }
}
