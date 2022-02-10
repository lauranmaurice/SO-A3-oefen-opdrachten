package opdrachten.Strategies;

import opdrachten.Domain.MovieTicket;

public class WeekendPriceStrategy implements CalculatePriceStrategy {

    @Override
    public double calculate(MovieTicket[] tickets) {
        var totalPrice = 0;

        for (var t : tickets) {
            var extra = t.isPremiumTicket() ? 3 : 0;
            totalPrice += Math.round((t.getPrice() + extra) * 100);
        }

        if (tickets.length >= 6) {
            totalPrice *= 0.9;
        }

        return (double)totalPrice / 100;
    }

}