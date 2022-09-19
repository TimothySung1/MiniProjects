
//display
//Name______________________________ Date_____________
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Display12 extends JPanel {
	private JButton[] button;
	
	
	public Display12(ActionListener lis) {
		setLayout(new GridLayout(5, 5, 5, 5));

		button = new JButton[25];
		for (int x = 0; x < 25; x++) {
			button[x] = new JButton("" + (x + 1));
			button[x].addActionListener(lis);
			button[x].setHorizontalAlignment(SwingConstants.CENTER);
			button[x].setFont(new Font("Serif", Font.BOLD, 20));
			button[x].setBackground(Color.yellow);
			add(button[x]);
		}
	
	}

	public void reset() {
		// Make all buttons have correct numbers on them.
		// Make them enabled with yellow background
		// And black foreground.
		/************************/
		
		for (int x = 0; x < 25; x++) {
			button[x].setText("" + (x + 1));
			button[x].setBackground(Color.yellow);
			button[x].setForeground(Color.black);
			button[x].setEnabled(true);
		}
		/************************/

	}

	
	public void displayWinner(int target) {
		// Make winning button green background.
		// Disable all buttons.
		/************************/
		button[target - 1].setBackground(Color.green);
		for(int x = 0; x < button.length; x++) {
			button[x].setEnabled(false);
		}
		/************************/
	}

	
	
	public void displayLoser(int target) {
		// Make correct button black background
		// and grey foreground.
		// Disable all buttons.
		/************************/
		button[target - 1].setBackground(Color.black);
		button[target - 1].setForeground(Color.gray);
		for(int x = 0; x < button.length; x++) {
			button[x].setEnabled(false);
		}
		/************************/
	}

	public void displayTooHigh(int guess) {
		// Make all buttons that don't make sense
		// disabled and colored red with no text.
		/************************/
		for (int x = guess - 1; x < button.length; x++) {
			button[x].setEnabled(false);
			button[x].setBackground(Color.red);
			button[x].setText("");
		}
		/************************/
	}

	public void displayTooLow(int guess) {
		// Make all buttons that don't make sense
		// disabled and colored red with no text.
		/************************/
		for (int x = guess; x > 0; x--) {
			button[x - 1].setEnabled(false);
			button[x - 1].setBackground(Color.red);
			button[x - 1].setText("");
		}
		/************************/
	}
}
