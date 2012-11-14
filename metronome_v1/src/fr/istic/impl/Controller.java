package fr.istic.impl;

import fr.istic.interf.IController;
import fr.istic.interf.IIhm;
import fr.istic.interf.IMoteur;
import fr.istic.interf.IObservable;
import fr.istic.interf.IObserver;

public class Controller implements IController, IObserver {
	private IIhm ihm;
	private IMoteur m;

	public Controller(IIhm i, IMoteur m) {
		ihm = i;
		this.m = m;
	}

	@Override
	public void marquerTemps() {
		ihm.flasherLedTemps();
	}

	@Override
	public void marquerMesure() {
		ihm.flasherLedMesure();
	}

	@Override
	public void start() {
		boolean b = m.getEtatMarche();
		if (!b) {
			m.start();
		}
	}

	@Override
	public void stop() {
		boolean b = m.getEtatMarche();
		if (b) {
			m.stop();
		}
	}

	@Override
	public void update(IObservable o) {
		if (o instanceof IIhm) {
			m.setTempo(((IIhm) o).getValueMolette());

		} else if (o instanceof IMoteur) {
			// Traitement sur l'observable
			// empecher le bouton start d'être appuyé par exemple
			boolean etat = ((IMoteur) o).getEtatMarche();
			float tempo = ((IMoteur) o).getTempo();
			ihm.mettreAjourAfficheur(etat, Float.toString(tempo));
		}
	}
}
