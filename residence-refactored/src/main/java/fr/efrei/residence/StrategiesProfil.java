package fr.efrei.residence;

public final class StrategiesProfil {
    private StrategiesProfil() { }

    public static StrategieProfil choisir(Profil profil) {
        return switch (profil) {
            case STANDARD -> new StrategieStandard();
            case BOURSIER -> new StrategieBoursier();
            case ALTERNANT -> new StrategieAlternant();
            case INTERNATIONAL -> new StrategieInternational();
        };
    }
}
