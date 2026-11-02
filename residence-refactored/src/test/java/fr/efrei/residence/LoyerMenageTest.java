package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerMenageTest {
    @Test
    void appliqueLeTarifIndividuel() {
        Loyer loyer = new LoyerMenage(new LoyerBase(100), new StrategieStudio());
        assertEquals(108, loyer.montant(), 0.000001);
    }

    @Test
    void appliqueLeTarifColocation() {
        Loyer loyer = new LoyerMenage(new LoyerBase(100), new StrategieColocation());
        assertEquals(104, loyer.montant(), 0.000001);
    }
}
