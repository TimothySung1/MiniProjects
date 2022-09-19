package PizzaOrdering;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class OrderPizza extends JPanel{
	
	private JFrame frame;
	private JLabel title;
	private JPanel top;
	private JPanel center;
	private JPanel bottom;
	private JTextPane instructionsSize;
	private JTextPane instructionsToppings;
	
	private String size;
	private double price = 0;
	private int topPrice = 0;
	private int sizePrice = 0;
	private int wingPrice = 0;
	private HashMap<String, Integer> toppingsMap;
	
	private List<String> selectedToppings;
	private JLabel pricePizza;
	private boolean click = false;
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private JLabel pizzaSummary = new JLabel("<html>Your pizzas:<br></html>");
	private JLabel showToppings = new JLabel("Your toppings selected: ");
	private JCheckBox wings = new JCheckBox("Add $5 side of hot wings");
	private JRadioButton small = new JRadioButton("Small - $7");
	private JRadioButton medium = new JRadioButton("Medium - $9");
	private JRadioButton large = new JRadioButton("Large - $11");
	private JRadioButton exLarge = new JRadioButton("Extra Large - $13");
		
	
	public OrderPizza() {
		frame = new JFrame("Pizza Hut");
		top = new JPanel();
		center = new JPanel();
		bottom = new JPanel();
		title = new JLabel("Order Pizza Here");
		instructionsSize = new JTextPane();
		instructionsToppings = new JTextPane();
		selectedToppings = new ArrayList<String>();
		
		pricePizza = new JLabel("The price of your pizza is $" + price);
		format();
	}
	
	public void format() {
		frame.setLayout(new BorderLayout());
		
		formatTop();
		frame.add(top, BorderLayout.PAGE_START);
		formatCenter();
		frame.add(center, BorderLayout.LINE_START);
		formatBottom();
		frame.add(bottom, BorderLayout.PAGE_END);
		
		
		//frame.setBackground(new Color(220, 220, 100));
		//frame.setForeground(new Color(220, 220, 100));
		frame.pack();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	public void formatTop() {
		top.setLayout(new BorderLayout());
		instructionsSize.setText("Choose a size for your pizza. Available sizes are:\nSmall - $7\nMedium - $9\nLarge - $13\n Extra Large - $15");
		instructionsToppings.setText("Choose from these available toppings: \nEggplant, Green Peppers, Hot Peppers, Pepperoni, Sausage, Mushrooms, Anchovies\nPick up to 7 for each. $1 per topping.");
		instructionsSize.setEditable(false);
		instructionsToppings.setEditable(false);
		top.add(title, BorderLayout.PAGE_START);
		top.add(instructionsSize, BorderLayout.LINE_START);
		top.add(instructionsToppings, BorderLayout.LINE_END);
		top.setMinimumSize(new Dimension(640, 360));
		//instructionsToppings.setBackground(new Color(150, 0, 0));
		//instructionsSize.setBackground(new Color(150, 0, 0));
		//top.setBackground(new Color(150, 100, 0));
		//top.setForeground(new Color(200, 50, 50));
	}
	
	public void formatCenter() {
		//size buttons
		ButtonGroup sizeButtons = new ButtonGroup();
		
		sizeButtons.add(small);
		sizeButtons.add(medium);
		sizeButtons.add(large);
		sizeButtons.add(exLarge);
		
		//toppings label, show which toppings have been selected
		
		
		JPanel bGroup = new JPanel();
		bGroup.add(small);
		bGroup.add(medium);
		bGroup.add(large);
		bGroup.add(exLarge);
		
		
		
		//check which size is selected
		ActionListener sizeListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (small.isSelected()) {
					size = "Small";
					sizePrice = 7;
				}
				
				else if (medium.isSelected()) {
					size = "Medium";
					sizePrice = 9;
				}
				
				else if (large.isSelected()) {
					size = "Large";
					sizePrice = 11;
				}
				
				else if (exLarge.isSelected()) {
					size = "Extra Large";
					sizePrice = 13;
				}
				price = sizePrice + topPrice + wingPrice;
				pricePizza.setText("The price of your pizza is $" + price);
				
			}
		};
		
		
		String[] toppingsList = {"None", "Eggplant", "Green Peppers", "Hot Peppers", "Pepperoni", "Sausage", "Mushrooms", "Anchovies"};
		
		
		JList<String> toppings2 = new JList<String>(toppingsList);
		toppings2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//check which topping(s) are selected, ctrl to select multiple individual
		ListSelectionListener topListener = new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if (click == false) {
					//clicking down
					click = true;
				}
				
				else {
					//click up, don't run (click == true)
					click = false;
					return;
				}
				
				for (String top : toppings2.getSelectedValuesList()){
					selectedToppings.add(top);
				}
				
				//if there are toppings, add price
				if (!selectedToppings.contains("None")) {
					topPrice = selectedToppings.size();
					//clear selected
					toppings2.clearSelection();
					String toppingsText = "";
					//count toppings in selectedToppings, get the number of toppings (duplicates) format text to toppingsText
					HashMap<String, Integer> topCount = new HashMap<String, Integer>();
					for (String top : selectedToppings) {
						if (!topCount.containsKey(top)) {
							topCount.put(top, 1);
						}
						else {
							topCount.put(top, topCount.get(top) + 1);
						}
					}
					
					toppingsMap = topCount;
					
					for (Map.Entry<String, Integer> entry : topCount.entrySet()) {
						toppingsText += "<html>" + entry.getKey() + ", " + entry.getValue() + "<br>";
					}
					toppingsText += "</html>";
					//System.out.println(toppingsText);
					showToppings.setText("<html>Your toppings selected: <br>" + toppingsText + "</html>");
				}
				
				else {
					selectedToppings.clear();
					topPrice = 0;
					showToppings.setText("Your toppings selected: \nNone");
				}
				price = topPrice + sizePrice + wingPrice;
				pricePizza.setText("The price of your pizza is $" + price);
			}
		};	
		
		JPanel container = new JPanel();
		container.add(bGroup);
		container.add(toppings2);
		container.add(showToppings);
		container.add(pizzaSummary);
		pizzaSummary.setBackground(new Color(225, 225, 225));
		//toppings.addActionListener(topListener);
		toppings2.addListSelectionListener(topListener);
		small.addActionListener(sizeListener);
		medium.addActionListener(sizeListener);
		large.addActionListener(sizeListener);
		exLarge.addActionListener(sizeListener);
		//center.add(bGroup);
		//center.add(toppings);
		center.add(container);
		
		//center.setBackground(new Color(230, 230, 0));
		//center.setForeground(new Color(200, 200, 0));
	}
	
	public void formatBottom() {
		
		JButton addOrder = new JButton("Add Pizza to Order");
		JButton done = new JButton("Finish Ordering");
		ActionListener wingListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (wings.isSelected()) {
					wingPrice = 5;
				}
				else {
					wingPrice = 0;
				}
				price = sizePrice + topPrice + wingPrice;
				pricePizza.setText("The price of your pizza is $" + price);
				
			}
		};
		
		ActionListener orderListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (size == null) {
					//System.out.println("Please select a pizza");
					//add dialog window to show above message
					
					JOptionPane.showMessageDialog(bottom, "Please select a pizza size");
				}
				else {
					
					
					orderPizza();
				}
			}
		};
		
		ActionListener doneListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//add dialog window to confirm that those are the pizza that the user wants to buy. maybe show pizzasummary.
					//0 is yes, 1 is no, -1 is exit.
					int confirm = JOptionPane.showConfirmDialog(null, "Did you finish ordering all your pizzas?", "Confirm Order", JOptionPane.YES_NO_OPTION);
					if (confirm == 0) {
						getReceipt();
					}
				} catch (IOException e1) {
					//  Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		
		wings.addActionListener(wingListener);
		addOrder.addActionListener(orderListener);
		done.addActionListener(doneListener);
		
		bottom.add(pricePizza);
		bottom.add(wings);
		bottom.add(addOrder);
		bottom.add(done);
		//bottom.setBackground(new Color(150, 100, 0));
		//bottom.setForeground(new Color(150, 100, 0));
		
		
		//DONE order multiple pizzas, make pizza object class
	}
	
	public void getReceipt() throws IOException{
		//System.out.println("Get receipt");
		File file = new File("receipt.txt");
		FileWriter writer = new FileWriter(file);
		writer.write("Thank you for ordering!\n");
		writer.write("Here is your receipt:\n");
		/*
		writer.write("1 " + size + " pizza: $" + sizePrice + "\n");
		if (selectedToppings.size() > 0) {
			writer.write("Toppings: $" + topPrice + "\n");
			for (Map.Entry<String, Integer> entry : toppingsMap.entrySet()) {
				writer.write(entry.getValue() + " " + entry.getKey() + ": ($" + entry.getValue() + ")\n");
			}
		}
		if (wingPrice > 0) {
			writer.write("Side of wings: $5\n");
		}
		writer.write("Total: $" + (sizePrice + topPrice + wingPrice));
		*/
		
		String summary = pizzaSummary.getText();
		
		summary = summary.replaceAll("<br>", "\n");
		summary = summary.replace("<html>", "");
		summary = summary.replace("</html>", "");
		writer.write(summary);
		
		//get total price of all pizzas
		double sum = 0;
		for (Pizza pizza : pizzas) {
			sum += pizza.getPrice();
		}
		writer.write("Total: $" + sum);
		writer.close();
	}
	
	public void orderPizza() {
		Pizza pizza = new Pizza(price, sizePrice, topPrice, toppingsMap, size, wingPrice);
		pizzas.add(pizza);
		writeSummary();
		clearData();
		
		
	}
	
	public void writeSummary() {
		//maybe add new labels per pizzas
		String pizzaText = "<html>Your pizzas: <br><br>";
		for (int i = 0; i < pizzas.size(); i++) {
			pizzaText += "Pizza #" + (i + 1) + ":<br>";
			pizzaText += "Size: " + pizzas.get(i).getSize() + ": $" + pizzas.get(i).getSizePrice() + "<br>";
			HashMap<String, Integer> pizzaToppings = pizzas.get(i).getToppings();
			if (pizzaToppings != null) {
				pizzaText += "Toppings: $" + pizzas.get(i).getTopPrice() + "<br>";
				for (Map.Entry<String, Integer> entry : pizzaToppings.entrySet()) {
					pizzaText += entry.getValue() + " " + entry.getKey() + ": ($" + entry.getValue() + ")<br>";
				}
			}
			if (pizzas.get(i).getWingPrice() > 0) {
				pizzaText += "Side of wings: $5<br>";
			}
			
			pizzaText += "Total: $" + pizzas.get(i).getPrice() + "<br><br>";
			
		}
		pizzaText += "</html>";
		pizzaSummary.setText(pizzaText);
	}
	
	public void clearData() {
		sizePrice = 0;
		topPrice = 0;
		size = null;
		wingPrice = 0;
		toppingsMap = new HashMap<String, Integer>();
		price = 0;
		//clear button selection, label text
		pricePizza.setText("The price of your pizza is $" + price);
		showToppings.setText("Your toppings selected: ");
		wings.setSelected(false);
		small.setSelected(false);
		medium.setSelected(false);
		large.setSelected(false);
		exLarge.setSelected(false);
	}
	
	public static void main(String[] args) {
		//  Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OrderPizza();
			}
		});
		
		
	}

}
