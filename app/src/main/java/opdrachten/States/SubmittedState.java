package opdrachten.States;

import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class SubmittedState implements State {

	Order order;
	
	public SubmittedState(Order order){
		this.order = order;
	}

	@Override
	public void submit() {
		System.err.println("[ERR] Cannot sumbit from the submitted state.");
	}

	@Override
	public void addTicket(MovieTicket ticket) {
		this.order.addSeatReservation(ticket);
		System.out.println("Ticket added.");
	}

	@Override
	public void cancel() {
		this.order.setState(this.order.getCancelledState());
		System.out.println("Order is cancelled.");
		
	}

	@Override
	public void pay() {
		this.order.setState(this.order.getPaidState());
		System.out.println("Your order has been paid.");
	}

	@Override
	public void send() {
		System.err.println("[ERR] Cannot send from the paid state.");
		
	}

	@Override
	public void remind() {
		this.order.setState(this.order.getProvisionalState());
		System.out.println("You have been reminded about your order.");
	}
    
}
