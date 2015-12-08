package figure;

/**
 * Created by tung on 11/24/15.
 */
public abstract class Polygone extends  Figure{
    //Permettre de creer un polygone de 10 sommets maximum
    private Point[] sommets=new Point[10];

    public Polygone(Point[] sommets_arr)
    {

        this.sommets=sommets_arr;

    }
    public Polygone()
    {

    }

    public Point[] getsommets()
    {
        return this.sommets;
    }
    public void setsommets(Point[] sommets)
    {
        this.sommets=sommets;
    }

}
