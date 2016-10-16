import java.util.Scanner;

public class FiboMain {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Entre com o quantidade de elementos desejada:");
		int n = s.nextInt();
		
		int[] vetor=new int[n];
		
		FiboCalculator fiboCalculator = new FiboCalculator(vetor);
		
		Thread t = new Thread(fiboCalculator);
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<vetor.length; i++){
			System.out.printf("%d ", vetor[i]);
		}
		
		s.close();
	}
}
