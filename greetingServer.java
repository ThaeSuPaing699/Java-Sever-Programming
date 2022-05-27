import java.net.*;
import java.io.*;
public class greetingServer {
	public static void main(String[] args) throws IOException,UnknownHostException{
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("Server is ready");
		Socket connectionSocket = serverSocket.accept();
		
		DataInputStream in = new DataInputStream(connectionSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
		
		String clientSentence = in.readUTF()
;
		System.out.println("Client:>> "+clientSentence);
		out.writeUTF("Server got this: "+clientSentence);
		connectionSocket.close();
		serverSocket.close();
	}

}
