package figure;

/**
 * Created by tung on 12/8/15.
 */
public class Paralellogramme extends Polygone implements Measurable {
    private double lx, ly, angle;

    public Paralellogramme(Point[] sommets) {
        super(sommets);
    }

    public Paralellogramme(Point centre, double lx, double ly, double angle) {
        super.setCentre(centre);
        this.lx=lx;
        this.ly=ly;
        this.angle=angle;

    }
    public double getLy()
    {
        return this.ly;
    }
    public double getLx()
    {
        return this.lx;
    }

    public double getangle()
    {
        return this.angle;
    }
    public double calculeaire() {
        return lx*ly*Math.sin(angle);

    }

    public double calculeparametre() {
        return 2*(lx+ly);

    }

    public String getInfosParticulieres() {
        return " centre (x,y) = " + super.getCentre().getx() + "," + super.getCentre().gety() + " lx " + getLy() + " ly " + getLx()+"angle"+getangle();
    }
}
