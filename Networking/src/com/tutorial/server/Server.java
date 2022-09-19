package com.tutorial.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server implements Runnable{
	
	private int port;
	private boolean running = false;
	//running server/dealing with data
	private Selector selector;
	private ServerSocket serverSocket;
	private ByteBuffer buffer;
	
	public Server(int port, int bufferSize) {
		this.port = port;
		this.buffer = ByteBuffer.allocate(bufferSize);
	}
	
	//starts server
	public void start() {
		new Thread(this).start();
	}
	
	//called when start the server
	@Override
	public void run() {
		running = true;
		while(running) {
			try {
				int client = selector.select();
				
				if(client == 0) {
					continue;
				}
				
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> it = keys.iterator();
				
				while(it.hasNext()) {
					SelectionKey key = (SelectionKey)it.next();
					
					//check if ready to accept new connection
					if((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
						Socket socket = serverSocket.accept();
						
						System.out.println("Connection from: " + socket);
						
						//create socket channel
						SocketChannel socketChannel = socket.getChannel();
						socketChannel.configureBlocking(false);
						//this checks if the socket channel is ready to read data from
						socketChannel.register(selector, SelectionKey.OP_READ);
					}
					
					//check if data read is accepted
					else if((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
						SocketChannel channel = null;
						
						channel = (SocketChannel)key.channel();
						
						boolean connection = readData(channel, buffer);
						
						if(!connection) {
							//remove connection
							key.cancel();
							Socket socket = null;
							socket = channel.socket();
							socket.close();
						}
					}
					keys.clear();
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//opens the channel
	public void open() {
		ServerSocketChannel serverChannel;
		
		try {
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			
			serverSocket = serverChannel.socket();
			
			InetSocketAddress address = new InetSocketAddress(port);
			serverSocket.bind(address);
			
			selector = Selector.open();
			
			serverChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server Created on Port: " + port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean readData(SocketChannel channel, ByteBuffer buffer) {
		
	}
	
}
