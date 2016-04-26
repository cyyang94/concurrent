package concurrent_week_5;

public class Main {
	public static void main(String[] args){
		long time = System.currentTimeMillis();
		Double[][] myList = new Double[200][100];
		Thread[] threads = new Thread[200];
		myTask[] tasks = new myTask[200];
		
		Double min = 99999999999.9999;
		
		for(int i = 0; i < 200; i ++){
			for(int j = 0; j < 100; j++ ){
				myList[i][j] = Math.random() * (5.12 - -5.12) + -5.12;
			}
		} 
		
		for(int i = 0; i < 200; i++ ){
			tasks[i] = new myTask(myList[i]);
			threads[i] = new Thread(tasks[i]);
			threads[i].start();
		}
		
		try{
			for(int i = 0; i< 200; i++){
				threads[i].join();
			}
			
			for(int i = 0; i< 200;i ++){
				min = min > tasks[i].getMin() ? tasks[i].getMin() : min;
			}
			
			System.out.println("MIN : "+min);
			System.out.println("EXE TIME : "+ (System.currentTimeMillis() - time));
		}catch(Exception e){
			
		}
		
	}
}
