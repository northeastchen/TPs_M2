import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public abstract class Dessin extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	
	private int newx1;
	private int newy1;
	
	private int dx;
	private int dy;
	
	private Color color;
	
	public Dessin() {
		
		setOpaque(false);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				newx1 = e.getX();
				newy1 = e.getY();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {

				if(contains(e.getX(), e.getY())) {
					dx = e.getX() - newx1;
					dy = e.getY() - newy1;
					moveDessin();
				}
			}
		});
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public void moveDessin() {
		setLocation(getX() + dx, getY() + dy);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
	}
	
//	@Override
//	public boolean contains(int x, int y) {
//		return super.contains(x, y);
//	}
}
