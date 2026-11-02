package fr.efrei.residence;

public class NotificationFactory {
    public CanalNotification creer(Canal canal) {
        return switch (canal) {
            case EMAIL -> new EmailService();
            case SMS -> new SmsService();
            case COURRIER -> new CourrierService();
        };
    }
}
