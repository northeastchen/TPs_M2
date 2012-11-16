package TAA.TP4.client;

import TAA.TP4.store.IStore;

public class Client implements IClient {

	private IStore store;

	public static boolean ok = true;

	public Client(IStore store) {
		this.store = store;
	}

	public void run() {
		store.buy(5);
		store.buy(3);
	}

	public void setOk(boolean b) {
		ok = b;
	}
}
