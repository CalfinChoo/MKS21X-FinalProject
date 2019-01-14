import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import java.util.Random;
public class MapGen{
	private int width, height;
	private TextCharacter [][] map;
	private String[][] symMap;

	MapGen(int width, int height, int vWidth, int vHeight){
		map = new TextCharacter[height][width];
		this.width = width; this.height = height;
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
		for (int y = 0; y < room.length;y++){
			for (int x = 0; x < room[0].length; x++){
				bigMap[y+yCoord][x+xCoord] = room[y][x];
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
		int zeroX = (vWidth-1)/2; int zeroY = (vHeight-1)/2;
		stickOnMap(fauxMap, rooms.getSpawnRoom(), zeroX+1,zeroY+1);
		stickOnMap(fauxMap, rooms.getSmallBattleRoom(), zeroX +56, zeroY +1);
		stickOnMap(fauxMap, generateHallway(29, 9, false), 63, 13);
		for (int h = 0; h<height;h++){
			for (int w = 0 ; w<width;w++){
				if (fauxMap[h][w] == null){fauxMap[h][w] = " ";}
			}
		}
		return fauxMap;
	};
	public static TextCharacter[][] createMap(int width, int height){
		// for testing, fills the string with empty stuff
		TextCharacter[][] out = new TextCharacter[height][width];
		int[] red = {244,220,244}; Random r = new Random();
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				out[h][w] = new TextCharacter(' ', TextColor.ANSI.CYAN, new TextColor.RGB(red[r.nextInt(2)],43,43));
			}
		}
		return out;
	};
	public static TextCharacter[][] createMap(int width, int height,String[][] symMap, int vWidth, int vHeight){
		// for testing, fills the string with empty stuff
		TextCharacter[][] out = new TextCharacter[height][width];
		int[] red = {244,220,244}; Random r = new Random();
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				if (symMap[h][w] == "w"){
					out[h][w] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, new TextColor.RGB(100,100,100));
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
