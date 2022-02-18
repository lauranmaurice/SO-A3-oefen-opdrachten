package opdrachten.Adapter;

public class SmsMock {

	public void sendSMS(String message, String phone) {
		System.out.println("[SMS] Sent message "+message+" (-20 cent) to "+phone);
	}
    
}
