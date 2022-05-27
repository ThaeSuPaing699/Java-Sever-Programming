import java.net.*;
import java.io.*;
import java.util.*;
public class greetingClient {
	public static void main(String[] args) throws IOException,UnknownHostException{
		Socket clientSocket = new Socket("localhost",8888);
		
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your message");
		String userinput = sc.nextLine();
		out.writeUTF(userinput);
		
		
		String fromServer = in.readUTF();
		System.out.println("Server:>> "+fromServer);
		clientSocket.close();
	}
}
