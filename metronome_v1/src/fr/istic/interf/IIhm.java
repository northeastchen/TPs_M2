package fr.istic.interf;

public interface IIhm {
	public void flasherLedTemps();

	public void flasherLedMesure();

	public void emettreSon();

	// Met à jour un afficheur selon l'état du moteur
	public void mettreAjourAfficheur(boolean etat, String value);

	public void setValueMolette(float t);

	public float getValueMolette();
}
