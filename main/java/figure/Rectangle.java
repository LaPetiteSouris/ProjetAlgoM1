package figure;

/**
 * Created by tung on 10/27/15.
 */
public class Rectangle {
    private Point centre;
    private double lx;
    private double ly;
    private Point somme1, somme2, somme3, somme4;


    public Rectangle(Point p, double lar, double ly) {
        this.centre = p;
        this.lx = lar;
        this.ly = ly;
    }

    public Point getCentre() {
        return this.centre;
    }

    public double getLx() {
        return this.lx;
    }

    public double getLy() {
        return this.ly;
    }

    public double calculAre() {
        return lx * ly;
    }

    public double calculParametre() {
        return 2 * (lx + ly);
    }
}
