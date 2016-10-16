import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class DateServerSingleThreadExecutor {

    public static void main(String[] args) throws IOException {
	
		Socket client = null;
		ServerSocket sock = null;
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        
		try {
			sock = new ServerSocket(6013);
			while (true) {

				client = sock.accept();

				System.out.println("server = " + sock);
				System.out.println("client = " + client);
				
				ClientRun clientRun = new ClientRun(client);
				
				executorService.execute(clientRun);

				client.close();
				
			}
			
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			if (sock != null)
				sock.close();
			if (client != null)
				client.close();	
		}
	}
}

class ClientRun implements Runnable {

	private Socket sockClient;
	
	ClientRun(Socket socket) {
		this.sockClient = socket;
	}
	
	public void run() {
	
		try {
			PrintWriter pout = new PrintWriter(sockClient.getOutputStream(), true);
			
			pout.println(new java.util.Date().toString());
		
			pout.close();
		
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
