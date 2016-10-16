public class FiboCalculator implements Runnable{

	private int[] vetorFib;
	
	public FiboCalculator(int[] vetorFib) {
		this.vetorFib = vetorFib;
	}
	
	private int fib(int n){
		if(n==0||n==1){
			return n;
		}
		
		return fib(n-1)+fib(n-2);
	}
	
	@Override
	public void run() {
		for(int i=0; i<vetorFib.length; i++){
			vetorFib[i]=fib(i);
		}
	}
}
