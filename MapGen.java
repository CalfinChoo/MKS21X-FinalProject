import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
public class MapGen{
	private int width, height;
	private TextCharacter [][] map;

	MapGen(int width, int height, int vWidth, int vHeight){
		map = new TextCharacter[height][width];
		this.width = width; this.height = height;
		map = createMap(width,height);
		addBorder(vWidth, vHeight);
	}
	MapGen(int width, int height){
		map = new TextCharacter[height][width];		
		this.width = width; this.height = height;
		map = createMap(width,height);
	}
	public TextCharacter[][] getMap(){
		return map;
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

	private static TextCharacter[][] createMap(int width, int height, Room[] rooms){
		return null;
	};
	public static TextCharacter[][] createMap(int width, int height){
		// for testing, fills the string with empty stuff
		TextCharacter[][] out = new TextCharacter[height][width];
		int i = 0;
		for (int h = 0; h < height; h++){
			for (int w = 0; w<width;w++){
				out[h][w] = new TextCharacter('O', TextColor.ANSI.CYAN, TextColor.ANSI.CYAN);
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
}
