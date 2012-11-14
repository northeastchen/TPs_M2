package fr.istic.impl;

import java.awt.Color;

import javax.swing.JLabel;

import fr.istic.interf.ILed;

public class Led extends JLabel implements ILed {

	int cpt = 0;

	public Led() {
		setBackground(Color.ORANGE);
	}

	@Override
	public void clignoter() {
		cpt++;
		setText("   " + cpt + "   ");
	}

}
