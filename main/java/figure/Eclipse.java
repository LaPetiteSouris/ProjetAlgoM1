package figure;

/**
 * Created by tung on 12/8/15.
 */
public class Eclipse extends Figure {
    private double r1;
    private double r2;
    private Point centre;
    public Eclipse(double r1, double r2, Point centre)
    {
        super.setCentre(centre);
        this.r1=r1;
        this.r2=r2;

    }

    public double getR1() {
        return this.r1;
    }
    public  double getR2()
    {
        return this.r2;
    }

    String getInfosParticulieres() {
       return "Centre (" + super.getCentre().getx() + ", " + super.getCentre().gety() + "),   r1: " + getR1()+ "  , r2: "+getR2();
    }
}
