import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.*;


public class Account {
	private ReentrantLock lock = new ReentrantLock();
	private Condition notEmptyCondition = lock.newCondition(); 
	private AtomicInteger balance = new AtomicInteger(100);
	
	public Integer withdraw(Integer amount){
		lock.lock();
		try{
			while (this.balance.get() < amount)
			{
						System.out.println("Cant withdraw");
						notEmptyCondition.await();					
			}
			return this.balance.addAndGet( -1 * amount);
		}catch(Exception e){}finally{
			lock.unlock();
		}
		
		System.out.println("Unable to withdraw");
		return this.balance.addAndGet(0);
	}
	
	public Integer deposit(Integer amount){
		lock.lock();
		Integer result = this.balance.intValue();
		try{
			result = this.balance.addAndGet(amount);
			notEmptyCondition.signalAll();
			return result;
		}catch(Exception e){
			System.out.println("Unable to deposit");
		}finally{
			lock.unlock();
		}
		return result;
	}
	
}
