package fr.istic.commands;

import fr.istic.interf.ICommande;
import fr.istic.interf.IController;

public class MarquerMesure implements ICommande{
	private IController c;
	
	public MarquerMesure(IController cont){
		this.c=cont;
	}
	
	@Override
	public void execute() {
		c.marquerMesure();
	}

}
