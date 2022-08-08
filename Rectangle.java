import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/****************************
 * Rectangle type of Shape	*
 ****************************/
public class Rectangle extends Shape {

	//creates a rectangle in a random size
	public Rectangle(final int MIN_SIZE, final int MAX_SIZE) {
		super(MIN_SIZE, MAX_SIZE);
	}

	//draws a rectangle in a given point
	@Override
	public void draw(Graphics g, Point p) {
		g.setColor(Color.black);
		g.fillRect(p.x, p.y, size*2, size);
	}
	
	//move the rectangle from previous point to a new given point	
	@Override
	public void draw(Graphics g, Point oldP, Point newP) {
		//removes the previous location of rectangle 
		g.setColor(Color.white);
		g.fillRect(oldP.x, oldP.y, size*2, size);
		//draws a rectangle in a new given point
		draw(g, newP);
	}
}
