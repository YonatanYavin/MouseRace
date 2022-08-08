import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/************************************************
 * Points - used for counting points			*
 * Built using singleton DP to avoid duplicates	*
 ************************************************/
public class Points {
    private static volatile Points p  = null;
    private int points;
 
    private Points() {points = 0;}

    // The public "constructor" 
    // creates it the first time and then uses the same instance in future times
    public static Points getInstance() {
        if (p == null) {
            // To make thread safe
            synchronized (Points.class) {
                // check again since multiple threads can reach above step
                if (p==null) {
                    p = new Points();
                }
            }
        }
        return p;
    }
    
    // reset count to 0
    public void reset() {
    	points = 0;
    }
    
    // add more points
    public void add(int s) {
    	points += s;
    }
    
    // return current points
    public int getPoints() {
    	return points;
    }
    
    // draw the current point count on the screen 
 	public void drawUpdatePoints(Graphics g) {
 		//remove previous point count
 		g.setColor(Color.white);
 		g.fillRect(0, Element.MAX_HEIGHT-25, Element.MAX_WIDTH/4, 25);
 		//draw updated point count
 		g.setFont(new Font("Ink Free",Font.BOLD,25));
 		g.setColor(Color.blue);
 		g.drawString("Score: "+points, 0, Element.MAX_HEIGHT-5);
 	}
 	
}
