package opdrachten.Adapter;

public class WhatsappAdapter implements NotificationSender {
    private WhatsappMock whatsapp;

	public WhatsappAdapter() {
		this.whatsapp = new WhatsappMock();
	}

	@Override
	public void send(String message) {
		whatsapp.sendWhatsapp(message, "06-12345678");
	}
    
}
