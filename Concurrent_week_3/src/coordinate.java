
public class coordinate {
	private Integer x;
	private Integer y;
	
	public coordinate( int x, int y){
		this.x = x;
		this.y = y;
	}
	public Integer getX(){
		return x;
	}
	
	public Integer getY(){
		return y;
	}
	
	public Boolean equals(Integer x, Integer y){
		return ( this.x == x && this.y == y);
	}
}
