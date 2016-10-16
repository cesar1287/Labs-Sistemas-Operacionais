import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static int separaExpressao(String exp){

		String[] parts = exp.split(":");
		 
		int num1 = Integer.parseInt(parts[0]);
		int num2 = Integer.parseInt(parts[2]);
		String operando = parts[1];
		 
		int valor = 0;
		 
		switch (operando) {
			case "+":
			valor = num1+num2;
			break;
			case "-":
			valor = num1-num2;
			break;
			case "*":
			valor = num1*num2;
			break;
			case "/":
			valor = num1/num2;
			break;
		}
		return valor;
	}
	
	public static void main(String[] args) throws IOException {

		PrintWriter out;
		BufferedReader in;
		Socket sockClient;
	
		try(ServerSocket sock=new ServerSocket(5000)){
			while(true){
				sockClient = sock.accept();
				out = new PrintWriter(sockClient.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

				String expressao = in.readLine();
				int result = separaExpressao(expressao);

				out.println(result);

				in.close();
				out.close();
			}
		}
	}
}
