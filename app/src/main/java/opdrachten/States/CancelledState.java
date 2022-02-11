package opdrachten.States;

import opdrachten.Domain.MovieTicket;

public class CancelledState implements State {

	@Override
	public void submit() {
		System.err.println("[ERR] Can't submit cancelled order");
	}

	@Override
	public void addTicket(MovieTicket ticket) {
		System.err.println("[ERR] Can't modify cancelled order");
	}

	@Override
	public void cancel() {
		System.err.println("[ERR] Order is already cancelled");
	}

	@Override
	public void pay() {
		System.err.println("[ERR] Can't pay cancelled order");
	}

	@Override
	public void send() {
		System.err.println("[ERR] Can't send order in cancelled state");
	}

	@Override
	public void remind() {
		System.err.println("[ERR] Can't send reminder if order is cancelled");
	}
    
}
