package opdrachten.States;

import opdrachten.Domain.MovieTicket;

public class FinishedState implements State {

	@Override
	public void submit() {
		System.err.println("[ERR] We are finished, go home.");
	}

	@Override
	public void addTicket(MovieTicket ticket) {
		System.err.println("[ERR] We are finished, go home.");
		
	}

	@Override
	public void cancel() {
		System.err.println("[ERR] We are finished, go home.");
		
	}

	@Override
	public void pay() {
		System.err.println("[ERR] We are finished, go home.");
		
	}

	@Override
	public void send() {
		System.err.println("[ERR] We are finished, go home.");
		
	}

	@Override
	public void remind() {
		System.err.println("[ERR] We are finished, go home.");
		
	}
    
}
