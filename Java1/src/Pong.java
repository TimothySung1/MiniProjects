import java.awt.*;
import java.awt.event.*;

public class Pong extends Panel implements Runnable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// size of the game area
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    // num of frames per second
    private static final int FRAME_RATE = 40;

    private Thread thread;
    private Image img;
    private Graphics g;

    private Ball ball;
    private Paddle paddle;
    
    public void init() {
        ball = new Ball();
        paddle = new Paddle();
        img = createImage(WIDTH,HEIGHT);
        g = img.getGraphics();

        enableEvents(MouseEvent.MOUSE_MOVED | MouseEvent.MOUSE_PRESSED);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public void processMouseMotionEvent(MouseEvent e) {
        // move the paddle if the mouse is moved.
        paddle.move(e.getX());
    }

    public void processMouseEvent(MouseEvent e) {
        // move the ball if mouse is clicked.
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            ball.start_moving();
        }
    }
    
    public void run() {
        try 
        {
            while (true) 
            {
                ball.move_one_step(paddle);
                g.setColor(Color.black);
                g.fillRect(0, 0, WIDTH, HEIGHT);
                ball.draw(g);
                paddle.draw(g);
                repaint();
                Thread.sleep(1000/FRAME_RATE);
            }
        } 
        catch (InterruptedException ie) 
        { 
            System.err.print("Interrupted!\n" + ie);
        }
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public static void main(String args[]) {
        Frame frame = new Frame();
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
        public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
            };
         });

        Pong pong = new Pong();
        pong.setSize(WIDTH, HEIGHT);
        frame.add(pong);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT+20);
        frame.setVisible(true);
        pong.init();
        pong.start();
    }
}
