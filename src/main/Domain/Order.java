package Domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Order {
    private List<MovieTicket> seatReservations;
    private int orderNr;
    private boolean isStudentOrder;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;
        this.seatReservations = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return this.orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        this.seatReservations.add(ticket);
    }

    public double calculatePrice(){
        var dateAndTime = this.seatReservations.get(0).getDateTime();

        var day =  dateAndTime.getDayOfWeek();
        var isWeekend = (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
        var totalPrice = 0; //cents

        if (this.isStudentOrder || !isWeekend ) {
            for(var i = 0; i < this.seatReservations.size(); i++) {
                if (i % 2 == 0) {
                    var t = this.seatReservations.get(i);
                    var extra = t.isPremiumTicket() ? (this.isStudentOrder ? 2 : 3) : 0;
                    totalPrice += Math.round((t.getPrice() + extra) * 100);
                }
            }
        } else {
            for (var t : this.seatReservations) {
                var extra = t.isPremiumTicket() ? 3 : 0;
                totalPrice += Math.round((t.getPrice() + extra) * 100);
            }

            if (this.seatReservations.size() >= 6) {
                totalPrice *= 0.9;
            }
        }

        return (double)totalPrice / 100;
    }

    
    public void export(TicketExportFormat exportFormat){
        switch (exportFormat){
            case JSON: {
                var sb = new StringBuilder();
                sb.append("{");
                sb.append("\"order\":{");
                sb.append("\"nummer\":"+this.orderNr+",");
                sb.append("\"datum\":\""+LocalDateTime.now()+"\",");
                sb.append("\"student\":"+(this.isStudentOrder ? "true" : "false")+",");
                sb.append("\"aantalTickets\":"+this.seatReservations.size()+",");
                sb.append("\"prijs\":"+this.calculatePrice());
                sb.append("},");

                sb.append("\"tickets\":[");
                for (var t : this.seatReservations) {
                    sb.append("{");
                    sb.append("\"premium\":"+(t.isPremiumTicket() ? "true" : "false")+",");
                    sb.append("\"film\":\""+t.getMovieName()+"\",");
                    sb.append("\"stoel\":"+t.getRow()+",");
                    sb.append("\"rij\":"+t.getSeat());
                    sb.append("},");
                }
                sb.append("]");
                sb.append("}");
                System.out.println(sb.toString());
                break;
            }
            case PLAINTEXT: {
                var stringBuilder = new StringBuilder();
                stringBuilder.append(
                    "============= Order ============ \n" +
                    "Order nummer: " + orderNr + "\n" +
                    "Datum: " + LocalDateTime.now() + "\n" + 
                    "Student: " + isStudentOrder + "\n" +
                    "Aantal Tickets: " + seatReservations.size() + "\n" +
                    "Prijs: $" + this.calculatePrice() + "\n" +
                    "============ Tickets ===========" + "\n"
                );

                for (MovieTicket movieTicket : seatReservations) {
                    stringBuilder.append(movieTicket.toString() + "\n");
                }

                stringBuilder.append("================================");
                
                System.out.println(stringBuilder.toString());
                break;
            }
        }

    } 
}