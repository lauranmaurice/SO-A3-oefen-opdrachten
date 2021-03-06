/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package opdrachten;

import java.time.LocalDateTime;

import opdrachten.Adapter.SmsAdapter;
import opdrachten.Adapter.SmsMock;
import opdrachten.Cinema.Chair;
import opdrachten.Cinema.CinemaCollection;
import opdrachten.Cinema.CinemaComponent;
import opdrachten.Domain.Movie;
import opdrachten.Domain.MovieScreening;
import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;
import opdrachten.Observer.OrderSubscriber;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void hello() {
        CinemaComponent peanuts = new CinemaCollection("PEANUTS");

        var breda = new CinemaCollection("Breda");
        
        var zaal1 = new CinemaCollection("Zaal 1");
        
        var group1 = new CinemaCollection("Group 1");

        var rowA = new CinemaCollection("A");
        rowA.add(new Chair(1));
        rowA.add(new Chair(2));
        rowA.add(new Chair(3));

        var rowB = new CinemaCollection("B");
        rowB.add(new Chair(1));
        rowB.add(new Chair(2));
        rowB.add(new Chair(3));
        rowB.add(new Chair(4));
        
        group1.add(rowA);
        group1.add(rowB);
        
        zaal1.add(group1);
        
        var zaal2 = new CinemaCollection("Zaal 2");
        zaal2.add(new Chair(1));
        zaal2.add(new Chair(2));
        zaal2.add(new Chair(3));
        zaal2.add(new Chair(4));
        zaal2.add(new Chair(5));

        breda.add(zaal1);
        breda.add(zaal2);

        var tilburg = new CinemaCollection("Tilburg");

        var zaal1b = new CinemaCollection("Zaal 1");
        zaal1b.add(new Chair(1));
        zaal1b.add(new Chair(2));
        zaal1b.add(new Chair(3));
        zaal1b.add(new Chair(4));
        
        var zaal2b = new CinemaCollection("Zaal 2");
        zaal2b.add(new Chair(1));
        zaal2b.add(new Chair(2));
        zaal2b.add(new Chair(3));

        tilburg.add(zaal1b);
        tilburg.add(zaal2b);

        //------
        peanuts.add(breda);
        peanuts.add(tilburg);

        var description = peanuts.getLocation();
        System.out.println(description);

        /*Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 20.00);
        MovieTicket ticketMaurice = new MovieTicket(movieScreening, true, 4, 12);
        MovieTicket ticketLauran = new MovieTicket(movieScreening, true, 4, 13);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, true, 4, 14);

        Order order = new Order(1, true,null, null, null);

        order.addSeatReservation(ticketMaurice);
        order.addSeatReservation(ticketLauran);
        order.addSeatReservation(ticketRamon);

        SmsMock smsMock = new SmsMock();
        SmsAdapter smsAdapter = new SmsAdapter(smsMock, "+31 6 81139297"); 

        OrderSubscriber orderSubscriber = new OrderSubscriber(smsAdapter);
        order.subscribe(orderSubscriber);
        order.submit();*/
        

    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        hello();
    }
}
