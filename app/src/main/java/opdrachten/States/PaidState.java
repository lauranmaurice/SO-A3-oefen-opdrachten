package opdrachten.States;

import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class PaidState implements State {

	Order order;

	public PaidState(Order order){
		this.order = order;
	}

	@Override
	public void submit() {
		System.err.println("[ERR] This order is already submitted");
	}

	@Override
	public void addTicket(MovieTicket ticket) {
		System.err.println("[ERR] This order is already submitted, can't be changed");
	}

	@Override
	public void cancel() {
		System.err.println("[ERR] This order is already paid, can't be cancelled");
	}

	@Override
	public void pay() {
		System.err.println("[ERR] This order is already paid. Oh but we ofcourse appreciate donations");
	}

	@Override
	public void send() {
		this.order.setState(this.order.getFinishedState());
		System.out.println("Here is your order \n" + this.order.toString());
	}

	@Override
	public void remind() {
		System.err.println("[ERR] Payment reminder can't be sent in paid state");
	}
    
}
