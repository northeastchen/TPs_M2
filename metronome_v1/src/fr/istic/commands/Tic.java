package fr.istic.commands;

import fr.istic.interf.ICommande;
import fr.istic.interf.IMoteur;

public class Tic implements ICommande {
	private IMoteur m;
	
	public Tic(IMoteur m){
		this.m=m;
	}
	
	public void execute(){
		m.tic();
	}
}
