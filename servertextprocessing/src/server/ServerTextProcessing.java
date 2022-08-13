package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTextProcessing {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String receivedText = "";
		int numberOfWords = 0,
				port = 4228;
		
		ServerTextProcessing stp = new ServerTextProcessing();
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		while(true) {
			System.out.println("Server online. Awaiting Requests.");
			
			Socket clientSocket = serverSocket.accept();
			
			
			
			DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
			receivedText = dis.readUTF();
			
			System.out.println("\nReceived text : " + receivedText);
			
			numberOfWords = stp.countWords(receivedText);
			
			DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
			dos.writeInt(numberOfWords);
			dos.flush();
			
			System.out.println("Sent number of words : " + numberOfWords);
			
			clientSocket.close();
		}
		
	}
	
	public int countWords(String text) {
		return text.split(" ").length;
	}

}
