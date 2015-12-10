package figure;

import java.awt.*;

/**
 * Created by tung on 12/8/15.
 */
public class Ellipse extends Figure implements Measurable {
    private double r1;
    private double r2;
    private Point centre;

    public Ellipse(double r1, double r2, Point centre) {
        super.setCentre(centre);
        this.r1 = r1;
        this.r2 = r2;

    }

    public double getR1() {
        return this.r1;
    }

    public double getR2() {
        return this.r2;
    }

    public double calculeaire() {
        return Math.PI * r1 * r2;
    }

    public double calculeparametre() {
        return (2 * Math.PI * Math.sqrt((r1 * r1 + r2 * r2) / 2));
    }

    public String getInfosParticulieres() {
        return "Centre (" + super.getCentre().getx() + ", " + super.getCentre().gety() + "),   r1: " + getR1() + "  , r2: " + getR2();
    }

    public void dessiner(Graphics g){

        g.fillOval((int)getCentre().getx(), (int)getCentre().gety(), (int)getR1(), (int)getR2());
        g.setColor(Color.red);
    }
}
