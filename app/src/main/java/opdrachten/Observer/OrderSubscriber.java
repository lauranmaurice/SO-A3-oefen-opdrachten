package opdrachten.Observer;

import opdrachten.Adapter.NotificationSender;

public class OrderSubscriber implements Subscriber {
    private NotificationSender sender;

	public OrderSubscriber(NotificationSender sender) {
		this.sender = sender;
	}

	@Override
	public void update(String message) {
		System.out.println(message);
        sender.send(message);
	}
    
}
