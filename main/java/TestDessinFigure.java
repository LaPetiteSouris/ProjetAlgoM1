import figure.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestDessinFigure extends JFrame implements ActionListener {
    //Attributes geometrique
    figure.Cercle cercle;
    figure.Triangle triangle;
    figure.Rectangle rect;


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
    private DessinPanel dessinPanel;        // La zone de dessin


    public static void main(String args[]) {
        TestDessinFigure test = new TestDessinFigure();
        test.afficherFigure();
    }

    public TestDessinFigure() {
        super();
        setTitle("Dessin");
        monCadre = new JPanel();
        // monCadre.setLayout(new GridLayout(3, 1));
        monCadre.setLayout(new BoxLayout(monCadre, BoxLayout.Y_AXIS));

        // Creation des RB, zones de saisie et Boutons
        createFirstLine();
        // Creation des zones de texte
        createSecondLine();
        // Creation de la zone de dessin
        createThirdLine();

        // Ajout du cadre principal a la fenetre
        this.setContentPane(monCadre);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void createFirstLine() {
        JPanel linePanel = new JPanel();
        linePanel.setLayout(new GridLayout(1, 2));
        monCadre.add(linePanel);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 1));
        // Creation des RadioButton et ajout au cadre
        createRBFigure();
        gridPanel.add(rbPanel);
        // Creation des boutons et ajout au cadre
        createManage();
        gridPanel.add(managePanel);

        linePanel.add(gridPanel);
        // Creation des onglets et ajout au cadre
        createOnglet();
        linePanel.add(ongletPanel);
    }

    private void createRBFigure() {
        // Le panel de choix de figures
        rbPanel = new JPanel();
        rbPanel.setLayout(new GridLayout(3, 2));
        rbPanel.setBorder(BorderFactory.createTitledBorder("Choix du type de Figure"));

        // Ajout des elements au rbPanel
        ButtonGroup grp = new ButtonGroup();
        cercleRB = new JRadioButton("Cercle");
        cercleRB.addActionListener(this);
        cercleRB.setSelected(true);
        grp.add(cercleRB);
        rbPanel.add(cercleRB);

        ellipseRB = new JRadioButton("Ellipse");
        ellipseRB.addActionListener(this);
        grp.add(ellipseRB);
        rbPanel.add(ellipseRB);

        carreRB = new JRadioButton("Carre");
        carreRB.addActionListener(this);
        grp.add(carreRB);
        rbPanel.add(carreRB);

        rectangleRB = new JRadioButton("Rectangle");
        rectangleRB.addActionListener(this);
        grp.add(rectangleRB);
        rbPanel.add(rectangleRB);

        parallelogrammeRB = new JRadioButton("Parallelogramme");
        parallelogrammeRB.addActionListener(this);
        grp.add(parallelogrammeRB);
        rbPanel.add(parallelogrammeRB);

        triangleRB = new JRadioButton("Triangle");
        triangleRB.addActionListener(this);
        grp.add(triangleRB);
        rbPanel.add(triangleRB);
    }

    private void createOnglet() {
        // Le Panel gerant les actions
        ongletPanel = new JTabbedPane();
        // Cercle et Ellipse
        createOngletCercle();
        // Cercle et Ellipse
        createOngletRectangle();
        // Cercle et Ellipse
        createOngletTriangle();
    }

    private void createOngletCercle() {
        // Creation de l'onglet
        JPanel panelCercle = new JPanel();
        panelCercle.setLayout(new GridLayout(4, 3));
        ImageIcon iconMedia = createImageIcon("icon/cercle.png");
        ongletPanel.addTab("Cercle", iconMedia, panelCercle, "Cercle");

        // Ajout des differents elements de l'IHM
        panelCercle.add(new JLabel("Centre"));
        panelCercle.add(new JLabel("X:"));
        xCTF = new JTextField("50", 12);
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
        rYTF.setEnabled(false);
        panelCercle.add(rYTF);
    }

    private void createOngletRectangle() {
        // Creation de l'onglet
        JPanel panelRect = new JPanel();
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

    private void createOngletTriangle() {
        // Creation de l'onglet
        JPanel panelTriangle = new JPanel();
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

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void createManage() {
        // Le panel de choix de figures
        managePanel = new JPanel();
        managePanel.setLayout(new GridLayout(3, 2));

        // Ajout des elements au Panel
        ajoutB = new JButton("Creer / Ajouter");
        ajoutB.addActionListener(this);
        managePanel.add(ajoutB);

        afficherB = new JButton("Afficher");
        afficherB.addActionListener(this);
        afficherB.setEnabled(false);
        managePanel.add(afficherB);

        dessinerB = new JButton("Dessiner");
        dessinerB.addActionListener(this);
        dessinerB.setEnabled(false);
        managePanel.add(dessinerB);

        supprB = new JButton("Supprimer");
        supprB.addActionListener(this);
        supprB.setEnabled(false);
        managePanel.add(supprB);

        managePanel.add(new JLabel("Figure No"));
        String[] s = new String[1];
        s[0] = "1";
        figListe = new JComboBox(s);
        figListe.setSelectedIndex(0);
        managePanel.add(figListe);
        figListe.setEnabled(false);
    }

    private void createSecondLine() {
        JPanel linePanel = new JPanel();
        linePanel.setLayout(new FlowLayout());
        monCadre.add(linePanel);

        commonInfoTA = new JTextArea(10, 35);
        JScrollPane scrollPane = new JScrollPane(commonInfoTA);
        commonInfoTA.setEditable(false);
        linePanel.add(scrollPane);

        partInfoTA = new JTextArea(10, 35);
        scrollPane = new JScrollPane(partInfoTA);
        partInfoTA.setEditable(false);
        linePanel.add(scrollPane);
    }

    private void createThirdLine() {
        dessinPanel = new DessinPanel();
        monCadre.add(dessinPanel, BorderLayout.CENTER);
    }


    /**
     * Methode gerant les differents evenements
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cercleRB) {
            ongletPanel.setSelectedIndex(0);
            rYTF.setEnabled(false);
        } else if (e.getSource() == ellipseRB) {
            ongletPanel.setSelectedIndex(0);
            rYTF.setEnabled(true);
        } else if (e.getSource() == carreRB) {
            ongletPanel.setSelectedIndex(1);
            lYTF.setEnabled(false);
            alphaTF.setEnabled(false);
        } else if (e.getSource() == rectangleRB) {
            ongletPanel.setSelectedIndex(1);
            lYTF.setEnabled(true);
            alphaTF.setEnabled(false);
        } else if (e.getSource() == parallelogrammeRB) {
            ongletPanel.setSelectedIndex(1);
            lYTF.setEnabled(true);
            alphaTF.setEnabled(true);
        } else if (e.getSource() == triangleRB) {
            ongletPanel.setSelectedIndex(2);
        } else if (e.getSource() == ajoutB) {
            createFigure();
            updateFigListe();
        } else if (e.getSource() == afficherB) {
            afficherFigure();
        } else if (e.getSource() == supprB) {
            supprFigure();
            updateFigListe();
        } else if (e.getSource() == dessinerB) {
            // dessinPanel.updateDessinArea( myFigure );
            repaint();
        }
    }

    private void updateFigListe() {
        /*
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
		// */
    }


    private void createFigure() {

        if (cercleRB.isSelected()) {
            String xctf = xCTF.getText();
//            String yctf = yCTF.getText();
            String rxtf = rXTF.getText();
            String rytf = rYTF.getText();
            if (xctf != null && rxtf != null && rytf != null) {
                double r_d = Double.valueOf(xctf);
                double rxtf_d = Double.valueOf(rxtf);
                double rytf_d = Double.valueOf(rytf);
                figure.Point centre_cercle = new figure.Point(rxtf_d, rytf_d);
                cercle = new Cercle(centre_cercle, r_d);

            }

        } else if (rectangleRB.isSelected()) {
            String xqtf = xQTF.getText();
            String yqtf = yQTF.getText();
            String lxqtf = lXTF.getText();
            String lyqtf = lYTF.getText();
            if (xqtf != null && yqtf != null && lxqtf != null && lyqtf != null) {
                double xqtf_d = Double.valueOf(xqtf);
                double yqtf_d = Double.valueOf(yqtf);
                double lxqtf_d = Double.valueOf(lxqtf);
                double lyqtf_d = Double.valueOf(lyqtf);
                figure.Point centre_rect = new figure.Point(xqtf_d, yqtf_d);
                rect = new figure.Rectangle(centre_rect, lxqtf_d, lyqtf_d);
            }

        } else if (triangleRB.isSelected()) {

            String x1 = x1TF.getText();
            String y1 = y1TF.getText();
            String x2 = x2TF.getText();
            String y2 = y2TF.getText();
            String x3 = x3TF.getText();
            String y3 = y3TF.getText();


            if (x1 != null && x2 != null && x3 != null && y1 != null && y2 != null && y3 != null) {
                double x1_d = Double.valueOf(x1);
                double x2_d = Double.valueOf(x2);
                double x3_d = Double.valueOf(x3);
                double y1_d = Double.valueOf(y1);
                double y2_d = Double.valueOf(y2);
                double y3_d = Double.valueOf(y3);
                figure.Point somme1 = new figure.Point(x1_d, y1_d);
                figure.Point somme2 = new figure.Point(x2_d, y2_d);
                figure.Point somme3 = new figure.Point(x3_d, y3_d);
                figure.Point[] p = {somme1, somme2, somme3};
                triangle = new Triangle(p);
            }
        }
        afficherB.setEnabled(true);
    }

    private void afficherFigure() {
        /*
        if (cercleRB.isSelected()) {
            partInfoTA.setText("Area:  " + cercle.calculAre() + ", Parametre: " + cercle.calculParametre());

            commonInfoTA.setText("Cercle de centre: (" + cercle.getCentre().getx()  + "," + cercle.getCentre().gety()+")"+" et rayon "+cercle.getRayon());
        }

        if (rectangleRB.isSelected()) {
            partInfoTA.setText("Area: " + rect.calculAre() + ", Parametre: " + rect.calculParametre());

            commonInfoTA.setText("Rectangle de centre: (" + rect.getCentre().getx() + ", " + rect.getCentre().gety() + "),   lx: " + rect.getLx() + " ly: " + rect.getLy());
        }
        if (triangleRB.isSelected()) {
            partInfoTA.setText("Area: " + triangle.calculAre()  + ", Parametre " + triangle.calculParametre());

            commonInfoTA.setText("Triangle de centre: ("+triangle.calculeCentre().getx()+","+triangle.calculeCentre().gety() +"), et hauteur "+ triangle.getHauteur()+ " et base " +triangle.getBase());
        }
*/


        // A completer
    }

    private void supprFigure() {
        // A completer
    }
}
