package opdrachten.Adapter;

public class WhatsappMock {
    public void sendWhatsapp(String text, String phone) {
        System.out.println("Sent WA to "+phone+": "+text);
    }
}
