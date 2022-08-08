import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/************************
 * Circle type of Shape	*
 ************************/
public class Circle extends Shape {

	//creates a circle in a random size
	public Circle(final int MIN_SIZE, final int MAX_SIZE) {
		super(MIN_SIZE, MAX_SIZE);
	}

	//draws a circle in a given point
	@Override
	public void draw(Graphics g, Point p) {
		g.setColor(Color.red);
		g.fillOval(p.x, p.y, size, size);
	}

	//move the circle from previous point to a new given point
	@Override
	public void draw(Graphics g, Point oldP, Point newP) {
		//removes the previous location of circle 
		g.setColor(Color.white);
		g.fillOval(oldP.x, oldP.y, size, size);
		//draws a circle in a new given point
		draw(g, newP);
	}
	
}
