import java.net.*;
import java.io.*;
import java.util.*;
public class CalculatorClientProgram {
	
	public static void main(String[] args) throws IOException {
		char ch;
		Socket clientSocket = new Socket("localhost", 6666);
		
		do {
		DataInputStream in = new DataInputStream(clientSocket.getInputStream());
		DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("Enter an operator(+,-,*,/): ");
		String operator = br.readLine();
		out.writeUTF(operator);
		
		System.out.println("Enter no1: ");
		int no1 = Integer.parseInt(br.readLine());
		out.writeInt(no1);
		
		System.out.println("Enter no2: ");
		int no2 = Integer.parseInt(br.readLine());
		out.writeInt(no2);
		
		int result = in.readInt();
		System.out.println("Resut is : "+result);
		
		System.out.println("try it more (y/n)?");
		ch=br.readLine().toLowerCase().charAt(0);	}
		while(ch=='y');
		
		clientSocket.close();		}
}
