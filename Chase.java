/********************
 * Type: Chase		*
 * Type of Element	*
 * Red circle		*
 ********************/
public class Chase extends Element {

	public Chase() {
		//Builds an element + adds shape and size
		super();
		s = new Circle(MIN_SIZE, MAX_SIZE);
	}

	// moves the current element towards the mouse
	// x,y represent the direction of the mouse
	@Override
	public void move(int x, int y) {
		//move towards mouse
		double newX = location.getX()+(x*speed);
		double newY = location.getY()+(y*speed);
		
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

	// When hits the mouse - end the game
	@Override
	public boolean onHitTarget() {
		// Game over!
		return true;
	}
	
}
