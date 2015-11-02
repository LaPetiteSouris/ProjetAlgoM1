package figure;

/**
 * Created by tung on 10/27/15.
 */
public class Cercle {
    private Point centre;
    private double rayon;


    public Cercle(Point p, double rayon) {
        this.centre = p;
        this.rayon = rayon;
    }

    public Point getCentre()
    {
        return this.centre;
    }
    public double getRayon()
    {
        return this.rayon;
    }

    public double calculAre() {
        return Math.pow(rayon, 2) * 3.14;
    }

    public double calculParametre() {
        return (2 * rayon) * 3.14;
    }
}
