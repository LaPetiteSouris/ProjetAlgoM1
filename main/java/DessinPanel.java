
import figure.Figure;
import figure.*;
import figure.Rectangle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.List;

public class DessinPanel extends JPanel {
	public final int DRAW_AREA_X = 800;
	public final int DRAW_AREA_Y = 300;

	private Dimension dim;     // Dimension de la zone de dessin
	private Graphics buffer;   // Pour la fluidite des animations
	private BufferedImage ArrierePlan;  // L'arriere plan sur lequel on dessine
	private Color[] clrs = {Color.black, Color.red, Color.blue, Color.green, Color.cyan, Color.yellow};
	// private Color[] clrs = {Color.red, Color.white, Color.black, Color.black};

	public DessinPanel(){
		super( );
		setLayout( new FlowLayout( ) );

		dim = new Dimension( DRAW_AREA_X, DRAW_AREA_Y );
		setPreferredSize( dim );
		// Creation de l'arriere plan sur laquelle on va dessiner
		ArrierePlan = new BufferedImage(dim.width, dim.height, BufferedImage.TYPE_INT_RGB);
		// Récupération du buffer graphique sera associé à l‘ArrierePlan
		buffer = ArrierePlan.getGraphics();
		initDessinArea( );
	}

	/* Paint() recopie l'image uniquement quand tous les elements
	 * graphiques sont places dans le buffer associe a ArrierePlan
	 */
	public void paint( Graphics g ) {
		// Trace le buffer associé à  ArrierePlan dans le JFrame
		g.drawImage(ArrierePlan, 0, 0, this);
	}

	/* Sert a effacer les dessins precedents (en tracant un rectangle blanc) */
	public void initDessinArea( ) {
		buffer.setColor(Color.white);
		buffer.clearRect( 0, 0, dim.width, dim.height );
		buffer.fillRect( 0, 0, dim.width, dim.height );

	}


	public void updateDessinArea(Object fig) {
		// On efface les dessins precedents
		initDessinArea();
		TestDessinFigure.dessinPanel.buffer.clearRect(0, 0, dim.width, dim.height);
		TestDessinFigure.dessinPanel.buffer.setColor(Color.white);
		if(fig instanceof Rectangle)
			((Rectangle)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		else if (fig instanceof Cercle)
			((Cercle)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		else if (fig instanceof Triangle)
			((Triangle)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		else if (fig instanceof Ellipse)
			((Ellipse)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		else if (fig instanceof Carre)
			((Carre)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		else if (fig instanceof Parallelogramme)
			((Parallelogramme)fig).dessiner(TestDessinFigure.dessinPanel.buffer);
		// Appel de la fonction d'affichage
		repaint( );
	}


}