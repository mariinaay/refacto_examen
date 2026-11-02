package fr.efrei.residence;

import java.util.Map;

public class LogementFactory {
    @FunctionalInterface
    private interface CreateurLogement {
        Logement creer(String numero, double surface, int etage, boolean meuble, int param);
    }

    private final Map<TypeLogement, CreateurLogement> createurs = Map.of(
            TypeLogement.STUDIO, (numero, surface, etage, meuble, param) -> new Studio(numero, surface, etage, meuble),
            TypeLogement.T1, (numero, surface, etage, meuble, param) -> new T1(numero, surface, etage, meuble),
            TypeLogement.T2, (numero, surface, etage, meuble, param) -> new T2(numero, surface, etage, meuble, param),
            TypeLogement.COLOCATION, (numero, surface, etage, meuble, param) -> new Colocation(numero, surface, etage, meuble, param));

    public Logement creer(TypeLogement type, String numero, double surface,
                          int etage, boolean meuble, int param) {
        if (type == null) {
            return null;
        }
        return createurs.get(type).creer(numero, surface, etage, meuble, param);
    }
}
