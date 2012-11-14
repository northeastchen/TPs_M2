package fr.istic.interf;

public interface IObservable {
	public void notifyObservers();
	public void registerObserver(IObserver o);
	public void unregisterObserver(IObserver o);
}
