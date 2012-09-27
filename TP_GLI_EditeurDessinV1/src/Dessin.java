import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Dessin extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private int newx1;
	private int newy1;
	
	private int dx;
	private int dy;
	
	public Dessin(int x, int y) {
		setBackground(Color.YELLOW);
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
				dx = e.getX() - newx1;
				dy = e.getY() - newy1;
				//x1 = e.getX();
				//y1 = e.getY();
				moveDessin();
			}
		});
	}
	
	public void moveDessin() {
		setLocation(getX() + dx, getY() + dy);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,getWidth()-1,getHeight()-1);
	}
}
