//Almog Fadida, ID 315544437. Moran Arzi, ID 200244945

package socket_client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SumClient extends Thread{
	
	private Socket clientSocket;
	private int argA, argB;
	
	public SumClient(int argA, int argB) {
		this.argA = argA;
		this.argB = argB;
		try {
			clientSocket = new Socket("localhost", 6789);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		BufferedReader inFromServer = null;
		try {
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		DataOutputStream outToServer = null;
		try {
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String clientSentence = Integer.toString(argA) + "," + Integer.toString(argB);
		try {
			System.out.println("Sending message to server: " + clientSentence);
			outToServer.writeBytes(clientSentence + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String serverAnswer = "";
		try {
			System.out.println("Reading message from server");
			serverAnswer = inFromServer.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Result for " + clientSentence + " is: " + serverAnswer);
	}
	
	

}
