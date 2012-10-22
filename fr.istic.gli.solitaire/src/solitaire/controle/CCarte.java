package solitaire.controle;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.application.Carte;
import solitaire.presentation.PCarte;

public class CCarte extends Carte {

	PCarte p;

	public CCarte(int valeur, int couleur) {
		super(valeur, couleur);

		p = new PCarte(valeurs[getValeur() - 1] + couleurs[getCouleur() - 1]);
		p.setFaceVisible(isFaceVisible());
	}

	public void setFaceVisible(boolean b) {
		super.setFaceVisible(b);
		p.setFaceVisible(isFaceVisible());
	}

	public PCarte getPresentation() {
		return p;
	}

	/**
	 * Testeur du controleur CCarte
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		JFrame f = new JFrame("Test PCarte");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par défaut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// pâle

		// une carte visible
		CCarte cc = new CCarte(12, 4);
		cc.setFaceVisible(true);
		f.getContentPane().add(cc.getPresentation());

		// une carte cachée
		cc = new CCarte(10, 3);
		cc.setFaceVisible(false);
		f.getContentPane().add(cc.getPresentation());

		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible

	} // main
}
