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

public class PaidStateTests {
    
    private static Order order;

    @BeforeAll
    public static void prepare() {
        order = new Order(1, true,null, null, null);
    }

    @BeforeEach
    public void prepareAll() {
        order.setState(order.getPaidState());
    }

    @Test
    public void cantSubmitOrder() {
        order.submit();
        assertEquals(order.getState(), order.getPaidState());
    }

    @Test
    public void cantAddTicket() {
        var movie = new Movie("Lord of the Rings");
        var screen = new MovieScreening(movie, LocalDateTime.now(), 10.0);
        order.addTicket(new MovieTicket(screen, false, 0, 0));
        assertEquals(order.getState(), order.getPaidState());
        assertEquals(0, order.getMovieTickets().length);
    }

    @Test
    public void cantCancel() {
        order.cancel();
        assertEquals(order.getState(), order.getPaidState());
    }

    @Test
    public void cantPay() {
        order.pay();
        assertEquals(order.getState(), order.getPaidState());
    }

    @Test
    public void canSend() {
        order.send();
        assertEquals(order.getState(), order.getFinishedState());
    }

    @Test
    public void cantRemind() {
        order.remind();
        assertEquals(order.getState(), order.getPaidState());
    }
}
