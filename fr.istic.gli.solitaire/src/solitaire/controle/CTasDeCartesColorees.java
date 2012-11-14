package solitaire.controle;

import solitaire.application.Carte;
import solitaire.application.TasDeCartesColorees;
import solitaire.application.Usine;
import solitaire.presentation.PTasDeCartesColorees;

public class CTasDeCartesColorees extends TasDeCartesColorees implements
		ITasDeCartes {

	private PTasDeCartesColorees p;

	public CTasDeCartesColorees(String arg0, int arg1, Usine arg2) {
		super(arg0, arg1, arg2);
		p = new PTasDeCartesColorees(this);
	}

	@Override
	public PTasDeCartesColorees getPresentation() {
		return p;
	}

	@Override
	public void empiler(Carte arg0) {
		super.empiler(arg0);
		if (isVide() && arg0.getValeur() == 1) {
			p.empiler(((CCarte) arg0).getPresentation());
		} else {
			try {
				if (!isVide()
						&& getSommet().getValeur() == arg0.getValeur() + 1
						&& getSommet().getCouleur() == arg0.getCouleur()) {
					p.empiler(((CCarte) arg0).getPresentation());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
