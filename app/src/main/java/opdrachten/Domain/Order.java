package opdrachten.Domain;

import java.util.ArrayList;
import java.util.List;

import opdrachten.Strategies.CalculatePriceStrategy;
import opdrachten.Strategies.ExportJSONStrategy;
import opdrachten.Strategies.ExportPlainTextStrategy;
import opdrachten.Strategies.ExportStrategy;
import opdrachten.Strategies.NotWeekendPriceStrategy;
import opdrachten.Strategies.StudentPriceStrategy;
import opdrachten.Strategies.WeekendPriceStrategy;

public class Order {
    private List<MovieTicket> seatReservations;
    private int orderNr;
    private boolean isStudentOrder;
    private CalculatePriceStrategy priceStrategy;


    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.seatReservations = new ArrayList<MovieTicket>();
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
}