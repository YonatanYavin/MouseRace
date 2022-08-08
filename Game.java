import java.awt.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/****************************************************************
 * This class is in charge of running the whole game			*
 ****************************************************************/
public class Game extends Canvas {
	private static final int NUM_ELEMENTS=3;
	private Element[] e;	// array of all elements
	private Points p;		// used to count points
	
	// thread for counting points in BG every second
	Thread tPoints = new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				p.add(1);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	});
	
	public Game() {	
		//set up all elements
		e = new Element[NUM_ELEMENTS];
		e[0] = new Chase();
		e[1] = new Escape();
		e[2] = new Random();
		
		//call points class - using singleton to avoid duplicates of this class
		p = Points.getInstance();
		p.reset();	//reset points to 0
		
		//open game window
		JFrame f=new JFrame("Game");  
        f.add(this);  
        f.setSize(Element.MAX_WIDTH+15,Element.MAX_HEIGHT+40);  
        f.setVisible(true); 
	}
	
	
	//launches at start through Canvas Class
	//this function is where the game occurs, and controls all the graphics 
	public void paint(Graphics g) {
		//set BG
		g.setColor(Color.white);
		g.fillRect(0, 0, Element.MAX_WIDTH, Element.MAX_HEIGHT);
		
				
		//print all elements in there random starting positions
		for(int x=0;x<NUM_ELEMENTS;x++) {
			e[x].s.draw(g, e[x].location);
		}
		
		//show points on canvas
		p.drawUpdatePoints(g);
		tPoints.start();	//start counting points
		
		boolean gameOver = false;	//flag to determine when the game is over
		int i=0;					//index of current element
		
		//loop to next element until the game is over
		while(!gameOver) {
			// move each element and draw it
			Point oldLocation = (Point) e[i].location.clone();
			gameOver = e[i].step(g);
			p.drawUpdatePoints(g);	//update points
			e[i].s.draw(g, oldLocation, e[i].location);
			i++;
			// when finished with all elements - start from the beginning
			if(i==NUM_ELEMENTS) {
				i=0;
			}
			try {
				// timeout to slow down speed
				TimeUnit.MILLISECONDS.sleep(9);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		//end of game - stop counting point and show updated count
		tPoints.stop();
		p.drawUpdatePoints(g);
		g.setFont(new Font("Ink Free",Font.BOLD,50));
		g.setColor(Color.blue);
		g.drawString("Game Over!", Element.MAX_WIDTH/2-150, Element.MAX_HEIGHT/2-50);
	}
}