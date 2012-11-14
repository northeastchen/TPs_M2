package fr.istic.commands;

import fr.istic.interf.ICommandGUI;
import fr.istic.interf.IController;

public class Stop implements ICommandGUI {
	private IController c;

	public Stop(IController cont) {
		c = cont;
	}

	@Override
	public void execute() {
		c.stop();
	}

}
