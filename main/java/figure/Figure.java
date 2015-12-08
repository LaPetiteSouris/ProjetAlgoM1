package figure;

/**
 * Created by tung on 11/24/15.
 */
public abstract class Figure {
    private Point centre;

    public Figure() {

    }

    public void setCentre(Point cen) {
        this.centre = cen;
    }

    public Point getCentre()
    {
        return this.centre;
    }

    //Retourner info particulieres
    abstract  String getInfosParticulieres() ;

}
