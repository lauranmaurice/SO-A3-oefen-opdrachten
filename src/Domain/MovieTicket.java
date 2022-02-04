package Domain;

public class MovieTicket{

    private MovieScreening movieScreening;
    private boolean isPremium;
    private int rowNr;
    private int seatNr;

    public MovieTicket(MovieScreening movieScreening, boolean isPremiumReservation, int seatRow, int seatNr){
        this.movieScreening = movieScreening;
        this.isPremium = isPremiumReservation;
        this.rowNr = seatRow;
        this.seatNr = seatNr;
    }

    public boolean isPremiumTicket(){
        return isPremium;
    }

    public double getPrice(){
        return movieScreening.getPricePerSeat();
    }

    public String getMovieName() {
        return this.movieScreening.getMovieName();
    }

    public int getRow() {
        return this.rowNr;
    }

    public int getSeat() {
        return this.seatNr;
    }

    public String toString(){
        String string = movieScreening.toString() + "\n Row Number: " + rowNr + "\n Seat Number: " + seatNr; 
        return string;
    }
}