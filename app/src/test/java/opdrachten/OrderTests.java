package opdrachten;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import opdrachten.Domain.Movie;
import opdrachten.Domain.MovieScreening;
import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class OrderTests {
    /**
        NIET WEEKEND
     */
    @Test
    public void testOne(){
        var student = false;
        var premium = false;
        var date = LocalDateTime.parse("2022-02-02T22:02:02"); //not in weekend

        Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, date, 20.00);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketRuud);

        assertEquals(20.00, order.calculatePrice());
    }

    @Test
    public void testTwo(){
        var student = false;
        var premium = true;
        var date = LocalDateTime.parse("2022-02-02T22:02:02"); //not in weekend

        Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, date, 20.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);

        assertEquals(23.00, order.calculatePrice());
    }

    @Test
    public void testThree(){
        var student = false;
        var premium = false;
        var date = LocalDateTime.parse("2022-02-02T22:02:02"); //not in weekend

        Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, date, 20.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);
        order.addSeatReservation(ticketRuud);

        assertEquals(20, order.calculatePrice());
    }

    @Test
    public void testFour(){
        var student = false;
        var premium = true;
        var date = LocalDateTime.parse("2022-02-02T22:02:02"); //not in weekend

        Movie movie = new Movie("Lord of the Rings");
        MovieScreening movieScreening = new MovieScreening(movie, date, 20.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);
        
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);
        order.addSeatReservation(ticketRuud);

        assertEquals(23, order.calculatePrice());
    }

    /**
       Wel weekend
     */

    @Test
    public void testFive(){
        var student = false;
        var premium = false;
        var date = LocalDateTime.parse("2022-02-03T22:02:02"); //In weekend

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, date, 10.00);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketRuud);

        assertEquals(10.00, order.calculatePrice());
    }

    @Test
    public void testSix(){
        var student = false;
        var premium = true;
        var date = LocalDateTime.parse("2022-02-04T22:02:02"); //In weekend

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, date, 10.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);

        assertEquals(13.00, order.calculatePrice());
    }

    @Test
    public void testSeven(){
        var student = false;
        var premium = false;
        var date = LocalDateTime.parse("2022-02-05T22:02:02"); //In weekend

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, date, 10.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketArno = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMarjolein = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketAlexander = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketPascal = new MovieTicket(movieScreening, premium, 4, 12);
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);
        order.addSeatReservation(ticketRuud);
        order.addSeatReservation(ticketArno);
        order.addSeatReservation(ticketMarjolein);
        order.addSeatReservation(ticketAlexander);
        order.addSeatReservation(ticketPascal);

        assertEquals(60 * 0.9, order.calculatePrice());
    }

    @Test
    public void testEight(){
        var student = false;
        var premium = true;
        var date = LocalDateTime.parse("2022-02-05T22:02:02"); //In weekend

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, date, 10.00);
        MovieTicket ticketDion = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketRuud = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketArno = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMarjolein = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketAlexander = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketPascal = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketRik = new MovieTicket(movieScreening, premium, 4, 12);
        
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketDion);
        order.addSeatReservation(ticketRuud);
        order.addSeatReservation(ticketArno);
        order.addSeatReservation(ticketMarjolein);
        order.addSeatReservation(ticketAlexander);
        order.addSeatReservation(ticketPascal);
        order.addSeatReservation(ticketRik);
        

        assertEquals(91 * 0.9, order.calculatePrice());
    }

    /**
       Student
     */

    @Test
    public void testNine(){
        var student = true;
        var premium = false;

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 2.00);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketRamon);

        assertEquals(2.00, order.calculatePrice());
    }

    @Test
    public void testTen(){
        var student = true;
        var premium = true;

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 2.00);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, premium, 4, 12);

        var order = new Order(1, student);
        order.addSeatReservation(ticketRamon);

        assertEquals(4.00, order.calculatePrice());
    }

    @Test
    public void testEleven(){
        var student = true;
        var premium = false;

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 2.00);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketLauran = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketAart = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMaurice = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketJulius = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMartijn = new MovieTicket(movieScreening, premium, 4, 12);
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketRamon);
        order.addSeatReservation(ticketLauran);
        order.addSeatReservation(ticketAart);
        order.addSeatReservation(ticketMaurice);
        order.addSeatReservation(ticketJulius);
        order.addSeatReservation(ticketMartijn);

        assertEquals(6, order.calculatePrice());
    }

    @Test
    public void testTwelve(){
        var student = true;
        var premium = true;

        Movie movie = new Movie("The Hobbit");
        MovieScreening movieScreening = new MovieScreening(movie, LocalDateTime.now(), 2.00);
        MovieTicket ticketRamon = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketLauran = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketAart = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMaurice = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketJulius = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketMartijn = new MovieTicket(movieScreening, premium, 4, 12);
        MovieTicket ticketNiels = new MovieTicket(movieScreening, premium, 4, 12);
        
        var order = new Order(1, student);
        order.addSeatReservation(ticketRamon);
        order.addSeatReservation(ticketLauran);
        order.addSeatReservation(ticketAart);
        order.addSeatReservation(ticketMaurice);
        order.addSeatReservation(ticketJulius);
        order.addSeatReservation(ticketMartijn);
        order.addSeatReservation(ticketNiels);

        assertEquals(16, order.calculatePrice());
    }
    
    @Test
    public void nutteloos(){
        assertEquals(1, 1);
    }

}
