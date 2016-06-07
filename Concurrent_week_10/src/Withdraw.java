import java.util.concurrent.atomic.AtomicInteger;

public class Withdraw implements Runnable {
	private Account account;

	Withdraw(Account account) {
		this.account = account;
	}

	public void run() {
		while(true){
			int withdrawAmount = (int) (Math.random() * 20) + 30;
			System.out.println("Withdraw : " + withdrawAmount + " Balance : " +account.withdraw(withdrawAmount));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
