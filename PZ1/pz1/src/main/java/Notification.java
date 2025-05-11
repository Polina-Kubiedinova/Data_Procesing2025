public class Notification {
    public void send() {
        System.out.println("Відправлення загального повідомлення...");
    }
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        email.send(); // Виведе: Відправлено email-повідомлення.
        sms.send();   // Виведе: Відправлено SMS-повідомлення.
    }
}
