package opdrachten.Observer;

public interface Subject {
    public void subscribe(Subscriber subscriber);
    public void unsubscribe(Subscriber subscriber);
    public void notifySubscribers(String message);
}
