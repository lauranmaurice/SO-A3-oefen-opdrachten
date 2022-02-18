package opdrachten.Observer;

import opdrachten.Adapter.NotificationSender;
import opdrachten.Domain.Order;

public class OrderSubscriber implements Subscriber {
    private NotificationSender sender;

	public OrderSubscriber(NotificationSender sender) {
		this.sender = sender;
	}

	@Override
	public void update(Order order, String message) {
        sender.sendMessage(order, message);
	}
    
}
