

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

import figure.*;
import figure.Point;
import figure.Rectangle;


class TestDessinFigure extends JFrame implements ActionListener {
	// Elements de l'IHM
	// Global
	private JPanel monCadre;
	// RadioButton
	private JPanel rbPanel;
	private JRadioButton cercleRB;
	private JRadioButton ellipseRB;
	private JRadioButton triangleRB;
	private JRadioButton carreRB;
	private JRadioButton rectangleRB;
	private JRadioButton parallelogrammeRB;
	// Onglets
	private JTabbedPane ongletPanel;
	// Cercle et Ellipse
	private JTextField xCTF;
	private JTextField yCTF;
	private JTextField rXTF;
	private JTextField rYTF;
	// Quadrilatere
	private JTextField xQTF;
	private JTextField yQTF;
	private JTextField lXTF;
	private JTextField lYTF;
	private JTextField alphaTF;
	// Triangle
	private JTextField x1TF;
	private JTextField y1TF;
	private JTextField x2TF;
	private JTextField y2TF;
	private JTextField x3TF;
	private JTextField y3TF;
	// Manage
	private JPanel managePanel;
	private JButton ajoutB;
	private JButton afficherB;
	private JButton dessinerB;
	private JButton supprB;
	private JComboBox figListe;
	// Zones de texte
	private JTextArea commonInfoTA;
	private JTextArea partInfoTA;
	// Zone de dessin
	static public DessinPanel dessinPanel;		// La zone de dessin
	public DessinPanel DP=new DessinPanel();
	public List<Object> myFigure = new ArrayList<Object>();
	public static void main(String args[]) {
		TestDessinFigure testD = new TestDessinFigure();
		DessinPanel DP=new DessinPanel();
	}

	public TestDessinFigure() {
		super();
		setTitle( "Dessin" );
		monCadre = new JPanel();
		// monCadre.setLayout(new GridLayout(3, 1));
		monCadre.setLayout(new BoxLayout(monCadre, BoxLayout.Y_AXIS));

		// Creation des RB, zones de saisie et Boutons
		createFirstLine( );
		// Creation des zones de texte
		createSecondLine( );
		// Creation de la zone de dessin
		createThirdLine( );

		// Ajout du cadre principal a la fenetre
		this.setContentPane( monCadre );

		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void createFirstLine( ) {
		JPanel linePanel = new JPanel( );
		linePanel.setLayout( new GridLayout(1, 2) );
		monCadre.add( linePanel );

		JPanel gridPanel = new JPanel( );
		gridPanel.setLayout( new GridLayout(2, 1) );
		// Creation des RadioButton et ajout au cadre
		createRBFigure( );
		gridPanel.add( rbPanel );
		// Creation des boutons et ajout au cadre
		createManage( );
		gridPanel.add( managePanel );

		linePanel.add( gridPanel );
		// Creation des onglets et ajout au cadre
		createOnglet( );
		linePanel.add( ongletPanel );
	}

	private void createRBFigure( ) {
		// Le panel de choix de figures
		rbPanel = new JPanel();
		rbPanel.setLayout(new GridLayout(3, 2));
		rbPanel.setBorder( BorderFactory.createTitledBorder( "Choix du type de Figure" ) );

		// Ajout des elements au rbPanel
		ButtonGroup grp = new ButtonGroup();
		cercleRB = new JRadioButton( "Cercle" );
		cercleRB.addActionListener(this);
		cercleRB.setSelected(true);
		grp.add( cercleRB );
		rbPanel.add( cercleRB );

		ellipseRB = new JRadioButton( "Ellipse" );
		ellipseRB.addActionListener(this);
		grp.add( ellipseRB );
		rbPanel.add( ellipseRB );

		carreRB = new JRadioButton( "Carre" );
		carreRB.addActionListener(this);
		grp.add( carreRB );
		rbPanel.add( carreRB );

		rectangleRB = new JRadioButton( "Rectangle" );
		rectangleRB.addActionListener(this);
		grp.add( rectangleRB );
		rbPanel.add( rectangleRB );

		parallelogrammeRB = new JRadioButton( "Parallelogramme" );
		parallelogrammeRB.addActionListener(this);
		grp.add( parallelogrammeRB );
		rbPanel.add( parallelogrammeRB );

		triangleRB = new JRadioButton( "Triangle" );
		triangleRB.addActionListener(this);
		grp.add( triangleRB );
		rbPanel.add( triangleRB );
	}

	private void createOnglet( ) {
		// Le Panel gerant les actions
		ongletPanel = new JTabbedPane( );
		// Cercle et Ellipse
		createOngletCercle( );
		// Cercle et Ellipse
		createOngletRectangle( );
		// Cercle et Ellipse
		createOngletTriangle( );
	}

	private void createOngletCercle( ){
		// Creation de l'onglet
		JPanel panelCercle = new JPanel( );
		panelCercle.setLayout(new GridLayout(4, 3));
		ImageIcon iconMedia = createImageIcon("icon/cercle.png");
		ongletPanel.addTab("Cercle", iconMedia, panelCercle, "Cercle");

		// Ajout des differents elements de l'IHM
		panelCercle.add(new JLabel("Centre"));
		panelCercle.add(new JLabel("X:"));
		xCTF = new JTextField( "50", 12 );
		panelCercle.add(xCTF);

		panelCercle.add(new JLabel(""));
		panelCercle.add(new JLabel("Y:"));
		yCTF = new JTextField("50", 12);
		panelCercle.add(yCTF);

		panelCercle.add(new JLabel("Rayon"));
		panelCercle.add(new JLabel("en X:"));
		rXTF = new JTextField("50", 12);
		panelCercle.add(rXTF);

		panelCercle.add(new JLabel(""));
		panelCercle.add(new JLabel("en Y:"));
		rYTF = new JTextField("50", 12);
		rYTF.setEnabled( false );
		panelCercle.add(rYTF);
	}

	private void createOngletRectangle( ){
		// Creation de l'onglet
		JPanel panelRect = new JPanel( );
		panelRect.setLayout(new GridLayout(5, 2));
		ImageIcon iconMedia = createImageIcon("icon/carre.png");
		ongletPanel.addTab("Quadrilatere", iconMedia, panelRect, "Quadrilatere");

		// Ajout des differents elements de l'IHM
		panelRect.add(new JLabel("Centre"));
		panelRect.add(new JLabel("X:"));
		xQTF = new JTextField("50", 12);
		panelRect.add(xQTF);

		panelRect.add(new JLabel(""));
		panelRect.add(new JLabel("Y:"));
		yQTF = new JTextField("50", 12);
		panelRect.add(yQTF);

		panelRect.add(new JLabel("Cote"));
		panelRect.add(new JLabel("en X:"));
		lXTF = new JTextField("50", 12);
		panelRect.add(lXTF);

		panelRect.add(new JLabel(""));
		panelRect.add(new JLabel("en Y:"));
		lYTF = new JTextField("50", 12);
		panelRect.add(lYTF);

		panelRect.add(new JLabel(""));
		panelRect.add(new JLabel("alpha:"));
		alphaTF = new JTextField("0", 12);
		panelRect.add(alphaTF);
	}

	private void createOngletTriangle( ){
		// Creation de l'onglet
		JPanel panelTriangle = new JPanel( );
		panelTriangle.setLayout(new GridLayout(6, 3));
		ImageIcon iconMedia = createImageIcon("icon/triangle.png");
		ongletPanel.addTab("Triangle", iconMedia, panelTriangle, "Triangle");

		// Ajout des differents elements de l'IHM
		panelTriangle.add(new JLabel("Point 1"));
		panelTriangle.add(new JLabel("X:"));
		x1TF = new JTextField("0", 12);
		panelTriangle.add(x1TF);

		panelTriangle.add(new JLabel(""));
		panelTriangle.add(new JLabel("Y:"));
		y1TF = new JTextField("0", 12);
		panelTriangle.add(y1TF);

		panelTriangle.add(new JLabel("Point 2"));
		panelTriangle.add(new JLabel("X:"));
		x2TF = new JTextField("100", 12);
		panelTriangle.add(x2TF);

		panelTriangle.add(new JLabel(""));
		panelTriangle.add(new JLabel("Y:"));
		y2TF = new JTextField("0", 12);
		panelTriangle.add(y2TF);

		panelTriangle.add(new JLabel("Point 3"));
		panelTriangle.add(new JLabel("X:"));
		x3TF = new JTextField("50", 12);
		panelTriangle.add(x3TF);

		panelTriangle.add(new JLabel(""));
		panelTriangle.add(new JLabel("Y:"));
		y3TF = new JTextField("50", 12);
		panelTriangle.add(y3TF);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon( String path ) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon( imgURL );
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private void createManage( ) {
		// Le panel de choix de figures
		managePanel = new JPanel();
		managePanel.setLayout(new GridLayout(3, 2));

		// Ajout des elements au Panel
		ajoutB = new JButton( "Creer / Ajouter" );
		ajoutB.addActionListener( this );
		managePanel.add( ajoutB );

		afficherB = new JButton( "Afficher" );
		afficherB.addActionListener( this );
		afficherB.setEnabled( false );
		managePanel.add( afficherB );

		dessinerB = new JButton( "Dessiner" );
		dessinerB.addActionListener( this );
		dessinerB.setEnabled( false );
		managePanel.add( dessinerB );

		supprB = new JButton( "Supprimer" );
		supprB.addActionListener( this );
		supprB.setEnabled( false );
		managePanel.add( supprB );

		managePanel.add( new JLabel("Figure No") );
		String[] s = new String[1];
		s[0] = "1";
		figListe = new JComboBox(s);
		figListe.setSelectedIndex(0);
		managePanel.add(figListe);
		figListe.setEnabled( false );
	}

	private void createSecondLine( ) {
		JPanel linePanel = new JPanel( );
		linePanel.setLayout( new FlowLayout( ) );
		monCadre.add( linePanel );

		commonInfoTA = new JTextArea(10, 35);
		JScrollPane scrollPane = new JScrollPane(commonInfoTA);
		commonInfoTA.setEditable(false);
		linePanel.add( scrollPane );

		partInfoTA = new JTextArea(10, 35);
		scrollPane = new JScrollPane(partInfoTA);
		partInfoTA.setEditable(false);
		linePanel.add( scrollPane );
	}

	private void createThirdLine( ) {
		dessinPanel = new DessinPanel( );
		monCadre.add( dessinPanel, BorderLayout.CENTER );
	}


	/**
	 * Methode gerant les differents evenements
	 */
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == cercleRB ) {
			ongletPanel.setSelectedIndex( 0 );
			rYTF.setEnabled( false );
		} else if( e.getSource() == ellipseRB ) {
			ongletPanel.setSelectedIndex( 0 );
			rYTF.setEnabled( true );
		} else if( e.getSource() == carreRB ) {
			ongletPanel.setSelectedIndex( 1 );
			lYTF.setEnabled( false );
			alphaTF.setEnabled( false );
		} else if( e.getSource() == rectangleRB ) {
			ongletPanel.setSelectedIndex( 1 );
			lYTF.setEnabled( true );
			alphaTF.setEnabled( false );
		} else if ( e.getSource() == parallelogrammeRB ) {
			ongletPanel.setSelectedIndex( 1 );
			lYTF.setEnabled( true );
			alphaTF.setEnabled( true );
		} else if ( e.getSource() == triangleRB ) {
			ongletPanel.setSelectedIndex( 2 );
		} else if ( e.getSource() == ajoutB ) {
			createFigure( );
			updateFigListe( );
		} else if ( e.getSource() == afficherB ) {
			afficherFigure( );
		} else if ( e.getSource() == supprB ) {
			supprFigure( );
			updateFigListe( );
		} else if ( e.getSource() == dessinerB ) {
			DP.updateDessinArea((Object)myFigure.get(figListe.getSelectedIndex()));
			repaint( );
		}
	}

	private void updateFigListe( ) {

		if( myFigure.isEmpty( ) ) {
			afficherB.setEnabled( false );
			supprB.setEnabled( false );
			figListe.setEnabled( false );
			dessinerB.setEnabled( false );
		} else {
			afficherB.setEnabled( true );
			supprB.setEnabled( true );
			figListe.setEnabled( true );
			dessinerB.setEnabled( true );

			if( myFigure.size() > figListe.getItemCount() ) {
				// Ajout d'un element
				figListe.addItem( String.valueOf( myFigure.size() ) );
			} else if( myFigure.size() < figListe.getItemCount() ) {
				// Suppression d'un element
				figListe.removeItemAt( figListe.getItemCount()-1 );
			}
		}

	}


	private void createFigure( ) {
//	try {
		if(cercleRB.isSelected()==true){

			Cercle c1=new Cercle(Integer.parseInt(rXTF.getText()),
					new Point(  Integer.parseInt(xCTF.getText())  ,   Integer.parseInt(yCTF.getText())  )
			);
			myFigure.add(c1);



		}
		else if((rectangleRB.isSelected()==true)){
			Rectangle R1=new Rectangle(new Point(Integer.parseInt(xQTF.getText()),
					Integer.parseInt(xQTF.getText()))  ,  Integer.parseInt(lXTF.getText())  ,  Integer.parseInt(lYTF.getText()));
			myFigure.add(R1);
		}

		else if(triangleRB.isSelected()==true){
			Point[] point_tableau={new Point(Integer.parseInt(x1TF.getText())  ,   Integer.parseInt(y1TF.getText()))   ,
					new Point(  Integer.parseInt(x2TF.getText())  ,  Integer.parseInt(y2TF.getText())  ) ,
					new Point(  Integer.parseInt(x3TF.getText())  ,  Integer.parseInt(y3TF.getText()))};
			Triangle T1=new Triangle(point_tableau );
			myFigure.add(T1);
		}

		else if(ellipseRB.isSelected()==true){
			Ellipse E1=new Ellipse(Integer.parseInt(rXTF.getText())  ,   Integer.parseInt(rYTF.getText())   ,
					new Point(  Integer.parseInt(xCTF.getText())  ,  Integer.parseInt(yCTF.getText()) )
			);
			myFigure.add(E1);
		}

		else if(carreRB.isSelected()==true){
			Carre C1=new Carre(new Point(  Integer.parseInt(xQTF.getText())  ,  Integer.parseInt(yQTF.getText()) ),
					Integer.parseInt(lXTF.getText())

			);
			myFigure.add(C1);
		}
		else if(parallelogrammeRB.isSelected()==true){
			Parallelogramme C1=new Parallelogramme(new Point(  Integer.parseInt(xQTF.getText())  ,  Integer.parseInt(yQTF.getText()) ),
					Integer.parseInt(lXTF.getText()),  Integer.parseInt(lYTF.getText()), Integer.parseInt(alphaTF.getText())

			);
			myFigure.add(C1);
		}

/*} catch ( Exception e) {
                    System.out.println(e.toString());
                    javax.swing.JOptionPane.showMessageDialog(null, e.toString());
                    }*/
	}

	private void afficherFigure( ) {


		String s="\n";
		for(int i=0; i<myFigure.size();i++){
			if(myFigure.get(i) instanceof Rectangle)
				s+=((Rectangle)myFigure.get(i)).getInfosParticulieres()+"\n";
			else if(myFigure.get(i) instanceof Triangle)
				s+=((Triangle)myFigure.get(i)).getInfosParticulieres()+"\n";
			else if(myFigure.get(i) instanceof Cercle)
				s+=((Cercle)myFigure.get(i)).getInfosParticulieres()+"\n";
			else if(myFigure.get(i) instanceof Carre)
				s+=((Carre)myFigure.get(i)).getInfosParticulieres()+"\n";
			else if(myFigure.get(i) instanceof Ellipse)
				s+=((Ellipse)myFigure.get(i)).getInfosParticulieres()+"\n";
			else if(myFigure.get(i) instanceof Parallelogramme)
				s+=((Parallelogramme)myFigure.get(i)).getInfosParticulieres()+"\n";
		}


		partInfoTA.setText(s);
		commonInfoTA.setText(myFigure.toString());


	}

	private void supprFigure( ) {
		myFigure.remove(figListe.getSelectedIndex());
	}
}