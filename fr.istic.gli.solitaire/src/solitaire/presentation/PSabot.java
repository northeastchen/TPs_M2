package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CSabot;
import solitaire.controle.CTasDeCartes;
import solitaire.controle.CUsine;

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
		this.c = c;
		this.cachees = cachees;
		this.visibles = visibles;

		this.cachees.setDx(0);
		this.cachees.setDy(0);

		this.visibles.setDx(25);
		this.visibles.setDy(0);

		this.setPreferredSize(new Dimension(500, 300));
		this.setLayout(new GridLayout(1, 2));
		this.setBackground(Color.ORANGE);
		this.add(this.cachees);
		this.add(this.visibles);

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
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par d�faut
		f.getContentPane().setBackground(new Color(143, 143, 195));

		CTasDeCartes ctcach = new CTasDeCartes("tasCach", new CUsine());

		CCarte cc1 = new CCarte(10, 1);
		CCarte cc2 = new CCarte(8, 3);

		ctcach.empiler(cc1);
		ctcach.empiler(cc2);

		CTasDeCartes ctvis = new CTasDeCartes("tasVis", new CUsine());
		CCarte cc3 = new CCarte(7, 3);
		cc3.setFaceVisible(true);

		ctvis.empiler(cc3);

		// PSabot ps = new PSabot(new CSabot(), cachees, visibles);
		PSabot ps = new PSabot(new CSabot("sabot", new CUsine()),
				ctcach.getPresentation(), ctvis.getPresentation());

		f.getContentPane().add(ps);

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	}
}
