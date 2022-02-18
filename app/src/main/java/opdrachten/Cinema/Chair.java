package opdrachten.Cinema;

/**
 * Chair
 */
public class Chair implements CinemaComponent {
    public int chairNumber;

    public Chair(int chairNumber){
        this.chairNumber = chairNumber;
    }

	@Override
	public void add(CinemaComponent component) {

	}

	@Override
	public void remove(CinemaComponent component) {

	}

	@Override
	public CinemaComponent[] getChildren() {
		return null;
	}

	@Override
	public String getLocation() {
        return ""+this.chairNumber;
	}

    
}