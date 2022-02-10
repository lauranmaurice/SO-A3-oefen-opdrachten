package opdrachten.Strategies;

import opdrachten.Domain.MovieTicket;

public class StudentPriceStrategy implements CalculatePriceStrategy {

    @Override
	public double calculate(MovieTicket[] tickets) {
        var totalPrice = 0; //cents
		
		for(var i = 0; i < tickets.length; i++) {
			if (i % 2 == 0) {
				var t = tickets[i];
				var extra = t.isPremiumTicket() ? 2 : 0;
				totalPrice += Math.round((t.getPrice() + extra) * 100);
			}
		}

		return (double)totalPrice / 100;
	}

}