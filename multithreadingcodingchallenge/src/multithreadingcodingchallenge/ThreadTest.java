package multithreadingcodingchallenge;

class ThreadA extends Thread
{public void run()
{   int  a=1;
	while(true)
	{for(int i=3;i>=1;i--)
	{
		System.out.println("threadA");
		a++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==3)
		{
			break;
		}
		
	}
		
	}
		
	
		
}
	
}
class ThreadB extends Thread
{
	public void run()
	{ int  a=1;
	while(true)
	{for(int i=3;i>=1;i--)
	{
		System.out.println("threadB");
		a++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a==3)
		{
			break;
		}
		
	}
		
	}
		
	
		

	}
}
public class ThreadTest {
public static void main(String[] args) {
	ThreadA threadA=new ThreadA();
	ThreadB threadB=new ThreadB();
	threadA.start();
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	threadB.start();	
	try {
		threadA.join();
		threadB.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
