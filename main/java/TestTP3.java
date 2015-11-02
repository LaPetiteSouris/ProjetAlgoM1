import figure.Cercle;
import figure.Point;
import figure.Rectangle;
import figure.Triangle;

import java.util.Arrays;

/**
 * Created by tung on 10/20/15.
 */
public class TestTP3 {
    public static void main(String[] arg) {
        Point p1 = new Point(0, 4);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(0, 0);
        Point[] p = {p1, p2, p3};
        double distance = p1.calculateDistance(p1);
        if (distance == 0)

        {
            System.out.println("Point class verified");
        }

        Rectangle rect = new Rectangle(p1, 5, 10);
        double are_rect = rect.calculAre();
        double para_rect = rect.calculParametre();
        if (are_rect == 50 && para_rect == 30) {
            System.out.println("Rectangle class verified");
        }
        Cercle cerc = new Cercle(p1, 1);
        double are_cercle = cerc.calculAre();
        double para_cercle = cerc.calculParametre();
        if (are_cercle == 3.14 && para_cercle == 6.28) {
            System.out.println("Cercle class verified");
        }

        Triangle tri = new Triangle(p);
        double are_triangle = tri.calculAre();
        double para_triangle = tri.calculParametre();

        if (are_triangle == 6 && para_triangle == 12) {
            System.out.println("Triangle class verified");
        }
    }

}
