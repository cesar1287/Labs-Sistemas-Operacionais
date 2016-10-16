import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor {
	
	static HashMap<Integer, ArrayList<String>> msgs = new HashMap<>();
	static ArrayList<String> msgsList;
	
	public static int separaMsgLeOpcao(String msg){

		String[] parts = msg.split(" ");
		 
		int id = Integer.parseInt(parts[0]);
		
		return id;
	}
	
	public static void anexaMsg(String msg){
		String[] parts = msg.split(" ");
		 
		int id = Integer.parseInt(parts[0]);
		String msgRecebida = parts[1];
		
		if(!msgs.containsKey(id)){
			ArrayList<String> msgsList = new ArrayList<>();
			msgs.put(id, msgsList);
		}
		
		msgsList = msgs.get(id);
		msgsList.add(msgRecebida);
		
		msgs.put(id, msgsList);
	}
	
	public static ArrayList<String> leMsgs(String msg){
		String[] parts = msg.split(" ");
		 
		int id = Integer.parseInt(parts[0]);
		
		msgsList = msgs.get(id);
		
		return msgsList;
	}
	
	public static void main(String[] args) throws IOException {

		PrintWriter out;
		BufferedReader in;
		Socket sockClient;
	
		try(ServerSocket sock=new ServerSocket(2900)){
			while(true){
				sockClient = sock.accept();
				out = new PrintWriter(sockClient.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(sockClient.getInputStream()));

				String msg = in.readLine();
				int id = separaMsgLeOpcao(msg);
				
				if(id==0){
					ArrayList<String> lerMsgs = new ArrayList<>();
					lerMsgs = leMsgs(msg);
					
					for (String string : lerMsgs) {
						out.println(string);
					}
				}else{
					anexaMsg(msg);
					out.println("registrado com sucesso");
				}

				in.close();
				out.close();
			}
		}
	}
}
