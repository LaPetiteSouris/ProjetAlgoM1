package figure;

/**
 * Created by tung on 10/27/15.
 */
public class Triangle {
    private Point somme1, somme2, somme3;
    private double base, hauteur;


    public Triangle(Point[] point) {
        this.somme1 = point[0];
        this.somme2 = point[1];
        this.somme3 = point[2];
        findbase();
        setHauteur();

    }

    private void findbase() {
        if ((somme1.gety() - somme2.gety()) == 0) {
            setbase(somme1.calculateDistance(somme2));
        } else if ((somme1.gety() - somme3.gety()) == 0) {
            setbase(somme1.calculateDistance(somme3));
        } else if ((somme2.calculateDistance(somme3)) == 0) {
            setbase(somme2.calculateDistance(somme3));
        }
    }

    public void setHauteur() {
        double h = calculAre() * 2 / getBase();
        this.hauteur = h;
    }

    public void setbase(double b) {
        this.base = b;
    }

    public double getHauteur() {
        return this.hauteur;
    }

    public double getBase() {
        return this.base;
    }

    public Point getSomme1() {
        return this.somme1;
    }

    public Point getSomme2() {
        return this.somme2;
    }

    public Point getSomme3() {
        return this.somme3;
    }

    public Point getCentre() {
        double centre_x = 0.33 * (somme1.getx() + somme2.getx() + somme3.getx());
        double centre_y = 0.33 * (somme1.gety() + somme2.gety() + somme3.gety());
        Point centre = new Point(centre_x, centre_y);
        return centre;
    }

    public double calculAre() {
        double area = (somme1.getx() * (somme2.gety() - somme3.gety()) + somme2.getx() * (somme1.gety() - somme3.gety()) + somme3.getx() * (somme1.gety() - somme2.gety())) * 0.5;
        return Math.abs(area);
    }

    public double calculParametre() {
        double edge1 = somme1.calculateDistance(somme2);
        double edge2 = somme1.calculateDistance(somme3);
        double edge3 = somme2.calculateDistance(somme3);
        return edge1 + edge2 + edge3;
    }
}
