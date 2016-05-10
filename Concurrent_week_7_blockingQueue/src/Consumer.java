import java.util.Iterator;
import java.util.concurrent.*;

public class Consumer implements Runnable{
	BlockingQueue Numbers;
	
	public Consumer(BlockingQueue Numbers){
		this.Numbers = Numbers;
	}
	
	public void run(){
		while(true){
			try{
				
				this.Numbers.take();
				Iterator<Integer> iter = this.Numbers.iterator();
				Thread.sleep(1200);
			}catch(Exception e){
				
			}
		}
	}
}
