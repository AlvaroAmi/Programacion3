package practica0;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	public int  direccion;
	public JLabelCoche() 
	{
		
		ImageIcon ImageIcon = new ImageIcon("bin/practica0/coche.png");
		Image image = ImageIcon.getImage();
		ImageIcon = new ImageIcon(image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH));
		setIcon(ImageIcon);
	}
	
	protected void getDireccion(int direccion) {
		this.direccion = direccion;
		}

	protected void paintComponent(Graphics gr) {
	    Image image = ((ImageIcon)getIcon()).getImage();
	    Graphics2D g2 = (Graphics2D)gr;   
	    g2.rotate(Math.toRadians(direccion)+Math.toRadians(90), 50, 50);
	    g2.drawImage(image, 0, 0, 100, 100, null);
	  }
	
	
}
