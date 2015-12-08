package figure;

/**
 * Created by tung on 10/27/15.
 */
public class Cercle extends Eclipse {



    public Cercle(Point p, double r) {
        super(r, r, p);
    }


    public double calculAre() {
        return Math.pow(super.getR1(), 2) * 3.14;
    }

    public double calculParametre() {
        return (2 * super.getR2()) * 3.14;
    }

    String getInfosParticulieres() {
        return "Centre (" + super.getCentre().getx() + ", " + super.getCentre().gety() + "),   r: " + super.getR1();
    }
}
