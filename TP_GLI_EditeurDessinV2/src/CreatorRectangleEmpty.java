
public class CreatorRectangleEmpty implements CreatorDessin {

	@Override
	public Dessin creerDessin() {
		return new RectangleEmpty();
	}

}
