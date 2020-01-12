package factorial;
class FactorialThread{
	private int number=11;
	int fact=1;
private boolean b=true;
synchronized void factcal1() throws InterruptedException
{
	while(number>1)	
	{if(b==true) {
		fact=fact*number;
		//System.out.println(fact);
	number--;
	notify();
	b=false;
	
	}	
	else {
		wait();
	}
	}
	
}
	
synchronized void factcal2() throws InterruptedException
{
	while(number>1)	
	{if(b==false) {
		fact=fact*number;
		//System.out.println(fact);

	number--;
	notify();
	b=true;
	
	}	
	else {
		wait();
	}
	}
	
}
synchronized void display()
{
	System.out.println("factorial is:"+fact);
}

}

public class FactorialThreadTest {
	public static void main(String[] args) {
		FactorialThread factorialThread=new FactorialThread();
		new Thread() {
			public void run() {
				try {
					factorialThread.factcal1();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();

		new Thread() {
			public void run() {
				try {
					factorialThread.factcal2();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();
		new Thread() {
			public void run() {
				factorialThread.display();;

			}
		}.start();
		
		
	}

}
