import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;


public class Editeur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JRadioButton radioRect;
	private JRadioButton radioEll;
	
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
		
		add(new ZoneDeDessin(), BorderLayout.CENTER);
		JPanel barreBouton=new JPanel();
		radioRect = new JRadioButton("Rectangle");
		radioEll = new JRadioButton("Ellipse");
		ButtonGroup bg = new ButtonGroup();
		bg.add(radioRect);
		bg.add(radioEll);
		barreBouton.add(radioRect);
		barreBouton.add(radioEll);
		add(barreBouton,BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		
		Editeur e = new Editeur();
		
		e.setVisible(true);
	}

}
