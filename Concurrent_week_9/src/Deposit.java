import java.util.concurrent.atomic.AtomicInteger;

public class Deposit implements Runnable {
	private AtomicInteger account;
	private int depAmount, depTime;

	Deposit(int seconds, AtomicInteger account, int depAmount) {
		this.account = account;
		this.depAmount = depAmount;
		this.depTime = seconds;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Deposit : " + this.depAmount
						+ " Balance : " + this.account.addAndGet(this.depAmount));
				
				synchronized(account){
					this.account.notifyAll();
				}
				Thread.sleep(this.depTime);

			} catch (InterruptedException e) {
			}
		}
	}
}
