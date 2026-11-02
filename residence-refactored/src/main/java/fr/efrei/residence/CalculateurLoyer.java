package fr.efrei.residence;

import java.util.Set;

public class CalculateurLoyer {

    public static final double TARIF_M2_STUDIO = 14;
    public static final double LOYER_MINIMUM_STUDIO = 350;
    public static final double TARIF_M2_T1 = 13;
    public static final double FORFAIT_T1 = 50;
    public static final double TARIF_M2_T2 = 12;
    public static final double FORFAIT_T2 = 100;
    public static final double TARIF_M2_COLOCATION = 11;
    public static final double COEFFICIENT_MEUBLE = 1.15;
    public static final double COEFFICIENT_REZ_DE_CHAUSSEE = 0.95;
    public static final double COEFFICIENT_MENAGE_COLOCATION = 1.04;
    public static final double COEFFICIENT_MENAGE = 1.08;
    public static final double PRIX_PARKING = 45;
    public static final double PRIX_LAVERIE = 12;
    public static final double PRIX_FIBRE = 20;
    public static final double PRIX_ASSURANCE = 9;
    public static final double CHARGES_COLOCATION = 25;
    public static final double CHARGES_INDIVIDUELLES = 35;


    /**
     * Loyer mensuel hors charges, options comprises, remise déduite.
     */
    public double calculerLoyer(Logement l, Profil profil, int echelon, Set<Option> options) {
        StrategieLogement strategie = StrategiesLogement.choisir(l.getType());
        double loyer = strategie.loyerBase(l);

        if (l.isMeuble()) loyer = loyer * COEFFICIENT_MEUBLE;
        if (l.getEtage() == Logement.REZ_DE_CHAUSSEE) loyer = loyer * COEFFICIENT_REZ_DE_CHAUSSEE;

        // options
        if (options.contains(Option.MENAGE)) {
            loyer = loyer * strategie.coefficientMenage();
        }
        if (options.contains(Option.PARKING)) loyer = loyer + PRIX_PARKING;
        if (options.contains(Option.LAVERIE)) loyer = loyer + PRIX_LAVERIE;
        if (options.contains(Option.FIBRE)) loyer = loyer + strategie.prixFibre();
        if (options.contains(Option.ASSURANCE)) loyer = loyer + PRIX_ASSURANCE;

        loyer = StrategiesProfil.choisir(profil).appliquerRemise(loyer, echelon);

        return Utils.arrondir(loyer);
    }

    public double calculerCharges(Logement l) {
        return StrategiesLogement.choisir(l.getType()).charges();
    }
}
