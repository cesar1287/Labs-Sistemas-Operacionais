import java.net.*;
import java.io.*;

import java.util.Scanner;


public class Cliente {

	public static void main(String[] args) {
		
		try (Socket socketServ = new Socket("127.0.0.1", 2900);
			 PrintWriter out = new PrintWriter(socketServ.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(socketServ.getInputStream()))){
		
			String msg;
			Scanner s = new Scanner(System.in);
		
			while(true){
			
				System.out.println("Digite se gostaria de enviar ou receber mensagem: 1 - enviar, 2 - receber");
				int opcao = s.nextInt();
				if(opcao==1){
					System.out.println("Digite o id(>=0) para o qual deseja enviar:");
					int id = s.nextInt();
					System.out.println("Digite a mensagem que deseja enviar:");
					String msgConteudo = s.next();
		
					msg = id + " " + msgConteudo;
				}else{
					System.out.println("Digite o id para o qual quer receber as mensagem(ns):");
					int id = s.nextInt();
					
					msg = 0 + " " + id;
				}
				
				out.println(msg);
				
				String resultado = in.readLine();
				System.out.println(resultado);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
