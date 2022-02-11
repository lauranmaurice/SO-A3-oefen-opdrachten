package opdrachten.States;

import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class ProvisionalState implements State {

	Order order;

	public ProvisionalState(Order order){
		this.order = order;
	}

	@Override
	public void submit() {
		System.err.println("[ERR] Can't submit order in provisional state");
	}

	@Override
	public void addTicket(MovieTicket ticket) {
		System.err.println("[ERR] Can't add a ticket from the provisional state.");
	}

	@Override
	public void cancel() {
		this.order.setState(this.order.getCancelledState());
		System.out.println("Your order has been cancelled.");
	}

	@Override
	public void pay() {
		this.order.setState(this.order.getPaidState());
		System.out.println("Your order has been paid.");
	}

	@Override
	public void send() {
		System.err.println("[ERR] Can't send order before it is paid");
	}

	@Override
	public void remind() {
		System.err.println("[ERR] Reminder is already sent");
	}
    
}
