import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.lang.Math;

/************************************
 * Element - part of the bridge DP	*
 * Parent of all elements			*
 ************************************/
public abstract class Element {
	// set all min and max settings
	protected static final int MAX_SIZE=40;
	protected static final int MIN_SIZE=20;
	protected static final int MAX_SPEED=10;
	public static final int MAX_WIDTH=1000;
	public static final int MAX_HEIGHT=650;
	
	protected Points p;			// used to count points
	protected Shape s;			// determines the shape of the element 
	protected int speed;		// determines the speed of the element
	protected Point location;	// current location of element
	
	public Element() {
		java.util.Random rand = new java.util.Random();
		this.speed = 1 + rand.nextInt(MAX_SPEED);	//random speed
		this.location = new Point(rand.nextInt(MAX_WIDTH), rand.nextInt(MAX_HEIGHT));	//random location
		this.p = Points.getInstance();	//call points class - using singleton to avoid duplicates of this class
	}
	
	// returns the direction towards the mouse: 1, -1, 0 
	protected abstract int direction2mouse(double myL, double mouseL, int axis);
	
	// each type of element will execute moving differently
	public abstract void move(int x, int y);

	// each type of element will execute a hit differently
	public abstract boolean onHitTarget();
	
	// collects info to determine where to move
	public boolean step(Graphics g) {
		//get mouse location 
		PointerInfo pi = MouseInfo.getPointerInfo();
        if (pi != null) {
            final Point loc = pi.getLocation();
            //check direction of mouse
            int x = direction2mouse(location.getX(), loc.getX(), 0);
            int y = direction2mouse(location.getY(), loc.getY(), 1);
            //if in exact location of mouse - run onHitTarget
            if (Math.abs(x)+Math.abs(y) == 0) {
            	return onHitTarget();
            }
            //else continue moving
            else {
            	Point oldLocation = (Point) location.clone();
            	move(x, y);
            	s.draw(g, oldLocation, location);
            	return false;
            }
        }
		return false;
	}
	
}
