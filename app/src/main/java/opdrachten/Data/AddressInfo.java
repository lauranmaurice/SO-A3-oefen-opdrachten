package opdrachten.Data;

public class AddressInfo {
    private String emailOrPhone;


    public AddressInfo(String emailOrPhone) {
        this.setEmailOrPhone(emailOrPhone);
    }


    public String getEmailOrPhone() {
        return emailOrPhone;
    }


    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }
}
