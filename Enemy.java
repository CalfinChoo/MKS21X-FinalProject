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
	public long lastAttack;
	private int direction;
	private char type;
	public int getHealth() {
		return health;
	}
	public char getType(){
		return type;
	}
	public int getDirection(){
		return direction;
	}
	public void setDirection(int d){
		direction = d;
	}
	public int getHeight(){
		return graphics[direction].length;
	}
	public int getWidth(){
		return graphics[direction][0].length;
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
	public Coordinate getCoord() {
		return coord;
	}
	Enemy(int x, int y, int width, int height, String[][][] graphics, TextColor[][][] cm){
		coord = new Coordinate(x,y);
		this.width = width; this.height = height; this.graphics = graphics;
		graphicsCM = cm;
		health = 10;
		id = NumOFEnemies;
		NumOFEnemies++;
 		if (graphics == Graphics.TinyEnemy){
			type = 'i';
			health = 15;
		}
 		else if (graphics == Graphics.MediumEnemy){
			type = 'c';
			health = 45;
		}
 		else if (graphics == Graphics.SmallEnemy){
			type = 's';
			health = 30;
 		}
 		else if (graphics == Graphics.LargeEnemy){
			type = 'd';
			health = 60;
		}
		else if (graphics == Graphics.BossOne){
			type = 'b';
		}
	}
	public void recieveDamage(Bullet inflictor) {
      health -= inflictor.getDamage();
  }
	public void attack(MapGen map, Coordinate playerCoord, long time){
		double dist = Math.sqrt(Math.pow(playerCoord.getX() - coord.getX(),2)+Math.pow(playerCoord.getY() - coord.getY(),2));
		if (dist <= 30 && time - lastAttack > 800){
			boolean ru = playerCoord.getX() > (coord.getX() - (getWidth()/2));
			boolean lu = playerCoord.getX() > coord.getX() + getWidth()/2;
			boolean bh = playerCoord.getY() < coord.getY() + getHeight()/2;
			boolean th = playerCoord.getY() < coord.getY() - getHeight()/2;
			//System.out.println("ru:"+ru+" lu:"+lu+" th:"+th+" bh:"+bh);
			//System.out.println("1:"+(!th && bh && lu));
			int direction = 0;
			if (ru && !lu && th){direction =0;}
			else if(!th && bh && lu){direction = 1;}
			else if(!bh && ru && !lu){direction = 2;}
			else if(!ru && !th && bh) {direction = 3;}
			else if (th && !ru) {direction = 7;}
			else if (!bh && !ru) {direction = 6;}
			else if (!bh && lu) {direction = 5;}
			else if (th && lu){direction = 4;}
			//System.out.println(direction);
			map.getBullets().add(new Bullet(new Coordinate(coord), 5, direction, false, type));
			lastAttack = time;
			if (type == 'd'){
				map.getBullets().add(new Bullet(new Coordinate(coord.getX() + 1, coord.getY()), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX() - 1, coord.getY()), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY() + 1), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY() - 1), 5, direction, false, type));
			}
			else if (type == 's' || type == 'c'){
				switch (direction){
					case 0:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()+1), 1, direction, false, 'f'));break;
					case 1:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() - 1, coord.getY()), 1, direction, false, 'f'));break;
					case 2:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()-1), 1, direction, false, 'f'));break;
					case 3:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() +1, coord.getY()), 1, direction, false, 'f'));break;
					case 4:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() -1, coord.getY()+1), 1, direction, false, 'f'));break;
					case 5:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()-1, coord.getY()-1), 1, direction, false, 'f'));break;
					case 6:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()-1), 1, direction, false, 'f'));break;
					case 7:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()+1), 1, direction, false, 'f'));break;
				}
				/*
				switch (direction){
					case 2:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()+1), 6, direction, false, 'h'));break;
					case 3:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() - 1, coord.getY()), 6, direction, false, 'h'));break;
					case 0:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()-1), 6, direction, false, 'h'));break;
					case 1:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() +1, coord.getY()), 6, direction, false, 'h'));break;
					case 6:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() -1, coord.getY()+1), 6, direction, false, 'h'));break;
					case 7:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()-1, coord.getY()-1), 6, direction, false, 'h'));break;
					case 4:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()-1), 6, direction, false, 'h'));break;
					case 5:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()+1), 6, direction, false, 'h'));break;
				}
				*/
			}
			else if (type == 'b'){
				map.getBullets().add(new Bullet(new Coordinate(coord.getX() + 1, coord.getY()), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX() - 1, coord.getY()), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY() + 1), 5, direction, false, type));
				map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY() - 1), 5, direction, false, type));
				switch (direction){
					case 2:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()+1), 6, direction, false, 'h'));break;
					case 3:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() - 1, coord.getY()), 6, direction, false, 'h'));break;
					case 0:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX(), coord.getY()-1), 6, direction, false, 'h'));break;
					case 1:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() +1, coord.getY()), 6, direction, false, 'h'));break;
					case 6:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX() -1, coord.getY()+1), 6, direction, false, 'h'));break;
					case 7:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()-1, coord.getY()-1), 6, direction, false, 'h'));break;
					case 4:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()-1), 6, direction, false, 'h'));break;
					case 5:
					map.getBullets().add(new Bullet(new Coordinate(coord.getX()+1, coord.getY()+1), 6, direction, false, 'h'));break;
				}
			}
		}
	}
	public Coordinate moveRandom(MapGen map, long time){
		Random random = new Random();
		Coordinate old = new Coordinate(coord);
		if (time - lastMove > 900){
			int direction = random.nextInt(8);
			while (!canMove(coord, map, direction, this.getWidth(), this.getHeight())){
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
		int zeroX = (width - 1)/2; int zeroY = (height-1)/2;
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
