package opdrachten.Cinema;

import java.util.ArrayList;
import java.util.List;

/**
 * CinemaCollection
 */
public class CinemaCollection implements CinemaComponent {
    private List<CinemaComponent> components;
    private String location;

    public CinemaCollection(String location) {
        components = new ArrayList<>();
        this.location = location;
    }

    @Override
    public void add(CinemaComponent component) {
        this.components.add(component);
    }

    @Override
    public void remove(CinemaComponent component) {
        this.components.remove(component);
    }

    @Override
    public CinemaComponent[] getChildren() {
        var array = new CinemaComponent[this.components.size()];
        this.components.toArray(array);
        return array;
    }

    @Override
    public String getLocation() {
        var locationB = new StringBuilder(this.location);
        locationB.append(" [");
        for (var c : this.components) {
            locationB.append(" "+c.getLocation()+" ");
        }
        locationB.append("]"); 
        return locationB.toString();
    }

    
}