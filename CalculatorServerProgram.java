import java.net.*;
import java.util.*;
import java.io.*;
public class CalculatorServerProgram {
	public static void main(String[] args) throws UnknownHostException, IOException{
		int result = 0;
		ServerSocket serverSocket = new ServerSocket(6666);
		System.out.println("Server is created");
		Socket connectionSocket = serverSocket.accept();
		
		while(true) {
		DataInputStream in = new DataInputStream(connectionSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
		
		String operator= in.readUTF();
		int no1 = in.readInt();
		int no2= in.readInt();
		
		if(operator.equalsIgnoreCase("+")) {
			result = no1+no2;
		}
		else if(operator.equalsIgnoreCase("-")) {
			result = no1-no2;
		}
		else if(operator.equalsIgnoreCase("*")) {
			result = no1*no2;
		}
		else if(operator.equalsIgnoreCase("/")) {
			result = no1/no2;
		}
		out.writeInt(result);
		serverSocket.close();
		//connectionSocket.close();
		}
		
	}
}
