package fibbonacci;
class FiboSeries{
	int num=1;
	boolean b=true;
	int t1=0,t2=1;
	synchronized void ThreadA() throws InterruptedException
	{
		while(num<=10)
		{
			 if(b==true)
			 {
				 int sum=t1+t2;
				 t1=t2;
				 t2=sum;
				 System.out.println(sum);
				 notify();
				 num++;
				 b=false;
				 
			 }
			 else {
				 wait();
			 }
		}
	}
	synchronized void ThreadB() throws InterruptedException
	{
		while(num<=10)
		{
			 if(b==false)
			 {
				 int sum=t1+t2;
				 t1=t2;
				 t2=sum;
				 System.out.println(sum);
				 notify();
				 num++;
				 b=true;
				 
			 }
			 else {
				 wait();
			 }
		}
	}
	
	
}
public class FibboSeriesCheck {
	public static void main(String[] args) {
		FiboSeries fiboSeries=new FiboSeries();
		new Thread() {
			public void run() {
				try {
					fiboSeries.ThreadA();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();

		new Thread() {
			public void run() {
				try {
					fiboSeries.ThreadB();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}.start();
	}

}
