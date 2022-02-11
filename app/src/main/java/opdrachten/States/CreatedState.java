package opdrachten.States;

import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class CreatedState implements State {

    Order order;

    public CreatedState(Order order){
        this.order = order;
    }

    @Override
    public void submit() {
        this.order.setState(this.order.getSubmittedState());
        System.out.println("Your order is submitted");
    }

    @Override
    public void addTicket(MovieTicket ticket) {
        this.order.addSeatReservation(ticket);
        System.out.println("Ticket added");
    }

    @Override
    public void cancel() {
        this.order.setState(this.order.getCancelledState());
        System.out.println("This order has been cancelled.");
    }

    @Override
    public void pay() {
        System.err.println("[ERR] ticket must be submitted before being paid");
    }

    @Override
    public void send() {
        System.err.println("[ERR] Cannot send the ticket from the created state.");
        
    }

    @Override
    public void remind() {
        System.err.println("[ERR] Cannot remind from the created state.");
        
    }
    
}
