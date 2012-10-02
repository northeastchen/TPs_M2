import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;


public class EllipseEmpty extends Dessin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected RectangularShape smallGeometrie;
	protected RectangularShape bigGeometrie;
	
	public EllipseEmpty(){
		super();
		smallGeometrie = new Ellipse2D.Double();
		bigGeometrie = new Ellipse2D.Double();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(0,0,getWidth()-1,getHeight()-1);
	}
	
	@Override
	public void setBounds(int x, int y, int w, int h) {
		super.setBounds(x, y, w, h);
		bigGeometrie.setFrame(-5, -5, getWidth() + 10, getHeight() + 10);
		smallGeometrie.setFrame(5, 5, getWidth() - 10, getHeight() - 10);
	}

	@Override
	public boolean contains(int x, int y) {
		return (bigGeometrie.contains(x, y) && !smallGeometrie.contains(x, y));
	}
	
}
