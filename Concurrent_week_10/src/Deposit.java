import java.util.concurrent.atomic.AtomicInteger;

public class Deposit implements Runnable {
	private Account account;
	private int depAmount, depTime;

	Deposit(int seconds, Account account, int depAmount) {
		this.account = account;
		this.depAmount = depAmount;
		this.depTime = seconds;
	}

	public void run() {
		while (true) {
			System.out.println("Deposit " + depAmount + " Balance : "+account.deposit(depAmount));
			try {
				Thread.sleep(depTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
