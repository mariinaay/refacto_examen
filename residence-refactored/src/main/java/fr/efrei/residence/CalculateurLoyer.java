package fr.efrei.residence;

import java.util.Set;

public class CalculateurLoyer {

    private final AssembleurLoyer assembleur = new AssembleurLoyer();

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
        Loyer loyer = assembleur.assembler(l, options);
        double montant = StrategiesProfil.choisir(profil).appliquerRemise(loyer.montant(), echelon);
        return Utils.arrondir(montant);
    }

    public double calculerCharges(Logement l) {
        return StrategiesLogement.choisir(l.getType()).charges();
    }
}
