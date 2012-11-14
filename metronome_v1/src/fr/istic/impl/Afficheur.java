package fr.istic.impl;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.istic.interf.IAfficheur;
import fr.istic.interf.ILed;

public class Afficheur extends JPanel implements IAfficheur {

	private static final long serialVersionUID = 1L;
	private JLabel label;

	private Led led1;
	private Led led2;

	public Afficheur(Led led1, Led led2) {
		setBackground(Color.CYAN);
		this.led1 = led1;
		this.led2 = led2;
		label = new JLabel("temps");
		label.setBackground(Color.RED);
	}

	@Override
	public void setAfficheurTempo(float t) {
		// TODO Auto-generated method stub
		label.setText(Float.toString(t));
		System.out.println(Float.toString(t));
	}

	@Override
	public String getAfficheurTempo() {
		return label.getText();
	}

	@Override
	public void setAfficheurEtat(String s) {
		label.setText(s);
	}

	@Override
	public ILed getled1() {
		return led1;
	}

	@Override
	public ILed getled2() {
		return led2;
	}

}
