package PrimeNonPrimeTest;
class PrimeNonPrime{
	
	private int number=2;
	
	 static boolean isPrime(int n) 
	    { 
	        // Corner case 
	        if (n <= 1) 
	            return false; 
	  
	        // Check from 2 to n-1 
	        for (int i = 2; i < n; i++) 
	            if (n % i == 0) 
	                return false; 
	  
	        return true; 
	    } 
	synchronized void prime() throws InterruptedException
	{
		while(number<=20)
		{
			if(isPrime(number))
			{
				System.out.println("Prime:"+number);
				notify();
				number++;
			}
			else {
				wait();
			}
		}
	}
	synchronized void nonPrime() throws InterruptedException
	{
		while(number<=20)
		{
			if(!isPrime(number))
			{
				System.out.println("Non Prime:"+number);
				notify();
				number++;
			}
			else {
				wait();
			}
		}
	}
}
public class PrimeNonPrimeTest {
	public static void main(String[] args) {
		PrimeNonPrime primeNonPrime=new PrimeNonPrime();	
		new Thread() {
			public void run() {
				try {
					primeNonPrime.prime();;
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();

		new Thread() {
			public void run() {
				try {
					primeNonPrime.nonPrime();;
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();
		
	}

}
