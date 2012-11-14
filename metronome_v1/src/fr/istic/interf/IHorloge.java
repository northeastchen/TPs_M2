package fr.istic.interf;

public interface IHorloge {
	public void activerPeriodiquement(ICommande cmd, float periodeEnSecodes);
	public void activerApresDelai(ICommande cmd, float delaiEnSecondes);
	public void desactiver(ICommande cmd);
}
