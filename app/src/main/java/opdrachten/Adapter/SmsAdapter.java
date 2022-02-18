package opdrachten.Adapter;

public class SmsAdapter extends NotificationSender{
    private SmsMock smsSender; 
    private String phoneNumber;

    public SmsAdapter(SmsMock smsSender, String phoneNumber){
        this.smsSender = smsSender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        this.smsSender.sendSMS(message, phoneNumber);
        
    }

}   
