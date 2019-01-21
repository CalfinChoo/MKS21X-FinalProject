import com.googlecode.lanterna.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

/*
* Contains code for generating the map.
* The map is layout in the form a grid with connecting hallways, with the start and boss rooms being in opposite corners.
* The rest of the rooms are randomly placed around on the "grid".
*/

public class MapGen{
	private int width, height;
	private int vWidth, vHeight;
	private int level;
	private TextCharacter [][] map;
	private String[][] symMap;
	private static ArrayList<Coordinate> squares = new ArrayList<Coordinate>();
	private static ArrayList<Coordinate> hallsV = new ArrayList<Coordinate>();
	private static ArrayList<Coordinate> hallsH = new ArrayList<Coordinate>();
	private static ArrayList<String[][]> roomsToAdd = new ArrayList<>();
	private static int shopRoom = 1, treasureRoom;
	public static int ran;
	public static ArrayList<Coordinate> roomCoords = new ArrayList<>();
	public static int startVariation;
	public static int totalRooms;

	public static int enemiesLeft;
	private static ArrayList<Enemy> enemies = new ArrayList<>();
	public static int[] enemyOrder;

//  Constructors to generate the map
	MapGen(int width, int height, int vWidth, int vHeight, int level){
		map = new TextCharacter[height][width];
		this.width = width; this.height = height;
		this.vWidth = vWidth; this.vHeight = vHeight;
		this.level = level;
		treasureRoom = level;
		addBorder(vWidth, vHeight);
		symMap = createSymMap(width,height, vWidth, vHeight);
		map = createMap(width,height,symMap,vWidth, vHeight);
		totalRooms = roomsToAdd.size();
		Random rand = new Random();
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				if (symMap[h][w] == "e"){
					enemiesLeft++;
					int rande = rand.nextInt(4);
					switch (rande){
						case 0:
						enemies.add(new Enemy(w,h,9,5,Graphics.TinyEnemy, Graphics.TinyCM));
						break;
						case 1:
						enemies.add(new Enemy(w,h,9,7,Graphics.SmallEnemy, Graphics.SmallCM));
						break;
						case 2:
						enemies.add(new Enemy(w,h,13,9,Graphics.MediumEnemy, Graphics.MediumCM));
						break;
						case 3:
						enemies.add(new Enemy(w,h,31,11,Graphics.LargeEnemy, Graphics.LargeCM));
						break;
					}
				}
			}
		}
	}
	MapGen(int width, int height){
		map = new TextCharacter[height][width];
		this.width = width; this.height = height;
		map = createMap(width,height);
	}
	MapGen(MapGen copyMap, int vWidth, int vHeight){
		width = copyMap.getWidth() - copyMap.getVW() + vWidth; this.vWidth = vWidth;
		height = copyMap.getHeight() - copyMap.getVH() + vHeight; this.vHeight = vHeight;
		//Coordinate tlcorner = new Coordinate((copyMap.getVW() - 1)/2 - (vWidth - 1)/2, (copyMap.getVH() - 1)/2 - (vHeight - 1)/2);
		Coordinate tlcorner = new Coordinate((copyMap.getVW() - 1)/2, (copyMap.getVH() - 1)/2);
		//System.out.println(copyMap.getSymMap()[tlcorner.getY()+500][tlcorner.getX()+500]);
		symMap = new String[height][width];
		for (int y = tlcorner.getY(), ny = (vHeight-1)/2; ny < height - (vHeight-1)/2 - 1; y++, ny++){
			for (int x=tlcorner.getX(), nx = (vWidth-1)/2; nx <width - (vWidth-1)/2 - 1; x++, nx++){
				//System.out.println(copyMap.getSymMap()[y][x]);
				symMap[ny][nx] = copyMap.getSymMap()[y][x];
			}
		}
		for(int y = 0; y < height;y++){
			for (int x = 0; x < width; x++){
				if (x < (vWidth-1)/2 || y < (vHeight-1)/2 || x > width - (vWidth-1)/2 - 1 || y > height - (vHeight-1)/2 -1){
					symMap[y][x] = "@";
				}
			}
		}
		map = createMap(width,height,symMap,vWidth, vHeight);
		for (int e = 0; e<enemies.size();e++){
			Enemy badGuy = enemies.get(e);
			badGuy.setXPos(badGuy.getXPos() - (copyMap.getVW() - 1)/2 + (vWidth - 1)/2);
			badGuy.setYPos(badGuy.getYPos() - (copyMap.getVH() - 1)/2 + (vHeight- 1)/2);
		}
	}


	public ArrayList<Enemy> getEnemies(){
		return enemies;
	}
	public void removeEnemy(int id){
		for (int i = 0; i < enemies.size(); i++){
			if (enemies.get(i).getID() == id){
				enemies.remove(i);
				return;
			}
		}
	}

//  Get and set functions
	public int getVW(){
		return vWidth;
	}
	public int getVH(){
		return vHeight;
	}

	public TextCharacter[][] getMap(){
		return map;
	}
	public String[][] getSymMap(){
		return symMap;
	}

	public TextCharacter getMapP(int x, int y){
		return map[y][x];
	}

	public void setMap(int x, int y, TextCharacter value){
		map[y][x] = value;
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

//  Helper functions to create the symbol map
	private static void divideMap(Coordinate topLeft, Coordinate bottomRight) {
		int width = bottomRight.getX() - topLeft.getX();
		int height = bottomRight.getY() - topLeft.getY();
		int numRC = width / 232;
		for (int y = 0; y < numRC; y++) {
			for (int x = 0; x < numRC; x++) {
				squares.add(new Coordinate(topLeft.getX() + (width / numRC * x), topLeft.getY() + (height / numRC * y)));
			}
		}
	}
	private static void setupMap(Coordinate topLeft, Coordinate bottomRight, String[][] bigMap) {
		int width = bottomRight.getX() - topLeft.getX();
		int height = bottomRight.getY() - topLeft.getY();
		int numRC = width / 232;
		int squareWidth = (width / numRC);
		int squareHeight = (height / numRC);
		String[][] hHall = generateHallway(width - squareWidth, 9, false);
		String[][] vHall = generateHallway(14, height - squareHeight, true);
		for (int i = 0; i < numRC; i++) {
			hallsV.add(new Coordinate(topLeft.getX() + (squareWidth / 2) - 9 + (squareWidth * i), topLeft.getY() + (squareHeight / 2) - 9));
			hallsH.add(new Coordinate(topLeft.getX() + (squareWidth / 2) - 9, topLeft.getY() + (squareHeight / 2) - 9 + (squareHeight * i)));
		}
		for (int h = 0; h < hallsH.size(); h++) {
			stickOnMap(bigMap, hHall, hallsH.get(h).getX() + 5, hallsH.get(h).getY()+ 5);
		}
		for (int v = 0; v < hallsV.size(); v++) {
			stickOnMap(bigMap, vHall, hallsV.get(v).getX() + 2, hallsV.get(v).getY()+ 5);
		}
		Random rand = new Random();
		ArrayList<String[][]> rooms = new ArrayList<String[][]>();
		for (int i = 0; i < roomsToAdd.size(); i++) {
				rooms.add(roomsToAdd.get(i));
		}
		for (int i = 0; i < squares.size(); i++) {
			int xCoord = squares.get(i).getX() + ((squareWidth - rooms.get(i)[0].length) / 2);
			int yCoord = squares.get(i).getY() + ((squareHeight - rooms.get(i).length) / 2);
			stickOnMapDebug(bigMap, rooms.get(i), xCoord, yCoord);
		}
	}
//  Helper functions to place a room in the map
	private static void stickOnMap(String[][] bigMap, String[][] room, int xCoord, int yCoord){
			for (int y = 0; y < room.length;y++){
				for (int x = 0; x < room[0].length; x++){
					bigMap[y+yCoord][x+xCoord] = room[y][x];
				}
			}
	}
	private static void stickOnMapDebug(String[][] bigMap, String[][] room, int xCoord, int yCoord){
			for (int y = 0; y < room.length;y++){
				for (int x = 0; x < room[0].length; x++){
					if ((y <= 1 || y >= room.length - 2 || x <= 1 || x >= room[y].length - 2) && (bigMap[y+yCoord][x+xCoord] != null && bigMap[y+yCoord][x+xCoord] != "w")) bigMap[y+yCoord][x+xCoord] = "f";
					else bigMap[y+yCoord][x+xCoord] = room[y][x];
				}
			}
	}
//  Function to generate hallways
	private static String[][] generateHallway(int width, int height, boolean up){
		String[][] out = new String[height][width];
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				if ((y==0||y==height-1) && !up){
					out[y][x] = "w";
				}
				else if(up && (x==0||x==1||x==width-1||x==width-2)){
					out[y][x] = "w";
				}
				else{
					out[y][x] = "f";
				}
			}
		}
		return out;
	}
//  Function to create the symbol map
	private static String[][] createSymMap(int width, int height,int vWidth, int vHeight){
		String[][] fauxMap = new String[height][width];
		Room rooms = new Room();
		int zeroX = (vWidth-1)/2; int zeroY = (vHeight-1)/2; int maxX = zeroX + width - vWidth; int maxY = zeroY + height - vHeight;
		divideMap(new Coordinate(zeroX, zeroY), new Coordinate(maxX, maxY));
		Random rand = new Random();
		ran = rand.nextInt(2);
		if (ran == 0) {
			roomsToAdd.add(rooms.getSpawnRoom());
		} else {roomsToAdd.add(rooms.getBossRoom());}
		for (int i = 0; i < squares.size() - 2; i++) {
			int random = rand.nextInt(4);
			if (random == 0) roomsToAdd.add(rooms.getBigBattleRoom());
			else if (random == 1) roomsToAdd.add(rooms.getSmallBattleRoom());
			else if (random == 2 && treasureRoom > 0) {
				roomsToAdd.add(rooms.getTreasureRoom());
				treasureRoom--;
			}
			else if (random == 2 && treasureRoom == 0) {
				i--;
			}
			else if (random == 3 && shopRoom == 1) {
				roomsToAdd.add(rooms.getShopRoom());
				shopRoom--;
			}
			else if (random == 3 && shopRoom == 0) {
				i--;
			}
			rooms = new Room();
		}
		if (ran == 0) {
			roomsToAdd.add(Room.getBossRoom());
		} else {roomsToAdd.add(Room.getSpawnRoom());}
		setupMap(new Coordinate(zeroX, zeroY), new Coordinate(maxX, maxY), fauxMap);
		for(int y = 0; y < height;y++){
			for (int x = 0; x < width; x++){
				if (x < (vWidth-1)/2 || y < (vHeight-1)/2 || x > width - (vWidth-1)/2 - 1 || y > height - (vHeight-1)/2 -1){
					fauxMap[y][x] = "@";
				}
			}
		}
		for (int h = 0; h<height;h++){
			for (int w = 0 ; w<width;w++){
				if (fauxMap[h][w] == null){fauxMap[h][w] = " ";}
			}
		}
		return fauxMap;
	};
//  Functions to create visual maps given dimensions and/or a symbol map
	public static TextCharacter[][] createMap(int width, int height){
		TextCharacter[][] out = new TextCharacter[height][width];
		return out;
	};
	public static TextCharacter[][] createMap(int width, int height,String[][] symMap, int vWidth, int vHeight){
		TextCharacter[][] out = new TextCharacter[height][width];
		int[] red = {244,220,244};
		TextColor.RGB[] colors = {};
		Random r = new Random();
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				if (symMap[h][w] == "w"){
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(80,80,80));
				}
				else if(symMap[h][w] == "p"){
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.CYAN, new TextColor.RGB(100,100,100));
				}
				else if(symMap[h][w] == "d"){
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(100,100,100));
				}
				else if(symMap[h][w] == "@"){
					out[h][w] = new TextCharacter('^', TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK);
				}
				else if(symMap[h][w] == "l"){
					out[h][w] = new TextCharacter('~', TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 128, 0));
				}
				else {
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.CYAN, new TextColor.RGB(red[r.nextInt(2)],43,43));
				}
			}
		}
		return out;
	};
	public static void stickEnemyOnMap(TextCharacter[][] bigMap, Enemy enemy, int xCoord, int yCoord, int direction){
			enemy.setDirection(direction);
			int zeroX = (enemy.getWidth()-1)/2;
			int zeroY = (enemy.getHeight()-1)/2;
			for (int y = 0; y < enemy.getHeight();y++){
				for (int x = 0; x < enemy.getWidth(); x++){
					bigMap[y+yCoord-zeroY][x+xCoord-zeroX] = new TextCharacter(enemy.getGraphics()[direction][y][x].charAt(0),
						enemy.getCM()[direction][y][x],
						bigMap[y+yCoord-zeroY][x+xCoord-zeroX].getBackgroundColor(),
						SGR.BOLD);
				}
			}
	}
	public void addBorder(int vWidth, int vHeight){
		for(int y = 0; y < height;y++){
			for (int x = 0; x < width; x++){
				if (x < (vWidth-1)/2 || y < (vHeight-1)/2 || x > width - (vWidth-1)/2 || y > height - (vHeight-1)/2){
					map[y][x] = new TextCharacter('@', TextColor.ANSI.RED, TextColor.ANSI.DEFAULT);
				}
			}
		}
	}
	public String toString(){
		return "vWidth: "+width + ", " + "vHeight: "+height;
	}
	private static void printView(String[][] view, int xmax, int ymax){
		String out = "";
		for (int y = 0; y < ymax; y++){
			for (int x = 0; x < xmax;x++){
				out+=view[y][x];
			}
			out += "\n";
		}
		System.out.println(out);
		System.out.println("-----------------------------------------------------------------");
	}
	private static void printView(String[][] view){
		String out = "";
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				if (view[y][x] == null) out+=" ";
				else out+=view[y][x]+" ";
			}
			out += "\n";
		}
		System.out.println(out);
		System.out.println("-----------------------------------------------------------------");
	}
}
