import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Start {

	private static void createGui() {
		JFrame frame = new JFrame("Print Messages");
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel(new GridBagLayout());
		JPanel btnpanel = new JPanel(new GridBagLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Test Label");
		JTextField text = new JTextField("");
		text.setToolTipText("Type any message that you want to print");
		String[] options = {"Clear", "Copy", "Cut"};
		JComboBox<String> combobox = new JComboBox<>(options);
		JCheckBox checkbox = new JCheckBox("Save");
		checkbox.setToolTipText("Currently does nothing");
		JSlider slider = new JSlider();
		JRadioButton redbutton = new JRadioButton("Red");
		redbutton.setSelected(true);
		redbutton.setToolTipText("Disable the text field");
		JRadioButton greenbutton = new JRadioButton("Green");
		JRadioButton bluebutton = new JRadioButton("Blue");
		ButtonGroup colorgroup = new ButtonGroup();
		colorgroup.add(redbutton);
		colorgroup.add(greenbutton);
		colorgroup.add(bluebutton);
		text.setSize(100, 20);
		text.setPreferredSize(new Dimension(100, 20));
		text.setMinimumSize(new Dimension(100, 20));
		JButton button1 = new JButton("Print Message");
		button1.setToolTipText("Prints the message in the text field");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String msg = "The message is: " + text.getText();
				String option = (String)combobox.getSelectedItem();
				JOptionPane.showMessageDialog(null, msg + " " + option, "Your Message", JOptionPane.ERROR_MESSAGE);
				text.setText("");
			}
		});
		redbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setEditable(false);
			}
		});
		greenbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setEditable(true);
			}
		});
		bluebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setEditable(false);
			}
		});
		frame.setSize(500, 500);
		frame.setMinimumSize(new Dimension(500, 500));
		//frame.setLayout(new FlowLayout());
		//frame.setLayout(new GridLayout(0, 3));
		frame.setLayout(new BorderLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(10, 10, 10, 10);
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(label, constraints);
		constraints.gridx = 1;
		constraints.gridy = 0;
		panel.add(text, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		btnpanel.add(button1);
		panel2.add(combobox, constraints);
		constraints.gridx = 1;
		constraints.gridy = 1;
		panel2.add(checkbox, constraints);
		constraints.gridx = 2;
		constraints.gridy = 1;
		panel2.add(redbutton, constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		panel2.add(greenbutton, constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		panel2.add(bluebutton, constraints);
		constraints.gridx = 2;
		constraints.gridy = 2;
		panel2.add(slider, constraints);
		constraints.gridx = 3;
		constraints.gridy = 2;
		frame.getContentPane().add(panel, BorderLayout.PAGE_START);
		frame.getContentPane().add(panel2, BorderLayout.CENTER);
		frame.getContentPane().add(btnpanel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}

	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createGui();
			}
		});
	}
}
