package threadexamples;


class ThreadAscDes
{private  int num=3;
private  int num1=3;
private boolean b=true;
synchronized void ThreadA() throws InterruptedException
{while (num>0) {
	if(b==true)
	{for (int i = 1; i <=num ; i++) {
		System.out.println("ThreadA");
		
	}
	b=false;
	notify();
	num--;
		
	}
	else {
		wait();
	}
		
	}
	
}
	

synchronized void ThreadB() throws InterruptedException
{while (num1>0) 
	{if(b==false)
	{for (int i = 1; i <=num1; i++) {
		System.out.println("ThreadB");
		
	}
	b=false;
	notify();
	num1--;
		
	}
	else {
		wait();
	}
	
}
}
	
	
}	


public class ThreadExample {
public static void main(String[] args) {
	ThreadAscDes t = new ThreadAscDes();
	new Thread() {
		public void run() {
			try {
				t.ThreadA();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}.start();

	new Thread() {
		public void run() {
			try {
				t.ThreadB();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}.start();

}
}
