package opdrachten.Adapter;

public class EmailAdapter implements NotificationSender {
    private EmailMock emailSender;

    public EmailAdapter() {
        this.emailSender = new EmailMock();
    }

	@Override
	public void send(String message) {
		emailSender.sendEmail(message, "henk@mail.ru");
	}
    
}
