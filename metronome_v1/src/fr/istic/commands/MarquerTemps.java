package fr.istic.commands;

import fr.istic.interf.ICommande;
import fr.istic.interf.IController;

public class MarquerTemps implements ICommande {
	private IController c;
	
	public MarquerTemps(IController cont){
		this.c=cont;
	}
	
	@Override
	public void execute() {
		c.marquerTemps();
	}

}
