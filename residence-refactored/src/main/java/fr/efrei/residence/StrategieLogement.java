package fr.efrei.residence;

public interface StrategieLogement {
    double loyerBase(Logement logement);
    default double charges() { return CalculateurLoyer.CHARGES_INDIVIDUELLES; }
    default double coefficientMenage() { return CalculateurLoyer.COEFFICIENT_MENAGE; }
    default double prixFibre() { return CalculateurLoyer.PRIX_FIBRE; }
    default int normaliserParametre(int param) { return param; }
    default int capacite(Logement logement) { return 1; }
    default int occupation(Logement logement) { return logement.estLibre() ? 0 : 1; }
}
