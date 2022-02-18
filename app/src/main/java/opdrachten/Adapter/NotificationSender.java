package opdrachten.Adapter;

import java.time.LocalDateTime;

import opdrachten.Data.AddressInfo;
import opdrachten.Data.UserInfo;
import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public abstract class NotificationSender {
    public final void sendMessage(Order order, String message){
        var buildedMessage = new StringBuilder();
        buildedMessage.append(message);

        // get order information
        UserInfo info = getInfo(order);

        // get address information
        AddressInfo addressInfo = getAdressinfo(info);
        
        // set address information
        buildedMessage.append(setAdressInfo(addressInfo));
        
        // add body
        buildedMessage.append(createText(info));
    
        // if paid state, add attachement
        if (order.getState() == order.getPaidState()) {
            buildedMessage.append(createAttachement());
        }

        // send meimport java.util.ArrayList;
        send(buildedMessage.toString());
    }

    public final UserInfo getInfo(Order order)
    {
        String emailOrPhone = order.getContactInformation();
        String name = order.getName();

        int orderNr = order.getOrderNr();
        MovieTicket[] tickets = order.getMovieTickets();
        LocalDateTime timeMovie = tickets[0].getDateTime();
        String movieName = tickets[0].getMovieName(); 

        return new UserInfo(orderNr, tickets, timeMovie, movieName, emailOrPhone, name);
    }

    public AddressInfo getAdressinfo(UserInfo info) {
        return new AddressInfo(info.getEmailOrPhone());
    }

    private String setAdressInfo(AddressInfo info) {
        return info.getEmailOrPhone();
    }

    protected String createText(UserInfo info) {
        var sb = new StringBuilder();
        sb.append("Naam: "+info.getName()+"\n");
        sb.append("Film: "+info.getMovieName()+"\n");
        sb.append("Ordernummer: "+info.getOrderNr()+"\n");
        sb.append("Datum en tijd: "+info.getTimeMovie().toString()+"\n");
        return sb.toString();
    }

    // hook
    protected String createAttachement(){
        return "";
    }
    
    abstract void send(String message);
}