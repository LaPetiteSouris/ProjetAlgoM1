package figure;

/**
 * Created by tung on 10/27/15.
 */
public class Triangle extends Polygone implements Measurable {
    private Point somme1, somme2, somme3;
    private double base, hauteur;


    public Triangle(Point[] point) {
        super(point);
        this.somme1 = point[0];
        this.somme2 = point[1];
        this.somme3 = point[2];
        super.setCentre(calculeCentre());
        findbase();
        setHauteur();
    }

    private void findbase() {
        if ((somme1.gety() - somme2.gety()) == 0) {
            setbase(somme1.calculateDistance(somme2));
        } else if ((somme1.gety() - somme3.gety()) == 0) {
            setbase(somme1.calculateDistance(somme3));
        } else if ((somme2.gety()-somme3.gety()) == 0) {
            setbase(somme2.calculateDistance(somme3));
        }
    }

    public void setHauteur() {
        double h = calculeaire() * 2 / getBase();
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

    public Point calculeCentre() {
        double centre_x = 0.33 * (somme1.getx() + somme2.getx() + somme3.getx());
        double centre_y = 0.33 * (somme1.gety() + somme2.gety() + somme3.gety());
        Point centre = new Point(centre_x, centre_y);
        return centre;
    }

    public Point[] getsommets() {
        return super.getsommets();
    }

    public String getInfosParticulieres() {
        return  " centre (x,y) = "+super.getCentre().getx()+","+super.getCentre().gety()+" hauteur " + getHauteur() + " base " + getBase();
    }


    public double calculeaire() {
        double area = (somme1.getx() * (somme2.gety() - somme3.gety()) + somme2.getx() * (somme1.gety() - somme3.gety()) + somme3.getx() * (somme1.gety() - somme2.gety())) * 0.5;
        return Math.abs(area);
    }

    public double calculeparametre() {
        double edge1 = somme1.calculateDistance(somme2);
        double edge2 = somme1.calculateDistance(somme3);
        double edge3 = somme2.calculateDistance(somme3);
        return edge1 + edge2 + edge3;
    }
}
