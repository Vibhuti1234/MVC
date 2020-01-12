package tablesof4;
class TableThread{
	private int num=1;
	private int num1=10;
	private boolean b=true;
	synchronized void ThreadA() throws InterruptedException
	{
		while (num<=5) {
			if(b==true)
			{
				System.out.println("4 x "+num+"="+(num*4));
				b=false;
				notify();
				num++;
				
			}
			
			else {
				wait();
			}
				
			}
	}
	synchronized void ThreadB() throws InterruptedException
	{
		while (num1>=5 ) {
			if(b==false)
			{
				System.out.println("4 x "+num1+"="+(num1*4));
				b=true;
				notify();
				num1--;
				
			}
			
			else {
				wait();
			}
				
			}
		
	}
}

public class ThreadTableTest {
	public static void main(String[] args) {
		TableThread tableThread=new TableThread();
		new Thread() {
			public void run() {
				try {
					tableThread.ThreadA();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();

		new Thread() {
			public void run() {
				try {
					tableThread.ThreadB();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();
	}

}
