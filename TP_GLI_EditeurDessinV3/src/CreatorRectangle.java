
public class CreatorRectangle implements CreatorDessin {

	@Override
	public Dessin creerDessin() {
		return new Rectangle();
	}

}
