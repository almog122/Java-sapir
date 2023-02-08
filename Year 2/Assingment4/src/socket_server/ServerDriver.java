//Almog Fadida, ID 315544437. Moran Arzi, ID 200244945

package socket_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerDriver {

	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(6789);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		SumServer serverThread = new SumServer(server); //a problem. missing
		
		serverThread.start();
		
		try {
			serverThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	} //end main function

	
	
} //end ServerDriver class
