package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.application.TasDeCartes;
import solitaire.application.Usine;
import solitaire.controle.CCarte;
import solitaire.controle.CSabot;
import solitaire.controle.CTasDeCartes;

public class PSabot extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8364194809231798608L;

	private CSabot c;
	private RetournerSabotListener rsl;
	private RetournerCarteListener rcl;

	private PTasDeCartes cachees;
	private PTasDeCartes visibles;

	public PSabot(CSabot c, PTasDeCartes cachees, PTasDeCartes visibles) {

		rsl = new RetournerSabotListener();
		rcl = new RetournerCarteListener();

		this.cachees = cachees;
		this.visibles = visibles;

		this.setPreferredSize(new Dimension(500, 300));
		setLayout(new FlowLayout());
		setBackground(Color.RED);
		add(this.visibles);
		add(this.cachees);
		this.cachees.setDx(0);
		this.cachees.setDy(0);

		TasDeCartes g;
		this.visibles.setDx(25);
		this.visibles.setDy(0);

	}

	class RetournerSabotListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				c.retourner();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	class RetournerCarteListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			try {
				c.retournerCarte();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	public void activerRetournerCarte() {
		cachees.addMouseListener(rcl);
	}

	public void activerRetournerSabot() {
		cachees.addMouseListener(rsl);
	}

	public void desActiverRetournerCarte() {
		cachees.removeMouseListener(rcl);
		cachees.setCursor(null);
	}

	public void desActiverRetournerSabot() {
		cachees.removeMouseListener(rsl);
		cachees.setCursor(null);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame f = new JFrame("Test PCarte");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195));

		CTasDeCartes ctcach = new CTasDeCartes("tasCach", new Usine());
		ctcach.empiler(new CCarte(10, 1));
		ctcach.empiler(new CCarte(11, 2));

		CTasDeCartes ctvis = new CTasDeCartes("tasVis", new Usine());
		ctvis.empiler(new CCarte(7, 3));
		ctvis.empiler(new CCarte(2, 2));

		// PSabot ps = new PSabot(new CSabot(), cachees, visibles);
		PSabot ps = new PSabot(new CSabot("sabot", new CUsine()),
				ctcach.getPresentation(), ctvis.getPresentation());

		f.getContentPane().add(ps);

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	}
}
