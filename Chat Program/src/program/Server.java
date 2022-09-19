package program;

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
		//private PrintWriter writer;
		private BufferedWriter bw;
		private String name;
		private BufferedReader fr;
		
		public HandleClient(Socket client) throws IOException {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			//writer = new PrintWriter(client.getOutputStream(), true);
			bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			name = reader.readLine();
			System.out.println("name " + name);
			users.add(name);
			start();
		}
		
		private void sendMessage(String name, String message) throws IOException {
			//writer.println(name + ": " + message);
			bw.write(name + ": " + message);
		}
		
		
		public String getUsername() {
			return name;
		}
		
		private void sendFile(String name) {
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
					bw.write("The file: " + name + " is empty or is not found in the server directory");
				}
				//FileInputStream fs = new FileInputStream(file);
				long length = file.length();
				
				System.out.println("Length of file: " + length);
				this.fr = new BufferedReader(new FileReader(file), 2000);
				bw.write(length + "\n");
				System.out.println("write " + length);
				
				while (true) {
					try {
						
						String line = fr.readLine();
						if (line == null) {
							System.out.println("null");
							break;
						}
						System.out.println(line);
						bw.write(line + "\n");
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
					System.out.println(line);
					try {
						sendFile(line);
					} catch (Exception e) {
						System.out.println(e);
					}
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
