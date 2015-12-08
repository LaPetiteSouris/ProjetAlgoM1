package figure;

/**
 * Created by tung on 11/24/15.
 */
public class Carre extends Rectangle {


    public Carre(Point[] sommets) {
        super(sommets);
    }

    public Carre(Point centre, double lx) {
        super(centre, lx, lx);
    }


    public String getInfosParticulieres() {
        return "Centre (" + super.getCentre().getx() + ", " + super.getCentre().gety() + "),   lx: " + getLx();

    }

}
