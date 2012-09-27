import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Editeur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		
		
	}
	
	public static void main(String[] args) {
		
		Editeur e = new Editeur();
		
		e.setVisible(true);
	}

}
