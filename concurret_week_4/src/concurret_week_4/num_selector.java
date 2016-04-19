package concurret_week_4;

import java.util.*;

public class num_selector implements Runnable {
	private Queue<Integer> numbers;
	
	public num_selector(Queue<Integer> numbers){
		this.numbers = numbers;
	}
	
	public void getNumber(){
		System.out.println("REMOVE : " + this.numbers.remove());
	}
	
	public void run(){
		while(true){
			synchronized(this.numbers){
				while(this.numbers.size() <= 0){
					System.out.println("Empty ");
					try{
						this.numbers.wait();
					}catch(Exception e){
						
					}
				}
				getNumber();
				this.numbers.notifyAll();
			}
			
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
