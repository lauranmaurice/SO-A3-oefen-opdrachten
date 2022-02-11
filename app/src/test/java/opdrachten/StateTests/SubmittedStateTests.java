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

public class SubmittedStateTests {
    
    private static Order order;

    @BeforeAll
    public static void prepare() {
        order = new Order(1, true);
    }

    @BeforeEach
    public void prepareAll() {
        order.setState(order.getSubmittedState());
    }

    @Test
    public void cantSubmitOrder() {
        order.submit();
        assertEquals(order.getState(), order.getSubmittedState());
    }

    @Test
    public void canAddTicket() {
        var movie = new Movie("Lord of the Rings");
        var screen = new MovieScreening(movie, LocalDateTime.now(), 10.0);
        order.addTicket(new MovieTicket(screen, false, 0, 0));
        assertEquals(order.getState(), order.getSubmittedState());
        assertEquals(1, order.getMovieTickets().length);
    }

    @Test
    public void canCancel() {
        order.cancel();
        assertEquals(order.getState(), order.getCancelledState());
    }

    @Test
    public void canPay() {
        order.pay();
        assertEquals(order.getState(), order.getPaidState());
    }

    @Test
    public void cantSend() {
        order.send();
        assertEquals(order.getState(), order.getSubmittedState());
    }

    @Test
    public void canRemind() {
        order.remind();
        assertEquals(order.getState(), order.getProvisionalState());
    }
}
