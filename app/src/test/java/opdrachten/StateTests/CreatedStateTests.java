package opdrachten.StateTests;

import org.junit.jupiter.api.Test;

import opdrachten.Domain.Movie;
import opdrachten.Domain.MovieScreening;
import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class CreatedStateTests {
    
    private static Order order;
    private static Movie movie;
    private static MovieScreening movieScreening;
    private static MovieTicket ticket;

    @BeforeAll
    public static void prepare() {
        order = new Order(1, true);
        movie = new Movie("Dragonheart.");
        movieScreening = new MovieScreening(movie, LocalDateTime.now(), 1.00);
        ticket = new MovieTicket(movieScreening, false, 1, 1);
    }

    @BeforeEach
    public void prepareAll() {
        order.setState(order.getCreatedState());
    }

    @Test
    public void testCreatedStateSubmit(){
        order.submit();
        assertEquals(order.getState(), order.getSubmittedState());
    }

    @Test
    public void testCreatedStateAddTicket(){
        order.addTicket(ticket);
        assertEquals(order.getState(), order.getCreatedState());
    }

    @Test
    public void testCreatedStateCancel(){
        order.cancel();
        assertEquals(order.getState(), order.getCancelledState());
    }

    @Test
    public void testCreatedStatePay(){
        order.pay();
        assertEquals(order.getState(), order.getCreatedState());
    }

    @Test
    public void testCreatedStateSend(){
        order.send();
        assertEquals(order.getState(), order.getCreatedState());
    }

    @Test
    public void testCreatedStateRemind(){
        order.remind();
        assertEquals(order.getState(), order.getCreatedState());
    }

}
