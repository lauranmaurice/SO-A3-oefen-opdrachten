package opdrachten.Adapter;

public class EmailAdapter extends NotificationSender {
    private EmailMock emailSender;

    public EmailAdapter() {
        this.emailSender = new EmailMock();
    }

	@Override
	public void send(String message) {
		emailSender.sendEmail(message, "henk@mail.ru");
	}

    @Override
    protected String createAttachement() {
        return "ATTACHEMENT_VERY_SAFE_FILE.pdf.exe";
    }
    
}
