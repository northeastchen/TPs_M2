import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class ZoneDeDessin extends JPanel {

	private static final long serialVersionUID = 1L;

	private Dessin currentD;
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	

	public ZoneDeDessin() {

		setBackground(Color.CYAN);

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				beginRect(e.getPoint());
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
				moveRect(e.getPoint());
			}
		});
		
		setLayout(null);

	}

	public void beginRect(Point p) {
		x1 = x2 = p.x;
		y1 = y2 = p.y;
		currentD = new Rectangle(x1, y1);
		add(currentD);
	}

	public void moveRect(Point p) {
		x2 = p.x;
		y2 = p.y;
		currentD.setBounds(Math.min(x2, x1),
				Math.min(y2, y1),
				Math.abs(x2 - x1),
				Math.abs(y2 - y1));
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.setColor(Color.YELLOW);
//		g.fillRect(Math.min(currentD.x1, currentD.x2),
//				Math.min(currentD.y1, currentD.y2),
//				Math.abs(currentD.x2 - currentD.x1),
//				Math.abs(currentD.y2 - currentD.y1));
	}

}
