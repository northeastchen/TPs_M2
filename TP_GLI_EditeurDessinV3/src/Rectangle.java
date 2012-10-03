import java.awt.Graphics;


public class Rectangle extends Dessin {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rectangle(){
		super();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0,0,getWidth()-1,getHeight()-1);
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y);
	}
	
	
}
