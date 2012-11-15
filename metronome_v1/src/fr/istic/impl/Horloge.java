package fr.istic.impl;

import java.util.Timer;
import java.util.TimerTask;

import fr.istic.interf.ICommande;
import fr.istic.interf.IHorloge;

public class Horloge implements IHorloge {
	private Timer timer;

	public Horloge(Timer t) {
		timer = t;
	}

	@Override
	public void activerPeriodiquement(final ICommande tic,
			float periodeEnSecondes) {
		TimerTask task = new TimerTask() {
			private ICommande c = tic;

			@Override
			public void run() {
				c.execute();
			}
		};
		long delay = 0;
		long periode = (long) periodeEnSecondes;
		timer.scheduleAtFixedRate(task, delay, periode);
	}

	@Override
	public void activerApresDelai(final ICommande cmd, float delaiEnSecondes) {
		TimerTask task = new TimerTask() {
			private ICommande c = cmd;

			@Override
			public void run() {
				c.execute();
			}
		};
		long delay = (long) delaiEnSecondes;
		timer.schedule(task, delay);
	}

	@Override
	public void desactiver(ICommande cmd) {
		timer.cancel();
	}

}
