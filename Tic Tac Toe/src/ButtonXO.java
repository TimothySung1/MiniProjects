import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ButtonXO extends JButton implements ActionListener {
	private static boolean gameOver;
	private static byte turns;
	private static int[][] board = new int[3][3];

	private boolean taken;
	private int posX, posY;
	// private Graphics paintContour;
	private ImageIcon x, o;
	private TicTacToe ticTacToe;
	
	public void reset() {
		taken = false;
		board[posX][posY] = 0;
		this.setIcon(null);
	}

	public static void resetBoard() {
		turns = 0;
		gameOver = false;
	}
	
	public static byte getTour() {
		return turns;
	}

	public ButtonXO(int posX, int posY, TicTacToe ticTacToe) {
		reset();
		this.ticTacToe = ticTacToe;
		x = new ImageIcon(this.getClass().getResource("x.png"));
		o = new ImageIcon(this.getClass().getResource("o.png"));
		this.posX = posX;
		this.posY = posY;
		this.setOpaque(false);
		this.addActionListener(this);
		this.setVisible(true);
		switch (posX) {
		case 0:
			switch (posY) {
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
				break;
			}
			break;
		case 1:
			switch (posY) {
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
				break;
			}
			break;
		case 2:
			switch (posY) {
			case 1:
				this.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
				break;
			default:
				this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
				break;
			}
			break;
		}
		this.setContentAreaFilled(false);
		this.setOpaque(false);
	}

	private void play(int player) {
		board[posX][posY] = player;
	}

	private void check() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1
					|| board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1) {
				new GameOver("O Won!", ticTacToe);
				gameOver = true;
				break;
			} else if (board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2
					|| board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2) {
				new GameOver("X Won!", ticTacToe);
				gameOver = true;
				break;
			}
		}
		if (board[0][0] == 2 && board[2][2] == 2 && board[1][1] == 2
				|| board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2) {
			new GameOver("X Won!", ticTacToe);
			gameOver = true;
		} else if (board[0][0] == 1 && board[2][2] == 1 && board[1][1] == 1
				|| board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1) {
			new GameOver("O Won!", ticTacToe);
			gameOver = true;
		}
		if (turns == 9 && !gameOver) {
			new GameOver("Tie Game!", ticTacToe);
			gameOver = true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (!taken && !gameOver) {
			turns++;
			switch (turns % 2) {
			case 0:
				this.setIcon(o);
				play(1);
				break;
			case 1:
				this.setIcon(x);
				play(2);
				break;
			}
			check();
		}
		taken = true;
	}
}
