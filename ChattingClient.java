import java.net.*;
import java.io.*;
import java.util.*;
public class ChattingClient {
	public static void main(String[] args) throws IOException{
		Socket clientSocket = new Socket("localhost",3434);
		
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		
		do {
		System.out.println("Client message :");
		String msg  = sc.nextLine();
		out.writeUTF(msg);
		
		String fromServer = in.readUTF();
		System.out.println("Server>> "+fromServer);
		}while(true);
		
		
	}
}
