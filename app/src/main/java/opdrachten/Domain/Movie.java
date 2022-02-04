package opdrachten.Domain;

import java.util.ArrayList;
import java.util.List;

public class Movie{

    private String title;
    private List<MovieScreening> screenings;

    public Movie(String title){
        this.title = title;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(MovieScreening screening){
        this.screenings.add(screening);
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Title: " + title + "\n" + "Screenings");
        for (MovieScreening movieScreening : screenings) {
            stringBuilder.append("\n" + movieScreening.toString());
        }
        return stringBuilder.toString();
    }
}