package program;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements ActionListener{
	
	private String userName;
	private String serverName;
	private Socket client;
	private PrintWriter	pw;
	private BufferedReader br;
	private JButton btnSend;
	private JButton btnExit;
	private JTextArea taMessages;
	private JTextField tfInput;

	public Client(String userName, String serverName) throws Exception{
		super(userName);
		this.userName = userName;
		client = new Socket(serverName, Server.PORT);
		this.serverName = serverName;
		pw = new PrintWriter(client.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw.println(userName);
		showGUI();
		new MessagesThread().start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnExit) {
			pw.println("end");
			System.exit(0);
		}
		
		else {
			if (tfInput.getText().length() > 0) {
				pw.println(tfInput.getText());
				tfInput.setText("");
			}
		}
	}
	
	public void showGUI() {
		//send message to server when user exits
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("end");
				System.exit(0);
			}
		});
		
		//add buttons
		btnSend = new JButton("Send");
		btnExit = new JButton("Exit");
		taMessages = new JTextArea();
		taMessages.setRows(10);
		taMessages.setColumns(50);
		taMessages.setEditable(false);
		tfInput = new JTextField(50);
		JScrollPane sp = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(sp, "Center");
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(tfInput);
		btnPanel.add(btnSend);
		btnPanel.add(btnExit);
		add(btnPanel, "South");
		tfInput.addActionListener(this);
		btnSend.addActionListener(this);
		btnExit.addActionListener(this);
		setSize(500, 300);
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog(null, "Enter your name: ", "Get Chat Username", JOptionPane.PLAIN_MESSAGE);
		if (name == null || name.trim().length() == 0) {
			return;
		}
		String serverName = "localhost";
		try {
			new Client(name, serverName);
		}
		catch (Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
			//System.out.println(ex.getMessage());
		}
	
	}
	
	class MessagesThread extends Thread {
		@Override
		public void run() {
			String line;
			try {
				while (true) {
					line = br.readLine();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					LocalDateTime time = LocalDateTime.now();
					String date = time.format(formatter);
					taMessages.append(date + " ||| " + line + "\n");
				}
			}
			catch (Exception ex) {
				
			}
		}
		
	}
}
