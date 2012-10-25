package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.controle.CTasDeCartes;

public class PTasDeCartes extends JPanel {

	private int dx;
	private int dy;

	public PTasDeCartes(CTasDeCartes ct) {
		this.setBackground(Color.green);
		this.setLayout(null);
		this.setPreferredSize(new Dimension(500, 300));

		dx = 15;
		dy = 0;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public void empiler(PCarte pc) {
		pc.setBounds(dx * this.getComponentCount(),
				dy * this.getComponentCount(), pc.getWidth(), pc.getHeight());
		this.add(pc, 0);
	}

	public void depiler(PCarte pc) {
		this.remove(pc);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Test PCarte");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195));

		PTasDeCartes pt = new PTasDeCartes(
				new CTasDeCartes("tas", new CUsine()));
		PCarte pc1 = new PCarte("1D");
		pt.empiler(pc1);
		PCarte pc2 = new PCarte("8S");
		pt.empiler(pc2);
		PCarte pc3 = new PCarte("KH");
		pt.empiler(pc3);
		PCarte pc4 = new PCarte("3C");
		pt.empiler(pc4);

		// pt.depiler(pc1);

		// f.getContentPane().add(pt);
		f.setContentPane(pt);

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	}
}
