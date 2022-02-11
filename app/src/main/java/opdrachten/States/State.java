package opdrachten.States;

import opdrachten.Domain.MovieTicket;

public interface State {
    public void submit();
    public void addTicket(MovieTicket ticket);
    public void cancel();
    public void pay();
    public void send();
    public void remind();
}
