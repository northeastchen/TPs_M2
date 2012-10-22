package solitaire.application;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import solitaire.presentation.PCarte;

public class Lanceur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame("Test PCarte");
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setLayout(new FlowLayout()); // au lieu de BorderLayout par d�faut
		f.getContentPane().setBackground(new Color(143, 143, 195)); // violet
																	// p�le

		// une carte visible
		PCarte pc = new PCarte("QH");
		pc.setFaceVisible(true);
		f.getContentPane().add(pc);

		// une carte cach�e
		pc = new PCarte("1D");
		pc.setFaceVisible(false);
		f.getContentPane().add(pc);

		f.pack(); // dimensionner le cadre
		f.setLocation(200, 100); // le positionner
		f.setVisible(true); // et le rendre visible
	}

}
