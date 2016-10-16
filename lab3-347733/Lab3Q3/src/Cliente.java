import java.net.*;
import java.io.*;

import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) {

		int n1, n2;
		String op;
		
		try (Socket socketServ = new Socket("127.0.0.1", 5000);
			 PrintWriter out = new PrintWriter(socketServ.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(socketServ.getInputStream()))){

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Entre com o primeiro valor: ");
		n1=scanner.nextInt();
		System.out.println("Entre com o segundo valor: ");
		n2=scanner.nextInt();
		System.out.println("Entre com o operador: ");
		op=scanner.next();
		
		String exp = n1+":"+op+":"+n2;

		out.println(exp);

		String resultado = in.readLine();
		System.out.println(resultado);
		scanner.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
