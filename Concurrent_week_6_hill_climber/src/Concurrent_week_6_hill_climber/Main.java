package Concurrent_week_6_hill_climber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args){
		myTask[] tasks = new myTask[200];
		Double[][] numbers = new Double[200][100];

		ExecutorService exec = Executors.newFixedThreadPool(5);
		
		for(int i = 0;i < 200; i++){
			for(int j = 0;j<100; j++){
				numbers[i][j] = Math.random() * (5.12 - -5.12) + -5.12;
			}
			tasks[i] = new myTask(numbers[i]);
			exec.execute(tasks[i]);
		}
		
		
		exec.shutdown();
		try{
			while(!exec.awaitTermination(1, TimeUnit.SECONDS)){
			}
		}catch(Exception e){
			
		}
		
		System.out.println("DONE");
		System.out.println("MIN : "+ getMin(tasks));
	}
	
	public static Double getMin(myTask[] tasks){
		Double min = 99999999.999;
		for(int i = 0; i< 200;i ++){
			min = min > tasks[i].getMin() ? tasks[i].getMin() : min;
		}
		
		return min;
	}
}

