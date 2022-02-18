package opdrachten.Observer;

import opdrachten.Domain.Order;

public interface Subscriber {
    public void update(Order order, String message);
}
