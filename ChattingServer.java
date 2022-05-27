import java.net.*;
import java.io.*;
import java.util.*;
public class ChattingServer {
	public static void main(String args[]) throws IOException{
		ServerSocket serverSocket = new ServerSocket(3434);
		System.out.println("Server is ready");
		Socket connectionSocket = serverSocket.accept();
		
		Scanner sc = new Scanner(System.in);
		
		DataInputStream in = new DataInputStream(connectionSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
	
		do {
			String fromClient = in.readUTF();
			System.out.println("Client>> "+fromClient);
		System.out.println("Server message :");
		String msg  = sc.nextLine();
		out.writeUTF(msg);
		
		
		}while(true);
	
	}
}
