import com.googlecode.lanterna.terminal.Terminal;
public class MapGen{
	private int width, height;
	private String[][] map; //player object and enemy map
	private Terminal.Color[][] colorMap;
	private Terminal.Color[][] backColorMap;

	MapGen(int width, int height){
		map = createMap(width,height);
		colorMap = new Terminal.Color[height][width];
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				colorMap[h][w] = Terminal.Color.BLUE;
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
				out[h][w] = "O";
				++i;
			}
		}
		return out;
	};
}
