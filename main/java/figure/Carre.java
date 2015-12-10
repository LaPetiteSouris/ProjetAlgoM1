package figure;

import java.awt.*;

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

    public void dessiner(Graphics g){

        g.fillRect((int)super.getCentre().getx(), (int)super.getCentre().gety(), (int)super.getLx (),(int)super.getLy());
        g.setColor(Color.red);
    }
}
