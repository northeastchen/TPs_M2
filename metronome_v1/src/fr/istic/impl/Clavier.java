package fr.istic.impl;

import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.istic.interf.IClavier;

public class Clavier extends JPanel implements IClavier {
	private Hashtable<JButton, Boolean> liste_buttons;

	public Clavier() {

	}

	@Override
	public boolean touchePresse(int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
