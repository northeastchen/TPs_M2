package fr.istic.interf;


public interface IAfficheur {
	public void setAfficheurTempo(float t);

	public String getAfficheurTempo();

	public void setAfficheurEtat(String s);

	public ILed getled1();

	public ILed getled2();
}
