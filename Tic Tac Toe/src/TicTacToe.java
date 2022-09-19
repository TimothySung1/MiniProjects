import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame {
	private JPanel panel;
	private ButtonXO[][] buttons = new ButtonXO[3][3];

	public TicTacToe() {
		panel = new JPanel(new GridLayout(3, 3));
		this.setTitle("Tic Tac Toe");
		this.setSize(450, 450);
		this.setResizable(false);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				panel.add(buttons[i][j] = new ButtonXO(i, j, this));
			}
		}
		panel.setBackground(Color.WHITE);
		this.add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void resetBoard() {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].reset();
			}
		}
	}
}
