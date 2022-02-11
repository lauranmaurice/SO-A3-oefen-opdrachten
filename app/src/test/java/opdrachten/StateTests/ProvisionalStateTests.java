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

public class ProvisionalStateTests {
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
        order.setState(order.getProvisionalState());
    }

    @Test
    public void testProvisionalStateSubmit(){
        order.submit();
        assertEquals(order.getState(), order.getProvisionalState());;
    }

    @Test
    public void testProvisionalStateAddTicket(){
        order.addTicket(ticket);
        assertEquals(order.getState(), order.getProvisionalState());
    }

    @Test
    public void testProvisionalStateCancel(){
        order.cancel();
        assertEquals(order.getState(), order.getCancelledState());
    }

    @Test
    public void testProvisionalStatePay(){
        order.pay();
        assertEquals(order.getState(), order.getPaidState());
    }

    @Test
    public void testProvisionalStateSend(){
        order.send();
        assertEquals(order.getState(), order.getProvisionalState());
    }

    @Test
    public void testProvisionalStateRemind(){
        order.remind();
        assertEquals(order.getState(), order.getProvisionalState());
    }
}
