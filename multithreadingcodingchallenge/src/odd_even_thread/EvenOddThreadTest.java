package odd_even_thread;



class EvenOdd
{
	private int number =1;
	private boolean b=true;
	synchronized void oddCheck() throws InterruptedException
	{
		while(number<=20)
		{  if(b==true)
		{
			System.out.println(number);
			number++;
			notify();
			b=false;
		}
		else {
			wait();
		}
			
			
		}
	}
	synchronized void EvenCheck() throws InterruptedException
	{
		while(number<=20)
		{  if(b==false)
		{
			System.out.println(number);
			number++;
			notify();
			b=true;
		}
		else {
			wait();
		}
			
			
		}
	}
}

public class EvenOddThreadTest {
	public static void main(String[] args) {
		EvenOdd evenOdd=new EvenOdd();
		new Thread() {
			public void run() {
				try {
					evenOdd.oddCheck();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();

		new Thread() {
			public void run() {
				try {
					evenOdd.EvenCheck();;
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();
		
	}

}
