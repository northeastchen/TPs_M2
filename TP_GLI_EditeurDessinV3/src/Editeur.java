import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Editeur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JRadioButton radioRect;
	private JRadioButton radioEll;
	private JRadioButton radioRectEmpty;
	private JRadioButton radioEllEmpty;
	
	private JRadioButton rouge;
	private JRadioButton vert;
	private JRadioButton bleu;
	private JRadioButton choixCouleur;
	
	private JRadioButton deplacer;
	private JRadioButton detruire;
	private JRadioButton reformer;
	private JRadioButton rien;
	
	private CreatorDessin cr = new CreatorRectangle();
	private CreatorDessin ce = new CreatorEllipse();
	private CreatorDessin cre = new CreatorRectangleEmpty();
	private CreatorDessin cee = new CreatorEllipseEmpty();
	
	private Apercu apercu;
	
	private ZoneDeDessin zdd;
	
	public Editeur() {
		
		setTitle("maZoneDeDessin");
		setSize(800, 600);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			@Override
			public void windowClosed(WindowEvent e) {
			}
			@Override
			public void windowActivated(WindowEvent e) {
			}
		});
		
		setLayout(new BorderLayout());
		zdd = new ZoneDeDessin();
		
		add(zdd, BorderLayout.CENTER);
		
		// Formes
		JPanel barreFormes=new JPanel();
		barreFormes.setLayout(new BoxLayout(barreFormes, BoxLayout.Y_AXIS));
		
		radioRect = new JRadioButton("Rectangle plein");
		radioRect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setCD(cr);
			}
		});
		radioEll = new JRadioButton("Ellipse pleine");
		radioEll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setCD(ce);
			}
		});

		radioRectEmpty = new JRadioButton("Rectangle vide");
		radioRectEmpty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setCD(cre);
			}
		});
		radioEllEmpty = new JRadioButton("Ellipse vide");
		radioEllEmpty.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setCD(cee);
			}
		});
		ButtonGroup bgf = new ButtonGroup();
		bgf.add(radioRect);
		bgf.add(radioEll);
		bgf.add(radioRectEmpty);
		bgf.add(radioEllEmpty);

		barreFormes.add(radioRect);
		barreFormes.add(radioEll);
		barreFormes.add(radioRectEmpty);
		barreFormes.add(radioEllEmpty);
		
		add(barreFormes,BorderLayout.WEST);
		
		// Couleurs
		JPanel barreCouleurs = new JPanel();
		barreCouleurs.setLayout(new BoxLayout(barreCouleurs, BoxLayout.Y_AXIS));
		
		rouge = new JRadioButton("Rouge");
		rouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setForeground(Color.RED);
			}
		});
		vert = new JRadioButton("Vert");
		vert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setForeground(Color.GREEN);
			}
		});

		bleu = new JRadioButton("Bleu");
		bleu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setForeground(Color.BLUE);
			}
		});
		choixCouleur = new JRadioButton("...");
		choixCouleur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color col = JColorChooser.showDialog(zdd.getParent(), "Choix de couleur", zdd.getForeground());
				zdd.setForeground(col);
			}
		});
		
		ButtonGroup bgc = new ButtonGroup();
		bgc.add(rouge);
		bgc.add(vert);
		bgc.add(bleu);
		bgc.add(choixCouleur);

		barreCouleurs.add(rouge);
		barreCouleurs.add(vert);
		barreCouleurs.add(bleu);
		barreCouleurs.add(choixCouleur);
		
		apercu=new Apercu();
		zdd.addPropertyChangeListener("foreground", apercu);
		zdd.addPropertyChangeListener("forme", apercu);

		radioRect.doClick();
		rouge.doClick();
		
		barreCouleurs.add(apercu);
		add(barreCouleurs,BorderLayout.EAST);
		
		JPanel barreActions = new JPanel();
		barreActions.setLayout(new GridLayout(1,4));
		
		deplacer = new JRadioButton("Déplacement");
		deplacer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<zdd.getComponentCount();i++) {
				}
			}
		});
		detruire = new JRadioButton("Destruction");
		reformer = new JRadioButton("Reformation");
		rien = new JRadioButton("Dessin");
		
		ButtonGroup bga = new ButtonGroup();
		bga.add(deplacer);
		bga.add(detruire);
		bga.add(reformer);
		bga.add(rien);
		
		barreActions.add(deplacer);
		barreActions.add(detruire);
		barreActions.add(reformer);
		barreActions.add(rien);
		
		add(barreActions, BorderLayout.SOUTH);
		
	}
	
	public static void main(String[] args) {
		
		Editeur e = new Editeur();
		
		e.setVisible(true);
	}

}
