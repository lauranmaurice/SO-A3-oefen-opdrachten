package opdrachten.Domain;

import java.util.ArrayList;
import java.util.List;

import opdrachten.Observer.Subject;
import opdrachten.Observer.Subscriber;
import opdrachten.States.CancelledState;
import opdrachten.States.CreatedState;
import opdrachten.States.FinishedState;
import opdrachten.States.PaidState;
import opdrachten.States.ProvisionalState;
import opdrachten.States.State;
import opdrachten.States.SubmittedState;
import opdrachten.Strategies.CalculatePriceStrategy;
import opdrachten.Strategies.ExportJSONStrategy;
import opdrachten.Strategies.ExportPlainTextStrategy;
import opdrachten.Strategies.ExportStrategy;
import opdrachten.Strategies.NotWeekendPriceStrategy;
import opdrachten.Strategies.StudentPriceStrategy;
import opdrachten.Strategies.WeekendPriceStrategy;

public class Order implements Subject{ 
    private List<Subscriber> subscribers;
    private List<MovieTicket> seatReservations;
    private int orderNr;
    private boolean isStudentOrder;
    private CalculatePriceStrategy priceStrategy;
    private String name;
    private String emailAdress;
    private String phoneNumber;


    /* states */
    private State state;
    private State paidState;
    private State provisionalState;
    private State submittedState;
    private State createdState;
    private State canceledState;
    private State finishedState;


    public Order(int orderNr, boolean isStudentOrder, String name, String emailAdress, String phoneNumber) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.name = name;
        this.emailAdress = emailAdress;
        this.phoneNumber = phoneNumber;

        this.seatReservations = new ArrayList<MovieTicket>();
        this.subscribers = new ArrayList<>();

        this.paidState = new PaidState(this);
        this.provisionalState = new ProvisionalState(this);
        this.submittedState = new SubmittedState(this);
        this.createdState = new CreatedState(this);
        this.canceledState = new CancelledState();
        this.finishedState = new FinishedState();

        this.setState(this.createdState);
    }

    public String getName(){
        return this.name;
    }

    public String getContactInformation(){
        if (this.emailAdress != null){
            return this.emailAdress;
        } else {
            return this.phoneNumber;
        } 
    }

    public State getState() {
        return this.state;
    }

    public void setState(State newState) {
        this.state = newState;
    }

    public int getOrderNr() {
        return this.orderNr;
    }

    public boolean getStudentOrder() {
        return this.isStudentOrder;
    }

    public void addSeatReservation(MovieTicket ticket) {
        this.seatReservations.add(ticket);

        if(this.seatReservations.size() == 1) {
            if(this.isStudentOrder) {
                this.priceStrategy = new StudentPriceStrategy();
            } else {
                switch (this.seatReservations.get(0).getDateTime().getDayOfWeek()) {
                    case FRIDAY:
                    case SATURDAY:
                    case SUNDAY:
                        this.priceStrategy = new WeekendPriceStrategy();
                        break;
                    default:
                        this.priceStrategy = new NotWeekendPriceStrategy();
                        break;
                }
            }
        }
    }

    public MovieTicket[] getMovieTickets() {
        var array = new MovieTicket[this.seatReservations.size()];
        this.seatReservations.toArray(array);
        return array;
    }

    public double calculatePrice(){
        return this.priceStrategy.calculate(this.getMovieTickets());
    }

    
    public void export(TicketExportFormat exportFormat){
        ExportStrategy exportStrategy;

        switch (exportFormat) {
            case JSON:
                exportStrategy = new ExportJSONStrategy();
                break;

            case PLAINTEXT:
            default:
                exportStrategy = new ExportPlainTextStrategy();
                break;
        }

        exportStrategy.export(this);
    } 

    public State getCreatedState(){
        return this.createdState;
    }

    public State getCancelledState(){
        return this.canceledState;
    }

    public State getPaidState(){
        return this.paidState;
    }

    public State getProvisionalState(){
        return this.provisionalState;
    }

    public State getFinishedState(){
        return this.finishedState;
    }

    public State getSubmittedState(){
        return this.submittedState;
    }

    public void submit() {
        this.state.submit();
        
    }

    public void addTicket(MovieTicket ticket) {
        this.state.addTicket(ticket);
        
    }

    public void cancel() {
        this.state.cancel();
    }

    public void pay() {
        this.state.pay();
    }

    public void send() {
        this.state.send();
    }

    public void remind() {
        this.state.remind();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String message) {
        for (Subscriber subscriber : this.subscribers) {
            subscriber.update(this, message);
        }
        
    }
}