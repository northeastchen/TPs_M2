package solitaire.controle;

import solitaire.application.Colonne;
import solitaire.application.Usine;
import solitaire.presentation.PColonne;

public class CColonne extends Colonne {
	private PColonne p;

	public CColonne(String arg0, Usine arg1) {
		super(arg0, arg1);
		p = new PColonne(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartesAlternees) visibles).getPresentation());
	}

	public PColonne getPresentation() {
		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
