import java.io.*;
import java.net.*;

public class client {
	public static void main(String argv[]) throws Exception {
		
		String sentence;
		String modifiedSentence;
		int count;
		
		Socket clientSocket = new Socket("", 12000);
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		count = 5;
		System.out.println("Input a string! " + count + " available messages!");
		
		try {
			while(count > 0 && (sentence = inFromUser.readLine()) != null) {
				count--;
				outToServer.writeBytes(sentence + '\n');
				modifiedSentence = inFromServer.readLine();
				System.out.println("FROM SERVER(" + count + "): " + modifiedSentence);
			}			// End while
			
			System.out.println("Connection Closing  - No more messages available");
			clientSocket.close();
		} catch(SocketException e) {	
			System.out.println("Connection Closing! Error!");
		}
	}
}
