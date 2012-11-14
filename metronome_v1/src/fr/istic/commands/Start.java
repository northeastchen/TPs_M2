package fr.istic.commands;

import fr.istic.interf.ICommandGUI;
import fr.istic.interf.IController;

public class Start implements ICommandGUI {
	private IController c;

	public Start(IController cont) {
		c = cont;
	}

	@Override
	public void execute() {
		c.start();
	}

}
