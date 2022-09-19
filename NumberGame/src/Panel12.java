
//panel
//Name______________________________ Date_____________
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel12 extends JPanel {
	private Display12 display;
	private JLabel label;
	private JButton reset;
	private int guess, target, tries;

	private int wins, total, currentStreak, longestStreak;
	private JLabel winsLabel, currentStreakLabel, longestStreakLabel;
	
	public Panel12() {
		tries = 4;
		target = (int) (Math.random() * 25 + 1);

		setLayout(new BorderLayout());

		display = new Display12(new Listener1());
		add(display, BorderLayout.CENTER);

		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		add(north, BorderLayout.NORTH);
		winsLabel = new JLabel("Wins: " + wins + "/" + total + "(---%)");
		currentStreakLabel = new JLabel("Current Streak: " + currentStreak);
		longestStreakLabel = new JLabel("Longest Streak: " + longestStreak);
		north.add(winsLabel);
		north.add(currentStreakLabel);
		north.add(longestStreakLabel);

		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		add(south, BorderLayout.SOUTH);
		label = new JLabel("You have 4 tries to guess the number.");
		south.add(label);
		reset = new JButton("Reset");
		reset.setEnabled(false);
		reset.addActionListener(new Listener2());
		south.add(reset);
	}

	private class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			guess = Integer.parseInt(source.getText());
			tries = tries - 1;
			if (guess == target)
				displayWinner();
			else if (tries == 0)
				displayLoser();
			else if (guess > target)
				displayTooHigh();
			else
				displayTooLow();
		}
	}

	private class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			display.reset();
			tries = 4;
			target = (int) (Math.random() * 25 + 1);
			label.setText("You have 4 tries to guess the number.");
			reset.setEnabled(false);
		}
	}

	private void displayWinner() {
		/************************/
		label.setText("You got it!");
		reset.setEnabled(true);
		currentStreak++;
		wins ++;
		if(currentStreak > longestStreak) {longestStreak = currentStreak;}
		total++;
		int winP = ((100 * wins) / total);
		winsLabel.setText("Wins: " + wins + "/" + total + "(" + winP + "%)");
		currentStreakLabel.setText("Current Streak: " + currentStreak);
		longestStreakLabel.setText("Longest Streak: " + longestStreak);
		display.displayWinner(target);
		/************************/
		// Set label text to "You got it!"
		// Enable reset button
		// Keep streak up to date and total games
		// Update all
		// E.g. set text to "Wins: " + wins + "/" + total + "(" + winP + "%)" for winsLabel
	}

	private void displayLoser() {
		/************************/
		label.setText("You lose!");
		reset.setEnabled(true);
		currentStreak = 0;
		total++;
		int winP = ((100 * wins) / total);
		winsLabel.setText("Wins: " + wins + "/" + total + "(" + winP + "%)");
		currentStreakLabel.setText("Current Streak: " + currentStreak);
		longestStreakLabel.setText("Longest Streak: " + longestStreak);
		display.displayLoser(target);
		/************************/
		// Set text to "You lose!"
		// Enable reset button
		// Keep streak up to date and total games
		// Update all
		// E.g. set text to "Wins: " + wins + "/" + total + "(" + winP + "%)" for winsLabel
	}

	private void displayTooHigh() {
		/************************/
		label.setText("Too high - " + tries + " guesses left");
		display.displayTooHigh(guess);
		/************************/
		// Set text to "Too high - " + tries + " guesses left"
	}

	private void displayTooLow() {
		/************************/
		label.setText("Too low - " + tries + " guesses left");
		display.displayTooLow(guess);
		/************************/
		// Set text to "Too low - " + tries + " guesses left"
	}
}
