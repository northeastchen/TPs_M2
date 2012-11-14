package solitaire.controle;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Carte;
import solitaire.application.TasDeCartes;
import solitaire.presentation.PTasDeCartes;

public class CTasDeCartes extends TasDeCartes implements ITasDeCartes {

	private PTasDeCartes p;

	public CTasDeCartes(String nom, CUsine u) {
		super(nom, u);
		p = new PTasDeCartes(this);

	}

	public void empiler(Carte c) {
		if (isEmpilable(c)) {
			super.empiler(c);
			// Par défaut, une carte qu'on peut empiler sera face visible -->
			// commenté pour tests
			// ((CCarte) c).setFaceVisible(true);
			p.empiler(((CCarte) c).getPresentation());
		}
	}

	public void depiler() {
		if (!isVide()) {
			try {
				CCarte c = (CCarte) getSommet();
				super.depiler();
				p.depiler(c.getPresentation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public PTasDeCartes getPresentation() {
		return p;
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

		CTasDeCartes pt = new CTasDeCartes("tas", new CUsine());
		Carte pc1 = new CCarte(2, 2);
		// pc1.setFaceVisible(false);
		pt.empiler(pc1);
		Carte pc2 = new CCarte(12, 4);
		pt.empiler(pc2);
		Carte pc3 = new CCarte(10, 3);
		pt.empiler(pc3);
		Carte pc4 = new CCarte(1, 1);
		pt.empiler(pc4);

		// pt.depiler();

		// f.getContentPane().add(pt);
		f.setContentPane(pt.getPresentation());

		// f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	}

}
