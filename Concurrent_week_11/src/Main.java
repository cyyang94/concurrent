import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String args[]) {
		
		Fork[] forks = new Fork[5];
		Executor exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			forks[i] = new Fork(i);
		}
		
		exec.execute(new Diner(forks[0],forks[1],"Diner 1"));
		exec.execute(new Diner(forks[1],forks[2],"Diner 2"));
		exec.execute(new Diner(forks[2],forks[3],"Diner 3"));
		exec.execute(new Diner(forks[3],forks[4],"Diner 4"));
		exec.execute(new Diner(forks[4],forks[0],"Diner 5"));
		
	}
}
