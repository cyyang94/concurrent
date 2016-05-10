
import java.util.concurrent.*;

public class Producer implements Runnable{
	BlockingQueue Numbers;
	
	Producer(BlockingQueue Numbers){
		this.Numbers = Numbers;
	}
	
	public void run(){
		int counter = 1;
		while(true){
			try {
				System.out.println(counter);
				this.Numbers.put((int)((Math.random() * 99) + 1));
				Thread.sleep((counter % 5 == 0)? 5000:300);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter++;
		}
	}
	
}
