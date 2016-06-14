
import java.util.concurrent.locks.*;
public class Fork {
	private int id;
	private ReentrantLock lock = new ReentrantLock();
	
	Fork(int id){
		this.id = id;
	}
	
	public boolean get(){
		if(lock.tryLock()){
			return true;
		}
		return false;
	}
	
	public void release(){
		if(lock.isHeldByCurrentThread() && lock.isLocked()){
			lock.unlock();
		}
	}
}
