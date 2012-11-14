package solitaire.presentation;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.controle.CTasDeCartes;
import solitaire.controle.CUsine;
import solitaire.controle.ITasDeCartes;

public class PTasDeCartesColorees extends PTasDeCartes {

	public PTasDeCartesColorees(ITasDeCartes ct) {
		super(ct);
		setBackground(Color.CYAN);
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

		PTasDeCartesColorees pt = new PTasDeCartesColorees(new CTasDeCartes(
				"tas", new CUsine()));
		pt.setDy(10);
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
