package figure;

import java.awt.*;
import java.awt.geom.Path2D;

/**
 * Created by tung on 12/8/15.
 */
public class Parallelogramme extends Polygone implements Measurable {
    private double lx, ly, angle;

    public Parallelogramme(Point[] sommets) {
        super(sommets);
    }

    public Parallelogramme(Point centre, double lx, double ly, double angle) {
        super.setCentre(centre);
        this.lx = lx;
        this.ly = ly;
        this.angle = angle;
        setsommets_parallelo(centre, lx, ly, angle);
    }

    private void setsommets_parallelo(Point centre, double lx, double ly, double alpha) {
        Point[] Sommet = new Point[4];
        for (int i = 0; i < 4; i++)
            Sommet[i] = new Point();

        Sommet[0].setX(centre.getx() - lx / 2);
        Sommet[0].setY(centre.gety() - ly / 2);

        Sommet[1].setX((centre.getx() - lx / 2) + ((Math.tan(alpha) * ly)));
        Sommet[1].setY(centre.gety() + ly / 2);

        Sommet[2].setX(centre.getx() + lx / 2);
        Sommet[2].setY(centre.gety() - ly / 2);

        Sommet[3].setX((centre.getx() + lx / 2) + ((Math.tan(alpha) * ly)));
        Sommet[3].setY(centre.gety() + ly / 2);
        super.setsommets(Sommet);
    }

    public double getLy() {
        return this.ly;
    }

    public double getLx() {
        return this.lx;
    }

    public double getangle() {
        return this.angle;
    }

    public double calculeaire() {
        return lx * ly * Math.sin(angle);

    }

    public double calculeparametre() {
        return 2 * (lx + ly);

    }

    public String getInfosParticulieres() {
        return " centre (x,y) = " + super.getCentre().getx() + "," + super.getCentre().gety() + " lx " + getLy() + " ly " + getLx() + "angle" + getangle();
    }

    public void dessiner(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        Path2D.Double chemin = new Path2D.Double();
        //chemin.moveTo(0, 0);
        chemin.moveTo(getsommets()[0].getx(), getsommets()[0].gety());
        chemin.lineTo(getsommets()[1].getx(), getsommets()[1].gety());

        chemin.lineTo(getsommets()[3].getx(), getsommets()[3].gety());
        chemin.lineTo(getsommets()[2].getx(), getsommets()[2].gety());


        chemin.closePath();
        g2d.fill(chemin);
        g2d.setColor(Color.red);
    }
}
