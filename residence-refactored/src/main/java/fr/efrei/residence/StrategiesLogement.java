package fr.efrei.residence;

public final class StrategiesLogement {
    private StrategiesLogement() { }

    public static StrategieLogement choisir(TypeLogement type) {
        return switch (type) {
            case STUDIO -> new StrategieStudio();
            case T1 -> new StrategieT1();
            case T2 -> new StrategieT2();
            case COLOCATION -> new StrategieColocation();
        };
    }
}
