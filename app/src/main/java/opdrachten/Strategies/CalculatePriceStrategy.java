package opdrachten.Strategies;

import opdrachten.Domain.MovieTicket;

public interface CalculatePriceStrategy {
    public double calculate(MovieTicket[] tickets);
}
