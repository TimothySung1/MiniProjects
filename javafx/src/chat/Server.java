package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
	public static final int PORT = 9999;
	private List<String> users;
	private ServerSocket server;
	private List<HandleClient> clients;
	
	public Server() throws IOException {
		clients = new ArrayList<>();
		server = new ServerSocket(PORT, 10);
		users = new ArrayList<String>();
		System.out.println("Server started");
		while (true) {
			Socket client = server.accept();
			HandleClient request = new HandleClient(client);
			clients.add(request);
			broadcast("Server", request.getUsername() + " has joined the chat.");
		}
	}
	
	private void broadcast(String name, String message) {
		
		for (HandleClient user : clients) {
			user.sendMessage(name, message);
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new Server();
	}
	
	
	class HandleClient extends Thread{
		private BufferedReader reader;
		private PrintWriter writer;
		private String name;
		
		public HandleClient(Socket client) throws IOException {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
			name = reader.readLine();
			users.add(name);
			start();
		}
		
		private void sendMessage(String name, String message) {
			writer.println(name + ": " + message);
		}
		
		
		public String getUsername() {
			return name;
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					String line = reader.readLine();
					System.out.println("Received message from " + name + ": " + line);
					if (line.equals("end")) {
						clients.remove(this);
						users.remove(name);
						break;
					}
					//reconnection, user disconnecting, timer to end server if one person, private messaging, group chats, logs, files, etc
					
					//send message to all clients
					broadcast(name, line);
				}
			}
			catch (Exception e){
				
			}
		}
	}
}
