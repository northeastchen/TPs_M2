import java.util.Timer;

import fr.istic.commands.MarquerMesure;
import fr.istic.commands.MarquerTemps;
import fr.istic.impl.Controller;
import fr.istic.impl.Horloge;
import fr.istic.impl.Ihm;
import fr.istic.impl.Metronome;
import fr.istic.interf.ICommande;
import fr.istic.interf.IController;
import fr.istic.interf.IHorloge;
import fr.istic.interf.IIhm;
import fr.istic.interf.IMoteur;

public class Lanceur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IIhm ihm;
		IController controleur;
		IHorloge horloge;
		IMoteur metronome;

		ICommande start;
		ICommande stop;
		ICommande tic;
		ICommande marquerTemps;
		ICommande marquerMesure;
		ICommande incMesure;
		ICommande decMesure;

		ihm = new Ihm();

		horloge = new Horloge(new Timer());
		metronome = new Metronome(6, horloge);
		metronome.setTempo(120);
		controleur = new Controller(ihm, metronome);
		metronome.setCmdMarquerMesure(new MarquerMesure(controleur));
		metronome.setCmdMarquerTemps(new MarquerTemps(controleur));

		controleur.start();

	}
}
