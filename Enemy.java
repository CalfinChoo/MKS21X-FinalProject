import java.util.Random;
public class Enemy{
	private Coordinate coord;
	private int width, height;
	Enemy(int x, int y, int width, int height){
		coord = new Coordinate(x,y);
		this.width = width; this.height = height;
	}
	public Coordinate moveRandom(MapGen map){
		Random rand = new Random();

	}
	private static Boolean canMove(Coordinate playerCoord, MapGen map, int direction, int width, int height){
		if (direction == 0){
			for (int x = playerCoord.getX() - 3; x<playerCoord.getX() +4;x++){
				//System.out.println("|"+map.getSymMap()[playerCoord.getY()-3][x]+"|");
				if (map.getSymMap()[playerCoord.getY()-3][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 1){
			for (int y = playerCoord.getY() - 2; y < playerCoord.getY() +3; y++){
				if (map.getSymMap()[y][playerCoord.getX() + 4] == "w"){
					return false;
				}
			}
			return true;
		}
		if (direction == 2){
			for (int x = playerCoord.getX() - 3; x<playerCoord.getX() +4;x++){
				//System.out.println("|"+map.getSymMap()[playerCoord.getY()-3][x]+"|");
				if (map.getSymMap()[playerCoord.getY()+3][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 3){
			for (int y = playerCoord.getY() - 2; y < playerCoord.getY() +3; y++){
				if (map.getSymMap()[y][playerCoord.getX() - 4] == "w"){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public Coordinate getPos(){
		return coord;
	}
}
