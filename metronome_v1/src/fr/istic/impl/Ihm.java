package fr.istic.impl;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import fr.istic.interf.IAfficheur;
import fr.istic.interf.IClavier;
import fr.istic.interf.ICommande;
import fr.istic.interf.IHorloge;
import fr.istic.interf.IIhm;
import fr.istic.interf.IMolette;
import fr.istic.interf.IObservable;
import fr.istic.interf.IObserver;

public class Ihm implements IIhm, IObservable {

	private JFrame fenetre;
	private Afficheur aff;
	private Led l1;
	private Led l2;
	private Molette molette;
	private float valueTempo;
	private List<IObserver> l;
	private ICommande start;
	private ICommande stop;

	public Ihm() {
		l = new ArrayList<IObserver>();

		fenetre = new JFrame();
		fenetre.setTitle("Métronome");
		fenetre.setSize(800, 600);
		fenetre.setLayout(new BorderLayout());
		fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		aff = (Afficheur) Materiel.getInstance().getAfficheur();
		l1 = (Led) Materiel.getInstance().getAfficheur().getled1();
		l2 = (Led) Materiel.getInstance().getAfficheur().getled2();
		molette = (Molette) Materiel.getInstance().getMolette();

		fenetre.add(molette, BorderLayout.WEST);
		fenetre.add(aff, BorderLayout.CENTER);
		JPanel leds = new JPanel();
		leds.setLayout(new BoxLayout(leds, BoxLayout.Y_AXIS));
		leds.add(l1);
		leds.add(l2);
		fenetre.add(leds, BorderLayout.EAST);

		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		JButton incMesure = new JButton("incMesure");
		JButton decMesure = new JButton("decMesure");

		JPanel boutons = new JPanel();
		boutons.setLayout(new FlowLayout());
		boutons.add(start);
		boutons.add(stop);
		boutons.add(incMesure);
		boutons.add(decMesure);

		fenetre.add(boutons, BorderLayout.SOUTH);

		fenetre.add(molette, BorderLayout.WEST);

		fenetre.setVisible(true);
	}

	public void setCmdStart(ICommande start) {
		this.start = start;
	}

	public void setCmdStop(ICommande stop) {
		this.stop = stop;
	}

	@Override
	public void flasherLedTemps() {
		l1.clignoter();
		emettreSon();
	}

	@Override
	public void flasherLedMesure() {
		l2.clignoter();
	}

	@Override
	public void emettreSon() {
		Toolkit.getDefaultToolkit().beep();
	}

	@Override
	public void mettreAjourAfficheur(boolean etat, String value) {
		if (etat) {
			aff.setAfficheurEtat("Démarré : " + value);
		} else {
			aff.setAfficheurEtat("Arrêté : " + value);
		}

	}

	@Override
	public void setValueMolette(float v) {
		valueTempo = v;
		notifyObservers();

	}

	@Override
	public float getValueMolette() {
		return valueTempo;

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

	public static class Materiel {
		private IHorloge h;
		private IClavier c;
		private IMolette m;
		private IAfficheur aff;
		private static Materiel mat = new Materiel();

		private Materiel() {
			h = new Horloge(new Timer());
			c = new Clavier();
			m = new Molette();
			aff = new Afficheur(new Led(), new Led());

		}

		public static Materiel getInstance() {
			return mat;
		}

		public IHorloge getHorloge() {
			return h;
		}

		public IClavier getClavier() {
			return c;
		}

		public IMolette getMolette() {
			return m;
		}

		public IAfficheur getAfficheur() {
			return aff;
		}
	}
}
