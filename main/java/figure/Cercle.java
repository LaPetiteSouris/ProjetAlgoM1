package figure;

import java.awt.*;

/**
 * Created by tung on 10/27/15.
 */
public class Cercle extends Ellipse {



    public Cercle(double r,Point p) {
        super(r, r, p);
    }


    public String getInfosParticulieres() {
        return "Centre (" + super.getCentre().getx() + ", " + super.getCentre().gety() + "),   r: " + super.getR1();
    }

    public void dessiner(Graphics g){

        g.fillOval((int)getCentre().getx(), (int)getCentre().gety(), (int)getR1(), (int)getR2());
        g.setColor(Color.red);
    }
}
