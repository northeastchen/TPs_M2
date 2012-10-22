package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.application.Usine;
import solitaire.controle.CTasDeCartes;

public class PTasDeCartes extends JPanel {

	private int dx = 30;
	private int dy = 0;

	public PTasDeCartes(CTasDeCartes ct) {
		this.setBackground(Color.green);
		this.setLayout(null);
		this.setSize(500, 300);

	}

	public void empiler(PCarte pc) {
		pc.setBounds(dx * this.getComponentCount(), dy, pc.getWidth(),
				pc.getHeight());
		this.add(pc);
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

		PTasDeCartes pt = new PTasDeCartes(new CTasDeCartes("tas", new Usine()));
		PCarte pc1 = new PCarte("1D");
		pc1.setFaceVisible(true);
		pt.empiler(pc1);
		PCarte pc2 = new PCarte("8S");
		pc2.setFaceVisible(true);
		pt.empiler(pc2);
		PCarte pc3 = new PCarte("KH");
		pc3.setFaceVisible(true);
		pt.empiler(pc3);
		PCarte pc4 = new PCarte("3C");
		pc4.setFaceVisible(true);
		pt.empiler(pc4);

		// f.getContentPane().add(pt);
		f.setContentPane(pt);

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	}
}
