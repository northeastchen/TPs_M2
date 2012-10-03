import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;


public class Ellipse extends Dessin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected RectangularShape bigGeometrie;
	
	public Ellipse(){
		super();
		bigGeometrie = new Ellipse2D.Double();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillOval(0,0,getWidth()-1,getHeight()-1);
	}
	
	@Override
	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		bigGeometrie.setFrame(0, 0, getWidth(), getHeight());
	}
	
	@Override
	public boolean contains(int x, int y) {
		return (bigGeometrie.contains(x, y));
	}
}
