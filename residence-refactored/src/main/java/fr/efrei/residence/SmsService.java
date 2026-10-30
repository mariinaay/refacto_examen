package fr.efrei.residence;

import java.util.ArrayList;
import java.util.List;

public class SmsService {

    public static final int LONGUEUR_MINIMALE_NUMERO = 10;
    public static final int LONGUEUR_MAXIMALE_SMS = 160;
    public static final String SUFFIXE_TRONCATURE = "...";


    public static int compteurSms = 0;
    public static List<String[]> journal = new ArrayList<String[]>();

    public void envoyerSms(String numero, String message) {
        if (numero == null || numero.length() < LONGUEUR_MINIMALE_NUMERO) {
            System.out.println("[SMS] numéro invalide : " + numero);
            return;
        }
        if (message.length() > LONGUEUR_MAXIMALE_SMS) {
            message = message.substring(0, LONGUEUR_MAXIMALE_SMS - SUFFIXE_TRONCATURE.length()) + SUFFIXE_TRONCATURE;
        }
        compteurSms++;
        journal.add(new String[]{numero, message});
        System.out.println("[SMS] -> " + numero + " : " + message);
    }
}
