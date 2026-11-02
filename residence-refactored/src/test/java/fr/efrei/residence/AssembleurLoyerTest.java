package fr.efrei.residence;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssembleurLoyerTest {
    @Test
    void appliqueMeublePuisRezDeChausseePuisMenagePuisOptionsFixes() {
        Logement logement = new Studio("A001", 30, 0, true);
        Loyer loyer = new AssembleurLoyer().assembler(logement, EnumSet.allOf(Option.class));
        assertEquals(581.558, loyer.montant(), 0.000001);
    }

    @Test
    void conserveLaBaseSansCoucheApplicable() {
        Logement logement = new Studio("A101", 30, 1, false);
        assertEquals(420, new AssembleurLoyer().assembler(logement, Set.of()).montant());
    }

    @Test
    void appliqueLaRemiseSurLeToutEtArronditSeulementALaFin() {
        Logement logement = new Studio("A001", 30, 0, true);
        assertEquals(523.40, new CalculateurLoyer().calculerLoyer(
                logement, Profil.ALTERNANT, 0, EnumSet.allOf(Option.class)), 0.000001);
    }

    @Test
    void respecteLesParticularitesDeLaColocation() {
        Logement logement = new Colocation("B301", 80, 3, false, 4);
        Loyer loyer = new AssembleurLoyer().assembler(logement, Set.of(Option.MENAGE, Option.FIBRE));
        assertEquals(228.80, loyer.montant(), 0.000001);
    }
}
