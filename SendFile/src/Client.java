import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Optional;

import chat.Client;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Client extends Application{
	
	private String username;
	private String servername;
	private BufferedWriter bw;
	private BufferedReader br;
	private Socket client;
	
	public Client(String name, String servername, Stage primaryStage) throws Exception {
		this.username = name;
		this.servername = servername;
		this.br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		this.bw = new BufferedWriter();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
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
