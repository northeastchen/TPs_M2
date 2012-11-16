package TAA.TP4.store;

public class Store implements IStore {

	public void buy(int article) {
		this.print(article);
	}

	public void print(int article) {
		System.out.println("Vous avez acheté le produit " + article);
	}
}
