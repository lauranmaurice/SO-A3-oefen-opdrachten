package opdrachten.StateTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import opdrachten.Domain.MovieTicket;
import opdrachten.Domain.Order;

public class CancelledStateTests {

    private static Order order;

    @BeforeAll
    public static void prepare() {
        order = new Order(1, true, null, null, null);
    }

    @BeforeEach
    public void prepareAll() {
        order.setState(order.getCancelledState());
    }

    @Test
    public void cantSubmitOrder() {
        order.submit();
        assertEquals(order.getState(), order.getCancelledState()); //should succeed
    }

    @Test
    public void cantAddTicket() {
        order.addTicket(new MovieTicket(null, false, 0, 0));
        assertEquals(order.getState(), order.getCancelledState());
        assertEquals(0, order.getMovieTickets().length);
    }

    @Test
    public void cantCancel() {
        order.cancel();
        assertEquals(order.getState(), order.getCancelledState()); //seems strange to me
    }

    @Test
    public void cantPay() {
        order.pay();
        assertEquals(order.getState(), order.getCancelledState());
    }

    @Test
    public void cantSend() {
        order.send();
        assertEquals(order.getState(), order.getCancelledState());
    }

    @Test
    public void cantRemind() {
        order.remind();
        assertEquals(order.getState(), order.getCancelledState());
    }
}