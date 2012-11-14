package solitaire.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import solitaire.controle.CCarte;
import solitaire.controle.CColonne;
import solitaire.controle.CTasDeCartes;
import solitaire.controle.CTasDeCartesAlternees;
import solitaire.controle.CUsine;

public class PColonne extends JPanel {

	private PTasDeCartesAlternees visibles;
	private PTasDeCartes cachees;
	private CColonne c;

	public PColonne(CColonne c, PTasDeCartes cachees,
			PTasDeCartesAlternees visibles) {
		this.cachees = cachees;
		this.visibles = visibles;
		this.c = c;

		this.cachees.setDx(0);
		this.cachees.setDy(10);

		this.visibles.setDx(0);
		this.visibles.setDy(25);

		this.setPreferredSize(new Dimension(500, 300));
		this.setLayout(new GridLayout(2, 1));
		this.setBackground(Color.BLUE);
		this.add(this.cachees);
		this.add(this.visibles);

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

		CTasDeCartes ctcach = new CTasDeCartes("ctas", new CUsine());
		ctcach.getPresentation().setDy(10);
		CCarte cc1 = new CCarte(10, 1);
		CCarte cc2 = new CCarte(8, 3);

		ctcach.empiler(cc1);
		ctcach.empiler(cc2);

		CTasDeCartesAlternees pt = new CTasDeCartesAlternees("tas",
				new CUsine());
		pt.getPresentation().setDy(10);
		CCarte pc1 = new CCarte(8, 3);
		pt.empiler(pc1);
		CCarte pc2 = new CCarte(8, 3);
		pt.empiler(pc2);
		CCarte pc3 = new CCarte(8, 3);
		pt.empiler(pc3);
		CCarte pc4 = new CCarte(8, 3);
		pt.empiler(pc4);

		PColonne p = new PColonne(new CColonne("colonne1", new CUsine()),
				ctcach.getPresentation(), pt.getPresentation());

		f.getContentPane().add(p);

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	}
}
