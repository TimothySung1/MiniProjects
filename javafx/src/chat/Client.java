package chat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Client extends Application {
	private static String userName;
	private String serverName;
	private Socket client;
	private static PrintWriter	pw;
	private static BufferedWriter bw;
	private static BufferedReader br;
	private Button btnSend;
	private Button btnExit;
	private TextArea taMessages;
	private TextField tfInput;
	
	
	public Client() {
		this.serverName = "localhost";
	}
	
	public Client(String username, String servername, Stage primaryStage) throws Exception {
		userName = username;
		this.serverName = servername;
		client = new Socket(serverName, Server.PORT);
		pw = new PrintWriter(client.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		pw.println(userName);
		new MessagesThread().start();
		showGUI(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		//pop up for name
		TextInputDialog nameDialog = new TextInputDialog();
		nameDialog.setTitle("Enter your username");
		nameDialog.setHeaderText("Enter your username");
		nameDialog.setContentText("Enter your username:");
		Optional<String> result = nameDialog.showAndWait();
		String name = "";
		String serverName = "localhost";
		if (result.isPresent()){
		    name = result.get();
		    try {
		    	new Client(name, serverName, primaryStage);
		    } catch (Exception e) {
		    	//System.out.println("Connection error");
		    	Alert connectionAlert = new Alert(AlertType.ERROR);
		    	connectionAlert.setTitle("Connection Error");
		    	connectionAlert.setHeaderText("Connection Error");
		    	connectionAlert.setContentText(e.getMessage());
		    	connectionAlert.showAndWait();
		    	return;
		    }
		}
		
		
		
		
	}
	
	public void showGUI(Stage primaryStage) {
		primaryStage.setTitle("Chat Program");
		/*
		tfInput.setText("Enter your username");
		tfInput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String name = tfInput.getText();
				
			}
		});
		*/
		tfInput = new TextField();
		
		Button addFile = new Button();
		addFile.setText("Add File");
		
		
		btnSend = new Button();
		btnSend.setText("Send");
		btnSend.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (tfInput.getText().length() > 0) {
					//System.out.println("pw: " + pw);
					pw.println(tfInput.getText());
					tfInput.setText("");
				}
				//System.out.println("Button pressed");
			}
		});
		btnExit = new Button();
		btnExit.setText("Exit");
		btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stop();
			}
		});
		
		Button btnFile = new Button();
		btnFile.setText("Get File");
		btnFile.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				//open file manager to add file
				if (tfInput.getText().length() > 0) {
					try {
						System.out.println("Button pressed");
						getFile(tfInput.getText());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("get file");
					tfInput.setText("");
				}
			}
		});
		
		taMessages = new TextArea();
		taMessages.setEditable(false);
		ScrollPane scroll = new ScrollPane(taMessages);
		
		HBox hbox = new HBox();
		hbox.getChildren().add(btnFile);
		hbox.getChildren().add(tfInput);
		hbox.getChildren().add(btnSend);
		hbox.getChildren().add(btnExit);
		
		VBox vbox = new VBox();
		vbox.getChildren().add(scroll);
		vbox.getChildren().add(hbox);
				
		StackPane root = new StackPane();
		//root.getChildren().add(btnSend);
		//root.getChildren().add(tfInput);
		root.getChildren().add(vbox);
		
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}
	
	public void getFile(String fileName) throws Exception {
		//System.out.println(fileName);
		//pw print filename to server, differentiate between normal message
		pw.println(fileName);
		System.out.println("pw print");
		/*
		while (!br.ready()) {
			System.out.println("Waiting for next line...");
		}
		*/
		/*
		while (br.ready()) {
			int num = br.read();
			System.out.println(num);
		}
		*/
		int counter = 0;
		while (true) {
			int num = br.read();
			System.out.println(counter + ": " + num);
			counter++;
			if (counter > 1000) {
				break;
			}
		}
		String response = br.readLine();
		System.out.println("response " + response);
		try {
			
			int size = Integer.parseInt(response);
			System.out.println(size);
			int chunks = size / 1024;
			if (size % 1024 != 0) {
				chunks++;
			}
			for (int i = 0; i < chunks; i++) {
				br.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("error" );
			e.printStackTrace();
			return;
		}
		
		
	}
	
	@Override
	public void stop() {
		//System.out.println("stop. pw: " + pw);
		//System.out.println("username: " + userName);
		if (pw != null) {
			pw.println(userName + " left");
		}
		
		System.exit(0);
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
					
					taMessages.appendText(date + " ||| " + line + "\n");
				}
			}
			catch (Exception ex) {
				
			}
		}
		
	}
	
}
