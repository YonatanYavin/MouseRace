import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/****************************************************************
 * This class is where the game begins							*
 * In charge of opening screen and sends to game after click	*
 ****************************************************************/
public class StartGame extends Canvas implements MouseListener {
	
	private Game game;
	
	public StartGame() {
		//builds the opening window
		JFrame f=new JFrame("Start Game");  
        f.add(this);  
        f.setSize(Element.MAX_WIDTH,Element.MAX_HEIGHT);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
        
        //waits for click to launch game
        addMouseListener(this);
	}
	
	//launches at start through Canvas Class
	public void paint(Graphics g) {
		//prints on screen "start"
		g.setFont(new Font("Ink Free",Font.BOLD,50));
		g.setColor(Color.green);
		g.drawString("Start", Element.MAX_WIDTH/2-75, Element.MAX_HEIGHT/2-50);
	}
	
	//On mouse click launch game
	@Override
	public void mouseClicked(MouseEvent e) {game = new Game();}
	
	//The rest of the override functions not used
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	
	
	//main
	public static void main(String[] args) {
		//launch opening window
		new StartGame();
	}

}
