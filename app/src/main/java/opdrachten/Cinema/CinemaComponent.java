package opdrachten.Cinema;

/**
 * CinemaComponent
 */
public interface CinemaComponent {

    public void add(CinemaComponent component);
    public void remove(CinemaComponent component);
    public CinemaComponent[] getChildren();

    public String getLocation();
}