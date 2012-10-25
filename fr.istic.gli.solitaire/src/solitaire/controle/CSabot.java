package solitaire.controle;

import solitaire.application.Sabot;
import solitaire.application.Tas;
import solitaire.presentation.PSabot;

public class CSabot extends Sabot {

	private PSabot p;

	public CSabot(String nom, CUsine u) {
		super(nom, u);
		p = new PSabot(this, ((CTasDeCartes) cachees).getPresentation(),
				((CTasDeCartes) visibles).getPresentation());
	}

	public PSabot getPresentation() {
		return p;
	}

	public void setReserve(Tas t) {
		super.setReserve(t);
		if (isCarteRetournable()) {
			p.activerRetournerCarte();
		}
	}

	public void retournerCarte() {
		try {
			super.retournerCarte();
			if (isRetournable()) {
				p.desActiverRetournerCarte();
				p.activerRetournerSabot();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void retourner() {
		try {
			super.retourner();
			p.desActiverRetournerSabot();
			p.activerRetournerCarte();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void depiler() {
		try {
			super.depiler();
			if (cachees.isVide() && visibles.isVide()) {
				p.desActiverRetournerSabot();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
