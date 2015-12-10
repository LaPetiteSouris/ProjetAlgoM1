package figure;


/**
 * Created by tung on 10/27/15.
 */
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public double getx() {
        return this.x;
    }

    public double gety() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;

    }

    public void setY(double y) {
        this.y = x;

    }

    public double calculateDistance(Point p) {
        double x_p = p.getx();
        double y_p = p.gety();
        double distance = 0;
        distance = Math.sqrt(Math.pow(x_p - this.x, 2) + Math.pow(y_p - this.y, 2));
        return distance;

    }
}
