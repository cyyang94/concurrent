package concurrent_week_5;

public class myTask implements Runnable{
	Double[] myList;
	Double min;
	
	public myTask(Double[] myList){
		this.myList = myList;
	}
	
	public void run(){
		int counter = 0;
		Double min = 999999999.99;
		do{
			Double temp = calculate(0,0.0);
			min = min > temp ? temp : min;
			shuffle();
			counter++;
		}while(counter <= 200);
		
		this.min = min;
		
	}
	
	public double calculate(Integer pointer, Double value){
		if(pointer >= myList.length){
			return value;
		}
		return calculate(pointer + 1,value + (pointer * (myList[pointer] * myList[pointer]))); 
	}
	
	public void shuffle(){
		for(int i = 0; i < myList.length; i++){
			Double randomNumber = Math.random() * (0.5 - (-0.5)) + (-0.5);
			if(myList[i] + randomNumber <= 5.12 && myList[i] + randomNumber >= -5.12){
				myList[i]+= randomNumber;
			}
		}
	}
	
	public Double getMin(){
		return this.min;
	}
	
	
}
