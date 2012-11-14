package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesAlternees;
import solitaire.presentation.PTasDeCartesAlternees;

public class CTasDeCartesAlternees extends TasDeCartesAlternees implements
		ITasDeCartes {

	private PTasDeCartesAlternees p;

	public CTasDeCartesAlternees(String arg0, CUsine arg1) {
		super(arg0, arg1);
		p = new PTasDeCartesAlternees(this);
	}

	public PTasDeCartesAlternees getPresentation() {
		return p;
	}

	@Override
	public void empiler(Carte arg0) {
		super.empiler(arg0);
		try {
			if (super.getSommet().equals(arg0)) {
				p.empiler(((CCarte) arg0).getPresentation());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
