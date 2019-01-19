import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class MapGen{
	private int width, height;
	private int vWidth, vHeight;
	private TextCharacter [][] map;
	private String[][] symMap;
	private int totalRooms, smallBR;
	private static ArrayList<String> roomsToAdd = new ArrayList<>();
	private int shopRoom = 1, spawnRoom = 1, bossRoom = 1, bigBR = 1, treasureRoom = 1;
	public static int startVariation;
	private Random rand;


	MapGen(int width, int height, int vWidth, int vHeight, int level){
		map = new TextCharacter[height][width];
		this.width = width; this.height = height;
		this.vWidth = vWidth; this.vHeight = vHeight;
		smallBR = level;
		if (level % 5 == 0) {
			bigBR += level / 5;
			treasureRoom += level / 5;
		}
		rand = new Random();
		startVariation = rand.nextInt(4);
		totalRooms = spawnRoom + shopRoom + treasureRoom + smallBR + bigBR + bossRoom;
		for (int i = 0; i < smallBR; i++) roomsToAdd.add("SmallBR");
		for (int i = 0; i < bigBR; i++) roomsToAdd.add("BigBR");
		for (int i = 0; i < treasureRoom; i++) roomsToAdd.add("TreasureRM");
		roomsToAdd.add("ShopRoom");
		Collections.shuffle(roomsToAdd);
		addBorder(vWidth, vHeight);
		symMap = createSymMap(width,height, vWidth, vHeight);
		//printView(symMap,30,20);
		map = createMap(width,height,symMap,vWidth, vHeight);
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
	}

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
	private static void stickOnMap(String[][] bigMap, String[][] room, int xCoord, int yCoord){
		boolean placeable = true;
		for (int y = 0; y < room.length;y++){
			for (int x = 0; x < room[0].length; x++){
				if (bigMap[y+yCoord][x+xCoord] != null) placeable = false;
			}
		}
		if (placeable == true) {
			for (int y = 0; y < room.length;y++){
				for (int x = 0; x < room[0].length; x++){
					bigMap[y+yCoord][x+xCoord] = room[y][x];
				}
			}
		}
	}
	private static String[][] generateHallway(int width, int height, boolean up){
		String[][] out = new String[height][width];
		for (int y = 0; y < height; y++){
			for (int x = 0; x < width; x++){
				if ((y==0||y==height-1) && !up){
					out[y][x] = "w";
				}
				else if((x==0||x==width-1) && up){
					out[y][x] = "w";
				}
				else{
					out[y][x] = " ";
				}
			}
		}
		return out;
	}
	private static String[][] createSymMap(int width, int height,int vWidth, int vHeight){
		String[][] fauxMap = new String[height][width];
		Room rooms = new Room();
		for(int y = 0; y < height;y++){
			for (int x = 0; x < width; x++){
				if (x < (vWidth-1)/2 || y < (vHeight-1)/2 || x > width - (vWidth-1)/2 - 1 || y > height - (vHeight-1)/2 -1){
					fauxMap[y][x] = "@";
				}
			}
		}
		Random rand = new Random();
		int ax = 0; int ay = 0; int bx = 0; int by = 0;
		int zeroX = (vWidth-1)/2; int zeroY = (vHeight-1)/2; int maxX = zeroX + width - vWidth; int maxY = zeroY + height - vHeight;
		if (startVariation == 0) {ax = zeroX + 1; ay = zeroY + 1; bx = maxX - rooms.getBossRoom()[0].length; by = maxY - rooms.getBossRoom().length;}
		if (startVariation == 1) {ax = maxX - rooms.getSpawnRoom()[0].length; ay = zeroY + 1; bx = zeroX + 1; by = maxY - rooms.getBossRoom().length;}
		if (startVariation == 2) {ax = zeroX + 1; ay = maxY - rooms.getSpawnRoom().length; bx = maxX - rooms.getBossRoom()[0].length; by = zeroY + 1;}
		if (startVariation == 3) {ax = maxX - rooms.getSpawnRoom()[0].length; ay = maxY - rooms.getSpawnRoom().length; bx = zeroX + 1; by = zeroY + 1;}
		stickOnMap(fauxMap, rooms.getSpawnRoom(), ax, ay);
		stickOnMap(fauxMap, rooms.getBossRoom(), bx, by);
		for (int i = 0; i < roomsToAdd.size(); i++) {

		}
		//stickOnMap(fauxMap, generateHallway(29, 9, false), zeroX + 29, zeroY + 4);
		for (int h = 0; h<height;h++){
			for (int w = 0 ; w<width;w++){
				if (fauxMap[h][w] == null){fauxMap[h][w] = " ";}
			}
		}
		return fauxMap;
	};
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
				else if(symMap[h][w] == "d"){
					//out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51));
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(100,100,100));
				}
				else if(symMap[h][w] == "@"){
					out[h][w] = new TextCharacter('^', TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK);
				}
				else if(symMap[h][w] == "l"){
					out[h][w] = new TextCharacter('~', TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 128, 0));
				}
				else if(symMap[h][w] == "e"){
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 160, 0));
				}
				else {
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.CYAN, new TextColor.RGB(red[r.nextInt(2)],43,43));
				}
			}
		}
		return out;
	};
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
				out+=view[y][x]+" ";
			}
			out += "\n";
		}
		System.out.println(out);
		System.out.println("-----------------------------------------------------------------");
	}
}
