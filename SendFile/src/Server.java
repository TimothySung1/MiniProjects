import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;



public class Server {
	public static final int PORT = 9999;
	private List<String> users;
	private ServerSocket server;
	private List<HandleClient> clients;
	
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
		
		@Override
		public void run() {
			
		}
	}
}
