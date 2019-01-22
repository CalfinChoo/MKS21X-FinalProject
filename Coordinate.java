public class Coordinate{
	private int x,y;
	public Coordinate(int x, int y){
		this.x = x; this.y = y;
	}
	public Coordinate(Coordinate coord){
		x = coord.getX(); //able to make a new coordinate with a coordinate
		y = coord.getY();
	}
	public int getX(){
		return x;
	}
	public void setX(int n){
		x = n;
	}
	public int getY(){
		return y;
	}
	public void setY(int n){
		y = n;
	}
	public void plusX(){ // quicl incrementing coordinate methods
		++x;
	}
	public void plusY(){
		++y;
	}
	public void minusX(){
		--x;
	}
	public void minusY(){
		--y;
	}
	// this coordinate system begins in the top left corner with the x and y increaing right and down respectivly
	public String toString(){
		return "("+x+":"+y+")";
	}
}