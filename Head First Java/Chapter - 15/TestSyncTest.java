class TestSync implements Runnable {
	
	private int balance = 0;

	public void run() {
		for(int i = 0 ; i < 500 ; i++) {
			increment();
			System.out.println("Thread Name : " + Thread.currentThread().getName() + " Balance : " + balance);
			
		}
	}

	public void increment() {

		int i = balance;

		try {
			Thread.sleep(1);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		balance = i + 1;
	}

	public int getBalance() {
		return balance;
	}
}

public class TestSyncTest {
	public static void main(String[] args) {

		TestSync job = new TestSync();

		Thread a = new Thread(job);
		Thread b = new Thread(job);
		a.setName("A");
		b.setName("B");
		a.start();
		b.start();

		try {
			a.join();
			b.join();
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}

		System.out.println("FINISH! Final Balance : " + job.getBalance());
	}
}
