package Domain;
import java.time.LocalDateTime;

public class MovieScreening{
    
    private Movie movie; 
    private LocalDateTime dateAndTime;
    private double pricePerSeat;


    public MovieScreening(Movie movie, LocalDateTime dateAndTime, Double pricePerSeat){
        this.movie = movie;
        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public double getPricePerSeat(){
        return pricePerSeat;
    }

    public LocalDateTime getDateTime() {
        return this.dateAndTime;
    }

    public String toString(){
        return "Movie: " + movie.getTitle() + "\n Price per seat: $" + pricePerSeat + "\n Date and time: " + dateAndTime;
    }

    public String getMovieName() {
        return this.movie.getTitle();
    }

}
