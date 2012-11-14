package solitaire.controle;

import solitaire.application.Carte;
import solitaire.presentation.PTasDeCartes;

public interface ITasDeCartes {
	public void empiler(Carte c) throws java.lang.Exception;

	public void depiler() throws java.lang.Exception;

	public PTasDeCartes getPresentation();

}
