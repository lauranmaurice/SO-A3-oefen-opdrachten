package opdrachten.Adapter;

public class EmailMock {
    public void sendEmail(String text, String emailAdress){
        System.out.println("Hallo " + emailAdress + "Hier is een bericht" + text);
    }
}
