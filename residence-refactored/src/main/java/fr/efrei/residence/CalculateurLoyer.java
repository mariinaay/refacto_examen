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
    public static final double REMISE_PAR_ECHELON = 0.05;
    public static final double REMISE_BOURSIER_MAXIMALE = 0.30;
    public static final double COEFFICIENT_ALTERNANT = 0.90;
    public static final double CHARGES_COLOCATION = 25;
    public static final double CHARGES_INDIVIDUELLES = 35;


    /**
     * Loyer mensuel hors charges, options comprises, remise déduite.
     */
    public double calculerLoyer(Logement l, Profil profil, int echelon, Set<Option> options) {
        // loyer de base selon le type
        double loyer;
        if (l.getType() == TypeLogement.STUDIO) {
            loyer = l.getSurface() * TARIF_M2_STUDIO;
            if (loyer < LOYER_MINIMUM_STUDIO) loyer = LOYER_MINIMUM_STUDIO;
        } else if (l.getType() == TypeLogement.T1) {
            loyer = l.getSurface() * TARIF_M2_T1 + FORFAIT_T1;
        } else if (l.getType() == TypeLogement.T2) {
            loyer = l.getSurface() * TARIF_M2_T2 + FORFAIT_T2;
        } else if (l.getType() == TypeLogement.COLOCATION) {
            loyer = l.getSurface() * TARIF_M2_COLOCATION / l.getNombrePlaces();
        } else {
            throw new IllegalArgumentException("Type de logement inconnu : " + l.getType());
        }

        if (l.isMeuble()) loyer = loyer * COEFFICIENT_MEUBLE;
        if (l.getEtage() == Logement.REZ_DE_CHAUSSEE) loyer = loyer * COEFFICIENT_REZ_DE_CHAUSSEE;

        // options
        if (options.contains(Option.MENAGE)) {
            if (l.getType() == TypeLogement.COLOCATION) {
                loyer = loyer * COEFFICIENT_MENAGE_COLOCATION; // parties communes déjà nettoyées
            } else {
                loyer = loyer * COEFFICIENT_MENAGE;
            }
        }
        if (options.contains(Option.PARKING)) loyer = loyer + PRIX_PARKING;
        if (options.contains(Option.LAVERIE)) loyer = loyer + PRIX_LAVERIE;
        if (options.contains(Option.FIBRE) && l.getType() != TypeLogement.COLOCATION) loyer = loyer + PRIX_FIBRE; // fibre incluse en coloc
        if (options.contains(Option.ASSURANCE)) loyer = loyer + PRIX_ASSURANCE;

        // remise selon le profil
        if (profil == Profil.BOURSIER) {
            double taux = echelon * REMISE_PAR_ECHELON;
            if (taux > REMISE_BOURSIER_MAXIMALE) taux = REMISE_BOURSIER_MAXIMALE;
            loyer = loyer * (1 - taux);
        } else if (profil == Profil.ALTERNANT) {
            loyer = loyer * COEFFICIENT_ALTERNANT;
        }

        return Utils.arrondir(loyer);
    }

    public double calculerCharges(Logement l) {
        if (l.getType() == TypeLogement.COLOCATION) return CHARGES_COLOCATION;
        return CHARGES_INDIVIDUELLES;
    }
}
