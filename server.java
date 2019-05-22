import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String args[]) throws Exception{
		ServerSocket welcomeSocket = new ServerSocket(12000);
		int count = 0;
		System.out.println("Server Running");
		
		
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			new serverThread(connectionSocket).start();	
		}
	}
}
