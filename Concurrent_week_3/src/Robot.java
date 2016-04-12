

public class Robot implements Runnable{
	private coordinate currentPosition;
	private GameBoard map;
	
	public Robot(GameBoard map){
		this.map = map;
		currentPosition = new coordinate(0,0);
	}
	
	public void move(){
		coordinate[] possible_places = GameBoard.getSurroundings(this.currentPosition);
		Integer test = (int)(Math.random() * possible_places.length );
		
		this.currentPosition = possible_places[test];
		this.map.setRobot(this.currentPosition);
	}
	
	public void run(){
		while(true){
			move();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
