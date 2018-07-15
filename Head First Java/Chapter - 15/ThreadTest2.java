public class ThreadTest2 {

	public static void main(String[] args) {
		ThreadJob job = new ThreadJob();
		
		Thread a = new Thread(job);
		Thread b = new Thread(job);

		a.setName("A");
		b.setName("B");

		a.start();
		b.start();

	}
}

class ThreadJob implements Runnable {

	@Override
	public void run() {
		foo();
	}

	public void foo() {

		System.out.println("Current Thread : " + Thread.currentThread().getName() + " chooses a random number...");
		int x = (int) (Math.random() * 100);
		System.out.println("Current Thread : " + Thread.currentThread().getName() + " going to sleep.");
		try {
			Thread.sleep(200);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Current Thread : " + Thread.currentThread().getName() + " Woke Up!");
		System.out.println("Current Thread : " + Thread.currentThread().getName() + " Random Number : " + x);

	}
}
