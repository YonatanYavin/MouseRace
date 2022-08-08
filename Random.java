/********************
 * Type: Random		*
 * Type of Element	*
 * Black rectangle	*
 ********************/
public class Random extends Element {
	private int dirX, dirY;
	
	public Random() {
		//Builds an element + adds shape and size + chooses direction
		super();
		this.s = new Rectangle(MIN_SIZE, MAX_SIZE);
		dirX = -2;
		dirY = -2;
		chooseDir();
	}
	
	private void chooseDir() {
		//different direction options
		int[] dir1 = {-1, 0, 1};
		int[] dir2 = {-1, 0};
		int[] dir3 = {0, 1};
		int[] dir4 = {-1, 1};
		int[] dir = null;
		int randomIndex;
		
		java.util.Random rand = new java.util.Random();
		//if going left or right needs to go the opposite direction or stay
		if(dirX == -1) {dir = dir3;}
		else if(dirX == 1) {dir = dir2;}
		else {dir = dir1;}
		
		//choose randomly direction on x
		randomIndex = rand.nextInt(dir.length);
		dirX = dir[randomIndex];
		
		if(dirX != 0) {
			//if going up or down needs to go the opposite direction or stay
			if(dirY == -1) {dir = dir3;}
			else if(dirY == 1) {dir = dir2;}
			else {dir = dir1;}
			randomIndex = rand.nextInt(dir.length);
			dirY = dir[randomIndex];
		}
		else {
			//if going just up or down needs to go the opposite direction
			if(dirY == -1) {dirY = 1;}
			else if(dirY == 1) {dirY = -1;}
			else {
				randomIndex = rand.nextInt(dir4.length);
				dirY = dir[randomIndex];
			}
		}
	}
	
	// moves the current element in a straight line
	// x,y represent the direction of the mouse - not needed for this element
	@Override
	public void move(int x, int y) {
		//move in a straight line
		double newX = location.getX()+(dirX*speed);
		double newY = location.getY()+(dirY*speed);
		
		//if wants to move off screen - stay at last spot on the screen
		//also when getting to edge switch directions
		if(newX <= 0) {
			newX = 0;
			chooseDir();
		}
		if(newY <= 0) {
			newY = 0;
			chooseDir();
		}
		if(newX >= MAX_WIDTH - s.size*2) {
			newX = MAX_WIDTH - s.size*2;
			chooseDir();
		}
		if(newY >= MAX_HEIGHT - s.size) {
			newY = MAX_HEIGHT - s.size;
			chooseDir();
		}
		
		//set final location
		location.setLocation(newX, newY);
	}
	
	// returns the direction towards the mouse: 1, -1, 0
	protected int direction2mouse(double myL, double mouseL, int axis) {
		// if long side of the rectangle - consider hit if anywhere in double the length of size
		if(axis==0) {
			if ((mouseL >= myL) && (mouseL <= (myL+(2*s.size))))
				return 0;
		} 
		// else - consider a hit if anywhere in length of size
		else {
			if ((mouseL >= myL) && (mouseL <= (myL+s.size)))
				return 0;
		}
		// if no hit - determine direction of mouse
		return (int) Math.signum(mouseL-myL);
	}

	//When hits the mouse - end the game
	@Override
	public boolean onHitTarget() {
		// Game over!
		return true;
	}
}
