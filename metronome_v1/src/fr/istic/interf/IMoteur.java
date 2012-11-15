package fr.istic.interf;

public interface IMoteur {
	public void start();
	public void stop();
	public void decMesure();
	public void incMesure();
	public float getTempo();
	public void setTempo(float t);
	public void setCmdMarquerTemps(ICommande c);
	public ICommande getCmdMarquerTemps();
	public void setCmdMarquerMesure(ICommande c);
	public ICommande getCmdMarquerMesure();
	public void setEtatMarche(Boolean b);
	public boolean getEtatMarche();
	public void tic();
}
