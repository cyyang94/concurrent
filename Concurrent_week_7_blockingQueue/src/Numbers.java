import java.util.concurrent.*;

public class Numbers{
	public static void main(String[] args){
		BlockingQueue myList = new ArrayBlockingQueue<Integer>(5);
		
		Thread t1 = new Thread(new Producer(myList));
		Thread c1 = new Thread(new Consumer(myList));
		
		t1.start();
		c1.start();
		
		
	}
}
