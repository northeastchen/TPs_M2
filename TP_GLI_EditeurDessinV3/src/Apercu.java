import java.awt.Color;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;


public class Apercu extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private Dessin d;
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("foreground")){
			setForeground((Color) evt.getNewValue());
		}
		else {
			this.d = ((CreatorDessin) evt.getNewValue()).creerDessin();
		}
		d.setForeground(getForeground());
		removeAll();
		add(d);
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		d.setBounds((int)(getWidth()*0.2), (int)(getHeight()*0.05), (int)(getWidth()*0.6), (int)(getHeight()*0.2));
	}
}
