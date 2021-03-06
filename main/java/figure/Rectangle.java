package figure;

import java.awt.*;

/**
 * Created by tung on 10/27/15.
 */
public class Rectangle extends Parallelogramme implements Measurable {
    private double lx;
    private double ly;
    public Rectangle(Point[] sommets)
    {
        super(sommets);
    }


    public Rectangle(Point p, double lax, double ly) {
        super(p, lax,ly,0);
        this.lx = lax;
        this.ly = ly;
    }

    public Point getCentre() {
        return super.getCentre();
    }

    public double getLx() {
        return this.lx;
    }

    public double getLy() {
        return this.ly;
    }

    public double calculeaire() {
        return lx * ly;
    }

    public double calculeparametre() {
        return 2 * (lx + ly);
    }

    public String getInfosParticulieres() {
        return " centre (x,y) = " + super.getCentre().getx() + "," + super.getCentre().gety() + " largeur " + getLy() + " hauteur " + getLx();
    }

    public void dessiner(Graphics g){

        g.fillRect((int)super.getCentre().getx(), (int)super.getCentre().gety(), (int)super.getLx(), (int)super.getLy());
        g.setColor(Color.red);
    }

}
