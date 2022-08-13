package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTextProcessing {

	public static void main(String[] args) throws UnknownHostException, IOException{
		// TODO Auto-generated method stub
		String someText = args[0];
		int numberOfWords = 0;
		
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		
		System.out.println("Connected to server: " + socket.isConnected());
		
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(someText);
		dos.flush();
		
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		numberOfWords = dis.readInt();
		
		socket.close();
		
		System.out.println("The number of words in \"" + someText +"\" is " + numberOfWords);
	}

}
