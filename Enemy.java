import java.util.Random;
import com.googlecode.lanterna.*;
public class Enemy{
	private Coordinate coord;
	private int width, height;
	private String[][][] graphics;
	private TextColor[][][] graphicsCM;
	public static  int NumOFEnemies = 0;
	private int id;
	private int health;
	public long lastMove;
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}
	public TextColor[][][] getCM(){
		return graphicsCM;
	}
	public String[][][] getGraphics(){
		return graphics;
	}
	public int getID(){
		return id;
	}
	public void looseHealth(int damage){
		health -= damage;
	}
	Enemy(int x, int y, int width, int height, String[][][] graphics, TextColor[][][] cm){
		coord = new Coordinate(x,y);
		this.width = width; this.height = height; this.graphics = graphics;
		graphicsCM = cm;
		health = 10;
		id = NumOFEnemies;
		NumOFEnemies++;
	}
	public Coordinate moveRandom(MapGen map, long time){
		Random random = new Random();
		Coordinate old = new Coordinate(coord);
		if (time - lastMove > 900){
			int direction = random.nextInt(8);
			while (!canMove(coord, map, direction, width, height)){
				direction = random.nextInt(8);
			}
			move(direction);
			lastMove = time;
		}
		return old;
	}
	public void move(int direction){
		switch (direction){
			case 0:
			coord.minusY();
			break;
			case 1:
			coord.plusX();
			break;
			case 2:
			coord.plusY();
			break;
			case 3:
			coord.minusX();
			break;
			case 4:
			coord.minusY();
			coord.plusX();
			break;
			case 5:
			coord.plusX();
			coord.plusY();
			break;
			case 6:
			coord.minusX();
			coord.plusX();
			break;
			case 7:
			coord.minusY();
			coord.minusX();
			break;
		}
		return;
	}
	public static Boolean canMove(Coordinate enemyCoord, MapGen map, int direction, int width, int height){ //graphic width & height
		//7,0,4
		//3,~,1
		//6,2,5
		int zeroX = (width- 1)/2; int zeroY = (height-1)/2;
		if (direction == 0){
			for (int x = enemyCoord.getX() - zeroX; x<=enemyCoord.getX() + zeroX;x++){
				if (map.getSymMap()[enemyCoord.getY()- zeroY - 1][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 1){
			for (int y = enemyCoord.getY() - zeroY; y <= enemyCoord.getY() + zeroY; y++){
				if (map.getSymMap()[y] [enemyCoord.getX() + zeroX + 1] == "w"){
					return false;
				}
			}
			return true;
		}
		if (direction == 2){
			for (int x = enemyCoord.getX() - zeroX; x <= enemyCoord.getX() + zeroX;x++){
				//System.out.println("|"+map.getSymMap() enemyCoord.getY()-3][x]+"|");
				if (map.getSymMap()[enemyCoord.getY()+ zeroY+1][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 3){
			for (int y = enemyCoord.getY() - zeroY; y <= enemyCoord.getY() +zeroY; y++){
				if (map.getSymMap()[y][enemyCoord.getX() - zeroX -1] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 4){
			return canMove(enemyCoord, map, 0, width, height) && canMove(enemyCoord, map, 1, width, height);
		}
		else if (direction == 5){
			return canMove(enemyCoord, map, 2, width, height) && canMove(enemyCoord, map, 1, width, height);
		}
		else if (direction == 6){
			return canMove(enemyCoord, map, 2, width, height) && canMove(enemyCoord, map, 3, width, height);
		}
		else if (direction == 7){
			return canMove(enemyCoord, map, 3, width, height) && canMove(enemyCoord, map, 0, width, height);
		}
		return false;
	}
	public Coordinate getPos(){
		return coord;
	}
	public int getXPos(){
		return coord.getX();
	}
	public int getYPos(){
		return coord.getY();
	}
	public void setXPos(int x){
		coord.setX(x);
	}
	public void setYPos(int y){
		coord.setY(y);
	}
}
