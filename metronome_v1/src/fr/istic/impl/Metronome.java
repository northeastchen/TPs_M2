package fr.istic.impl;

import java.util.ArrayList;
import java.util.List;

import fr.istic.commands.Tic;
import fr.istic.interf.ICommande;
import fr.istic.interf.IHorloge;
import fr.istic.interf.IMoteur;
import fr.istic.interf.IObservable;
import fr.istic.interf.IObserver;

public class Metronome implements IMoteur, IObservable {
	private float tempo;
	private ICommande cmdMarquerTemps;
	private ICommande cmdMarquerMesure;
	private boolean etat;
	private List<IObserver> l;
	private int mesure;
	private IHorloge h;

	private int compteur_temps = 0;

	public Metronome(int mes, IHorloge horloge) {
		l = new ArrayList<IObserver>();
		mesure = mes;
		h = horloge;
	}

	@Override
	public void start() {
		setEtatMarche(true);
		h.activerPeriodiquement(new Tic(this), (60 / tempo) * 1000);
	}

	@Override
	public void stop() {
		setEtatMarche(false);
		h.desactiver(null);
	}

	@Override
	public void decMesure() {
		mesure--;
	}

	@Override
	public void incMesure() {
		mesure++;
	}

	private void marquerTemps() {
		cmdMarquerTemps.execute();
	}

	private void marquerMesure() {
		h.activerApresDelai(cmdMarquerMesure, 0);
	}

	@Override
	public float getTempo() {
		return tempo;
	}

	@Override
	public void setTempo(float t) {
		tempo = t;
		notifyObservers();
	}

	@Override
	public void setCmdMarquerTemps(ICommande c) {
		cmdMarquerTemps = c;
	}

	@Override
	public ICommande getCmdMarquerTemps() {
		return cmdMarquerTemps;
	}

	@Override
	public void setCmdMarquerMesure(ICommande c) {
		cmdMarquerMesure = c;
	}

	@Override
	public ICommande getCmdMarquerMesure() {
		return cmdMarquerMesure;
	}

	@Override
	public void setEtatMarche(Boolean b) {
		etat = b;
		notifyObservers();
	}

	@Override
	public boolean getEtatMarche() {
		return etat;
	}

	@Override
	public void notifyObservers() {
		for (IObserver o : l) {
			o.update(this);
		}
	}

	@Override
	public void registerObserver(IObserver o) {
		l.add(o);
	}

	@Override
	public void unregisterObserver(IObserver o) {
		l.remove(o);
	}

	@Override
	public void tic() {
		marquerTemps();
		compteur_temps++;
		System.out.println("temps");

		if (compteur_temps == mesure) {
			System.out.println("mesure");
			marquerMesure();
			compteur_temps = 0;
		}
	}

}
