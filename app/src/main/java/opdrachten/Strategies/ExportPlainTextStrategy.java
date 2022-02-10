package opdrachten.Strategies;

import opdrachten.Domain.Order;

public class ExportPlainTextStrategy implements ExportStrategy {

    @Override
    public void export(Order order) {
        var tickets = order.getMovieTickets();
        var stringBuilder = new StringBuilder();
        stringBuilder.append(
                "============= Order ============ \n" +
                "Order nummer: " + order.getOrderNr() + "\n" +
                "Student: " + order.getStudentOrder() + "\n" +
                "Aantal Tickets: " + tickets.length + "\n" +
                "Prijs: $" + order.calculatePrice() + "\n" +
                "============ Tickets ===========" + "\n");

        for (var movieTicket : tickets) {
            stringBuilder.append(movieTicket.toString() + "\n");
        }

        stringBuilder.append("================================");

        System.out.println(stringBuilder.toString());
    }

}