package filechat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	private static final String root = "C:\\Users\\tsung\\Desktop\\Server\\Test";
	
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
	
	private void broadcast(String name, String message) throws IOException {
		
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
		private BufferedWriter bw;
		private String name;
		private BufferedReader fr;
		
		public HandleClient(Socket client) throws IOException {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			writer = new PrintWriter(client.getOutputStream(), true);
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			//have bufferedwriter method to add new line, flush out after
			name = reader.readLine();
			System.out.println("name " + name);
			users.add(name);
			start();
		}
		
		private void sendMessage(String name, String message) {
			try {
				writer.println(name + ": " + message);
				System.out.println("sendMessage " + name + ": " + message);
			} catch (Exception e) {
				System.out.println("sendMessage error: ");
				e.printStackTrace();
			}
			
		}
		
		
		public String getUsername() {
			return name;
		}
		
		private void sendFile(String name) throws IOException {
			
			//bw.write("Sending file...");
			
			System.out.println("Send file");
			if (name.substring(0, 1).equals("/")){
				name = root + name;
			}
			else {
				name = root + "/" + name;
			}
			try {
				File file = new File(name);
				if (!file.canRead()) {
					//send file name and error message
					writer.println("The file: " + name + " is empty or is not found in the server directory");
					return;
				}
				//FileInputStream fs = new FileInputStream(file);
				long length = file.length();
				
				System.out.println("Length of file: " + length);
				this.fr = new BufferedReader(new FileReader(file), 2000);
				//writer.println("|||SIZE|||" + length);
				System.out.println("write " + length);
				
				while (true) {
					try {
						
						String line = fr.readLine();
						if (line == null) {
							System.out.println("null");
							break;
						}
						System.out.println(line);
						writer.println(line);
					} catch (Exception e) {
						e.printStackTrace();
						break;
					}
					
					
				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
			
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					//System.out.println("something");
					String line = reader.readLine();
					//System.out.println(line);
					if (line.startsWith("|||File|||")) {
						try {
							line = line.substring(10);
							sendFile(line);
						} catch (Exception e) {
							System.out.println(e);
						}
					}
					
					else {
						System.out.println("Received message from " + name + ": " + line);
						if (line.equals("end")) {
							clients.remove(this);
							users.remove(name);
							break;
						}
						//reconnection, user disconnecting, timer to end server if one person, private messaging, group chats, logs, files, etc
						
						//send message to all clients
						System.out.println("broadcasting");
						broadcast(name, line);
					}
					
				}
			}
			catch (Exception e){
				
			}
		}
	}
}
