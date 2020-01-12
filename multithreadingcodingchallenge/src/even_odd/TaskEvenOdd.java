package even_odd;

public class TaskEvenOdd implements Runnable{

	 private int max;
	    private Printer print;
	    private boolean isEvenNumber;
	 
	    // standard constructors
	 
	   
		@Override
	    public void run() {
	        int number = isEvenNumber ? 2 : 1;
	        while (number <= max) {
	            if (isEvenNumber) {
	                print.printEven(number);
	            } else {
	                print.printEven(number);
	            }
	            number += 2;
	        }
	    }

		public TaskEvenOdd() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TaskEvenOdd(int max, Printer print, boolean isEvenNumber) {
			super();
			this.max = max;
			this.print = print;
			this.isEvenNumber = isEvenNumber;
		}

		public int getMax() {
			return max;
		}

		public void setMax(int max) {
			this.max = max;
		}

		public Printer getPrint() {
			return print;
		}

		public void setPrint(Printer print) {
			this.print = print;
		}

		public boolean isEvenNumber() {
			return isEvenNumber;
		}

		public void setEvenNumber(boolean isEvenNumber) {
			this.isEvenNumber = isEvenNumber;
		}
		
}
