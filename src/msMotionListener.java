import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;


public class msMotionListener extends Applet implements MouseMotionListener, MouseListener{
	
	private Graphics globalGraphics;
	private  int mouseButton;
	
	public void init()
	{
		this.addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) 
	{
		this.setSize(new Dimension(500, 500));
		globalGraphics = g.create();
	}
	
	public void drawCircle(int x, int y, int width, int height)
	{
		globalGraphics.setColor(getRandomColor());
		Ellipse2D circle = new Ellipse2D.Double((double)x, (double)y, (double)width, (double)height);
		Graphics2D g2 = (Graphics2D) globalGraphics;
		g2.fill(circle);
	}
	
	public void drawSquare(int x, int y, int width, int height)
	{
		globalGraphics.setColor(getRandomColor());
		globalGraphics.fillRect(x, y, width, height);
	}
	
	public Color getRandomColor()
	{
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		
		return new Color(r, g, b);
	}

	public void mouseAction(MouseEvent e)
	{
		int mouseX = e.getX();
		int mouseY = e.getY();
		mouseButton = e.getButton();
		
		if(mouseButton == MouseEvent.BUTTON3)
		{
			drawSquare(mouseX, mouseY, 40, 40);
		}
		else
		{
			drawCircle(mouseX, mouseY, 10, 10);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseButton = e.getModifiers();
		if(mouseButton == MouseEvent.BUTTON3_MASK)
			System.out.println("Right Click!");
		mouseAction(e);
		
		//drawCircle(mouseX, mouseY, 5, 5);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseButton = e.getButton();
		mouseAction(e);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
