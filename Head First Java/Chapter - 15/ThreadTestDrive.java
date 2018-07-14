class MyThreadJob1 implements Runnable {

	public void run() {
		doStuff();
	}

	void doStuff() {
		int i = 0;
		while(i++ < 500) {
			System.out.println("In Thread Job : 1");
			try {
				Thread.sleep(1);
			} catch (Exception ex) { }
		}
	}
}

class MyThreadJob2 implements Runnable {

	public void run() {
		doStuff();
	}

	void doStuff() {
		int i = 0;
		while(i++ < 500) {
			System.out.println("In Thread Job : 2");
			try {
				Thread.sleep(1);
			} catch (Exception ex) { }
		}
	}
}

public class ThreadTestDrive {
	public static void main(String[] args) {
		MyThreadJob1 threadJob1 = new MyThreadJob1();
		MyThreadJob2 threadJob2 = new MyThreadJob2();

		Thread t1 = new Thread(threadJob1);
		Thread t2 = new Thread(threadJob2);

		t1.start();
		t2.start();

	}
}
