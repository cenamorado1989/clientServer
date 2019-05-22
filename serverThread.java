import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class serverThread extends Thread{
	Socket socket;
	
	public serverThread(Socket socket) {
		this.socket = socket;
	}
	public void run() { // START RUN METHOD
		try {
		String clientSentence = null;
		String capitalizedSentence;
		int count = 5;
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
		
		while((count > 1) && (clientSentence = inFromClient.readLine()) != null) {
	
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			outToClient.writeBytes(capitalizedSentence);
			System.out.println(count);
			count--;
		}
		clientSentence = inFromClient.readLine();
		capitalizedSentence = clientSentence.toUpperCase() + " - Limit Reached\n"; // DOuble check this, might need to readLIne again
		outToClient.writeBytes(capitalizedSentence);
		System.out.println("Connection Closing\n");
		socket.close();
	} catch (IOException e) {
		e.printStackTrace();
		}
		
	} // END RUN METHOD
}
