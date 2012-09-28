import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Dessin {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Rectangle(int x, int y){
		super(x,y);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,getWidth()-1,getHeight()-1);
	}
	
	
}
