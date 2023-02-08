//Almog Fadida, ID 315544437. Moran Arzi, ID 200244945

package socket_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SumServer extends Thread{
	
	
	private ServerSocket welcomeSocket; //main socket of server
	private Socket connectionSocket; //specific socket for a request
	
	//constructor
	public SumServer(ServerSocket welcomeSocket) {
		
		this.welcomeSocket = welcomeSocket; 
		
	}
	
	//run function to accept a request from client
	
	public void run() {	
		
		while (!Thread.currentThread().isInterrupted()) {
			
			//always listen until we got a request
			
			try {
				connectionSocket = this.welcomeSocket.accept(); //accepting a message from client
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			BufferedReader inFromClient = null; //make a new string to send to the client
			
			try { //receiving the message from the client
				inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			} catch (IOException e1) {
				e1.printStackTrace(); 
			}
			
					
			DataOutputStream outToClient = null;
			try {
				
				outToClient = new DataOutputStream(connectionSocket.getOutputStream());
				
			}catch(IOException e) {
				e.printStackTrace();		
			}
				
			String clientSentence = "";
			try { //reading the message from client
				System.out.println("Reading message from client");
				clientSentence = inFromClient.readLine();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
			//Calculate Sum of 2 integers
			//First create a char array for the sentence and put it inside
			//Secondly calculate the sum as chars and put into int final sum.
			//Finally convert the sum into a string again in order to send it as nextLine
			
			//first option but without check for integers
			
			//char[] sumCh;
			//sumCh = clientSentence.toCharArray();
			//int finalSum;
			//finalSum = sumCh[0] + sumCh[sumCh.length-1]; //sum of first and last number
			//String serverSentence = Integer.toString(finalSum);
			
			
			//second option. checks if the char is a dig (int) and return boolean answer.
			//sums only the 2 integers and convert it back to string
			
			char ch = ','; 
			
			String str1 = "";
			String str2 = "";
			String serverSentence = "";
			
			int num1;
			int num2;
			int i = 0;
			int sum;
			
			while(clientSentence.charAt(i) != ch ) { //We search the string we got from the client
				str1 = str1 + clientSentence.charAt(i); //and take the substring until we encounter a ','
				i++;									//to take just the first number
			} 
			
			i++;
			
			while(i != clientSentence.length() ) { //We search the string we got from the client
				str2 = str2 + clientSentence.charAt(i); //and take the substring until we got to the end of the string
				i++;									//to take just the second number
			}
			
			
			num1 = Integer.parseInt(str1); //we convert the first substring to a integer
			num2 = Integer.parseInt(str2);//we convert the second substring to a integer
			
			sum = num1 + num2; //sum of the two numbers
			
			serverSentence = Integer.toString(sum);//convert the sum to string
			
			try {//sending the string of the sum to the client
				System.out.println("Sending message to client: " + serverSentence);
				outToClient.writeBytes(serverSentence + "\n");
			} catch (IOException e) {
				e.printStackTrace(); 
			}	
			
			finally { //we close the socket and the stream to the client
				try {
					connectionSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} //end while
		
		try { //the thread got interrupted so we close the server 
			welcomeSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}//end run function

}//end SumServer class
