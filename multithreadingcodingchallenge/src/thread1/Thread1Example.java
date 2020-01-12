package thread1;

class Thread1 {

	int num = 3;
	int num1=3;
	boolean b = true;

	synchronized void ThreadA() throws InterruptedException {

		while (num > 0) {

			if (b == true) {

				for (int i = 1; i <= num; i++) {

					System.out.println("ThreadA");
				}
				b = false;
				notify();
				num--;
			} else {
				wait();
			}

		}

	}

	synchronized void ThreadB() throws InterruptedException {

		while (num1 > 0) {

			if (b == false) {

				for (int i = 1; i <= num1; i++) {

					System.out.println("ThreadB");
				}
				b = true;
				notify();
				num1--;
			} else {
				wait();
			}

		}

	}

}

public class Thread1Example {

	public static void main(String args[]) {

		Thread1 t = new Thread1();
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
