import java.time.LocalDateTime;

import Domain.Movie;
import Domain.MovieScreening;
import Domain.MovieTicket;
import Domain.Order;
import Domain.TicketExportFormat;

public class Hello {

    public static void main(String[] args){
        Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 20.00);
        MovieTicket ticketMaurice = new MovieTicket(movieScreening, true, 4, 12);
        MovieTicket ticketLauran = new MovieTicket(movieScreening, true, 4, 13);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, true, 4, 14);

        Order order = new Order(1, true);

        order.addSeatReservation(ticketMaurice);
        order.addSeatReservation(ticketLauran);
        order.addSeatReservation(ticketRamon);

        order.export(TicketExportFormat.JSON);
        order.export(TicketExportFormat.PLAINTEXT);

    }
}