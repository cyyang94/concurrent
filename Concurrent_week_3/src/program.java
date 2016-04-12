
public class program {
	
	public static void main(String[] args){
		
		GameBoard map = new GameBoard();
		
		Thread robotThread = new Thread(new Robot(map));
		Thread mapThread = new Thread(map);
		
		robotThread.start();
		mapThread.start();
		
		try{
			robotThread.join();
			mapThread.join();
			
		}catch(Exception e){
			
		}
	}
	
}
