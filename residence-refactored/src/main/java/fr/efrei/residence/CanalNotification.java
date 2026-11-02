package fr.efrei.residence;

public interface CanalNotification {
    void notifier(Etudiant etudiant, String sujet, String message);

    void relancer(Bail bail);
}
