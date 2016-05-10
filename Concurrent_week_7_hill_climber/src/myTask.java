import java.util.concurrent.*;

public class myTask implements Callable<Double>{
	Double[] myList,prev;
	Double min;
	
	public myTask(Double[] myList){
		this.myList = new Double[100];
		this.prev = new Double[100];
		
		for(int i = 0; i < 100;i ++){
			this.myList[i] = myList[i];
			this.prev[i] = myList[i];
		}
	}
	
	public Double call(){
		int counter = 0;
		Double min = Double.MAX_VALUE;
		do{
			Double temp = calculate(0,0.0);
			if(min > temp){
				min = temp;
			}else{
				this.revert();
			}
			
			shuffle();
			counter++;
		}while(counter <= 350);
		
		return min;
	}
	
	public double calculate(Integer pointer, Double value){
		if(pointer >= myList.length){
			return value;
		}
		return calculate(pointer + 1,value + (pointer * (myList[pointer] * myList[pointer]))); 
	}
	
	// re randoms the numbers
	public void shuffle(){
		for(int i = 0; i < myList.length; i++){
			this.prev[i] = myList[i]; // backups the array for reverting purpose
			
			Double randomNumber = Math.random() * (0.5 - (-0.5)) + (-0.5);
			Double newNumber = myList[i] + randomNumber;
			
			if( newNumber <= 5.12 && 
				newNumber >= -5.12 )
			{
				myList[i] = newNumber;
			}
		}
	}
	
	//reverts to previous value
	public void revert(){
		for(int i = 0; i < 100; i++){
			this.myList[i] = this.prev[i];
		}
	}
}
