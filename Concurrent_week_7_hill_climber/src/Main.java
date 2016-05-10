

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.*;

public class Main {
	
	public static void main(String[] args){
		
		Future<Double>[] futures = new Future[200];
		Double[][] numbers = new Double[200][100];
		Double min = Double.MAX_VALUE;
		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		// initialize
		for(int i = 0; i < 200; i++){
			for(int j = 0; j < 100; j++){
				numbers[i][j] = Math.random() * (5.12 - -5.12) + -5.12;
			}
			futures[i] = exec.submit(new myTask(numbers[i]));
		}
		
		// get returned values and compare with min
		try{
			for(int i =0; i < 200; i ++){
				Double temp = futures[i].get();
				if(min > temp){
					min = temp;
				}
			}
		}catch(Exception e){
			
		}		
		
		// shutdown
		exec.shutdown();
		try{
			while(!exec.awaitTermination(1, TimeUnit.SECONDS)){
			}
		}catch(Exception e){
			
		}
		
		System.out.println("DONE");
		System.out.println("MIN : "+ min);
	}
	
	
}

