import java.awt.Graphics;
import java.awt.Point;

/************************************
 * Shape - part of the bridge DP	*
 ************************************/
public abstract class Shape {
	protected int size;	//size of shape
	
	public Shape(final int MIN_SIZE, final int MAX_SIZE) {
		//sets a random size for the shape
		java.util.Random rand = new java.util.Random();
		this.size = MIN_SIZE + rand.nextInt(MAX_SIZE-MIN_SIZE);
	}
	
	//draw without erasing previous spot - implemented for each shape differently
	public abstract void draw(Graphics g, Point p);
	
	//draw with erasing previous spot - implemented for each shape differently
	public abstract void draw(Graphics g, Point oldP, Point newP);
}
