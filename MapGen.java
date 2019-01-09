import com.googlecode.lanterna.terminal.Terminal;
public class MapGen{
	private int width, height;
	private String[][] map; //player object and enemy map
	private Terminal.Color[][] colorMap;
	private Terminal.Color[][] backColorMap;

	MapGen(int width, int height, int vWidth, int vHeight){
		map = createMap(width,height);
		colorMap = new Terminal.Color[height][width];
		backColorMap = new Terminal.Color[height][width];
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				colorMap[h][w] = Terminal.Color.BLUE;
				backColorMap[h][w] = Terminal.Color.BLACK;
			}
		}
		this.width = width; this.height = height;
		addBorder(vWidth, vHeight);
	}
	MapGen(int width, int height){
		map = new String[height][width];
		colorMap = new Terminal.Color[height][width];
		backColorMap = new Terminal.Color[height][width];
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				colorMap[h][w] = Terminal.Color.BLUE;
				backColorMap[h][w] = Terminal.Color.BLACK;
			}
		}
		this.width = width; this.height = height;
	}
	public String[][] getMap(){
		return map;
	}
	public Terminal.Color[][] getCM(){
		return colorMap;
	}
	public Terminal.Color[][] getBCM(){
		return backColorMap;
	}

	public String getMapP(int x, int y){
		return map[y][x];
	}
	public Terminal.Color getCMP(int x, int y){
		return colorMap[y][x];
	}

	public void setMap(int x, int y, String value){
		map[y][x] = value;
	}
	public void setCM(int x, int y, Terminal.Color color){
		colorMap[y][x] = color;
	}
	public void setBCM(int x, int y, Terminal.Color color){
		backColorMap[y][x] = color;
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

	private static String[][] createMap(int width, int height, Room[] rooms){
		return null;
	};
	public static String[][] createMap(int width, int height){
		// for testing, fills the string with empty stuff
		String[][] out = new String[height][width];
		int i = 0;
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				if (w == 0){out[h][w] = "" + i++ %10;}
				else {out[h][w] = "O";}
			}
		}
		return out;
	};
	public void addBorder(int vWidth, int vHeight){
		for(int y = 0; y < height;y++){
			for (int x = 0; x < width; x++){
				if (x < (vWidth-1)/2 || y < (vHeight-1)/2 || x > width - (vWidth-1)/2 || y > height - (vHeight-1)/2){
					//if (y < (vHeight-1)/2) System.out.println("("+x+","+y+")");
					map[y][x] = "@";
					colorMap[y][x] = Terminal.Color.RED;
				}
			}
		}
	}
	public String toString(){
		return "vWidth: "+width + ", " + "vHeight: "+height;
	}
}
