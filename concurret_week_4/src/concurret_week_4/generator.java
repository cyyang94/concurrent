package concurret_week_4;
import java.util.*;

public class generator implements Runnable{
	
	private Queue<Integer> numbers;
	
	public generator(Queue numbers){
		this.numbers = numbers;
	}
	
	public void addNumber(){
		Integer randomNumber = (int)(Math.random() * 100);
		numbers.add(randomNumber);
		System.out.println("ADD : " + randomNumber);
	}
	
	public void run(){
		Integer loop = 1;
		while(true){
			
			synchronized(this.numbers){
				while(this.numbers.size() >= 5){
					System.out.println("WAITING");
					try {
						this.numbers.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				addNumber();
				this.numbers.notifyAll();
			}
			
			
			try {
				// sleep for 5 sec after every 5 numbers
				Thread.sleep((loop % 5 == 0)? 5000 : 1000);
			} catch (Exception e) {
			}
			
			loop++;
		}
	}
	
}
