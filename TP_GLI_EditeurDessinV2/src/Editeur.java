import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
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
	private JRadioButton jaune;
	
	private CreatorDessin cr = new CreatorRectangle();
	private CreatorDessin ce = new CreatorEllipse();
	private CreatorDessin cre = new CreatorRectangleEmpty();
	private CreatorDessin cee = new CreatorEllipseEmpty();
	
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

		radioRect.doClick();
		
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
				zdd.setColor(Color.RED);
			}
		});
		vert = new JRadioButton("Vert");
		vert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setColor(Color.GREEN);
			}
		});

		bleu = new JRadioButton("Bleu");
		bleu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setColor(Color.BLUE);
			}
		});
		jaune = new JRadioButton("Jaune");
		jaune.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zdd.setColor(Color.YELLOW);
			}
		});
		ButtonGroup bgc = new ButtonGroup();
		bgc.add(rouge);
		bgc.add(vert);
		bgc.add(bleu);
		bgc.add(jaune);

		rouge.doClick();
		
		barreCouleurs.add(rouge);
		barreCouleurs.add(vert);
		barreCouleurs.add(bleu);
		barreCouleurs.add(jaune);
		
		add(barreCouleurs,BorderLayout.EAST);
		
	}
	
	public static void main(String[] args) {
		
		Editeur e = new Editeur();
		
		e.setVisible(true);
	}

}
