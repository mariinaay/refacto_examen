package fr.efrei.residence;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

public class AssembleurLoyer {
    private record CoucheOption(Option option,
            BiFunction<Loyer, StrategieLogement, Loyer> decorer) { }

    // L'ordre de cette liste fixe l'ordre d'application des options.
    private static final List<CoucheOption> COUCHES_OPTIONS = List.of(
            new CoucheOption(Option.MENAGE, LoyerMenage::new),
            new CoucheOption(Option.PARKING, (loyer, strategie) -> new LoyerParking(loyer)),
            new CoucheOption(Option.LAVERIE, (loyer, strategie) -> new LoyerLaverie(loyer)),
            new CoucheOption(Option.FIBRE, LoyerFibre::new),
            new CoucheOption(Option.ASSURANCE, (loyer, strategie) -> new LoyerAssurance(loyer)));

    public Loyer assembler(Logement logement, Set<Option> options) {
        StrategieLogement strategie = StrategiesLogement.choisir(logement.getType());
        Loyer loyer = new LoyerBase(strategie.loyerBase(logement));
        if (logement.isMeuble()) {
            loyer = new LoyerMeuble(loyer);
        }
        if (logement.getEtage() == Logement.REZ_DE_CHAUSSEE) {
            loyer = new LoyerRezDeChaussee(loyer);
        }
        for (CoucheOption couche : COUCHES_OPTIONS) {
            if (options.contains(couche.option())) {
                loyer = couche.decorer().apply(loyer, strategie);
            }
        }
        return loyer;
    }
}
