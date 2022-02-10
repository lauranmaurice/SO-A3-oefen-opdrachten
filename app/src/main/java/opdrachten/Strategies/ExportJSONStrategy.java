package opdrachten.Strategies;

import opdrachten.Domain.Order;

public class ExportJSONStrategy implements ExportStrategy {

    @Override
    public void export(Order order) {
        var tickets = order.getMovieTickets();
        var sb = new StringBuilder();
        sb.append("{");
        sb.append("\"order\":{");
        sb.append("\"nummer\":" + order.getOrderNr() + ",");
        sb.append("\"student\":" + (order.getStudentOrder() ? "true" : "false") + ",");
        sb.append("\"aantalTickets\":" + tickets.length + ",");
        sb.append("\"prijs\":" + order.calculatePrice());
        sb.append("},");

        sb.append("\"tickets\":[");
        for (var t : tickets) {
            sb.append("{");
            sb.append("\"premium\":" + (t.isPremiumTicket() ? "true" : "false") + ",");
            sb.append("\"film\":\"" + t.getMovieName() + "\",");
            sb.append("\"stoel\":" + t.getRow() + ",");
            sb.append("\"rij\":" + t.getSeat());
            sb.append("},");
        }
        sb.append("]");
        sb.append("}");
        System.out.println(sb.toString());
    }

}