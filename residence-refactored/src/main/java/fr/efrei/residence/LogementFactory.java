package fr.efrei.residence;

public class LogementFactory {

    public Logement creer(TypeLogement type, String numero, double surface,
                          int etage, boolean meuble, int param) {
        if (type == null) {
            return null;
        }
        return switch (type) {
            case STUDIO     -> new Studio(numero, surface, etage, meuble);
            case T1         -> new T1(numero, surface, etage, meuble);
            case T2         -> new T2(numero, surface, etage, meuble, param);
            case COLOCATION -> new Colocation(numero, surface, etage, meuble, param);
        };
    }
}
