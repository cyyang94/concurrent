package concurret_week_4;

import java.util.*;

public class Main {
	public static void main(String[] args){
		Queue<Integer> numbers = new <Integer>LinkedList();
		
		Thread generator_thread = new Thread(new generator(numbers));
		Thread selector_thread = new Thread(new num_selector(numbers));
		
		generator_thread.start();
		selector_thread.start();
		
		try {
			generator_thread.join();
			selector_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
