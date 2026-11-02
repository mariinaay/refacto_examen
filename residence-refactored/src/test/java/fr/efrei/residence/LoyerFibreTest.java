package fr.efrei.residence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoyerFibreTest {
    @Test
    void appliqueLeTarifIndividuel() {
        Loyer loyer = new LoyerFibre(new LoyerBase(100), new StrategieStudio());
        assertEquals(120, loyer.montant(), 0.000001);
    }

    @Test
    void appliqueLeTarifColocation() {
        Loyer loyer = new LoyerFibre(new LoyerBase(100), new StrategieColocation());
        assertEquals(100, loyer.montant(), 0.000001);
    }
}
