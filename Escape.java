import java.awt.Point;

/********************
 * Type: Escape		*
 * Type of Element	*
 * Green square		*
 ********************/
public class Escape extends Element {
	
	public Escape() {
		//Builds an element + adds shape and size
		super();
		s = new Square(MIN_SIZE, MAX_SIZE);
	}

	// moves the current element away from the mouse
	// x,y represent the direction of the mouse
	@Override
	public void move(int x, int y) {
		//move away from mouse
		double newX = location.getX()-(x*speed);
		double newY = location.getY()-(y*speed);
		
		//if wants to move off screen - stay at last spot on the screen
		if(newX > MAX_WIDTH - s.size) {newX = MAX_WIDTH - s.size;}
		if(newX < 0) {newX = 0;}
		if(newY > MAX_HEIGHT - s.size) {newY = MAX_HEIGHT - s.size;}
		if(newY < 0) {newY = 0;}
		
		//set final location
		location.setLocation(newX, newY);
	}
	
	// returns the direction towards the mouse: 1, -1, 0
	@Override
	protected int direction2mouse(double myL, double mouseL, int axis) {
		// consider a hit if anywhere in length of size
		if ((mouseL >= myL) && (mouseL <= (myL+s.size)))
			return 0;
		// if no hit - determine direction of mouse
		return (int) Math.signum(mouseL-myL);
	}

	//When hits the mouse - add 5 points + move to random location
	@Override
	public boolean onHitTarget() {
		p.add(5);	// add 5 points
		java.util.Random rand = new java.util.Random();
		location = new Point(rand.nextInt(MAX_WIDTH), rand.nextInt(MAX_HEIGHT));	//move to random location
		return false;
	}
	
}
