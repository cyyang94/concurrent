import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String args[]) {
		AtomicInteger account = new AtomicInteger(100);
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		exec.submit(new Deposit(2000, account, 10));
		exec.submit(new Deposit(1500,account,20));
		exec.submit(new Withdraw(account));
		
	}
}
