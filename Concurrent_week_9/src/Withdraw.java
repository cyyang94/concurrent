import java.util.concurrent.atomic.AtomicInteger;

public class Withdraw implements Runnable {
	private AtomicInteger account;

	Withdraw(AtomicInteger account) {
		this.account = account;
	}

	public void run() {
		while (true) {
			int withdrawAmount = (int) (Math.random() * 20) + 30;

			try {
				// check for balance
				synchronized (account) {
					while (this.account.get() < withdrawAmount) {
						System.out.println("Cant withdraw");
						account.wait();
					}
				}
				
				// withdraw
				System.out.println("Withdraw : " + withdrawAmount
						+ " Balance : " + this.account.addAndGet( -1 * withdrawAmount));

				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
	
}
