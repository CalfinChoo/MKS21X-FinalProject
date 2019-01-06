import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
// javac -cp "lanterna.jar;." Game.java && java -cp "lanterna.jar;." Game
public class Game{
	private void printView(String[][] view){
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				return;
			}
		}
	}
	private static void fill(String[][] stuff){
		for (int y = 0; y < stuff.length; y++){
			for (int x = 0; x < stuff[0].length; x++){
				stuff[y][x] = "0";
			}
		}
	}
	private static String getPS(String[] line){ //returns a string from a 1D array of strings
		String out = "";
		for (String i:line){
			out += i;
		}
		return out;
	}
	public static void main (String[] args)throws InterruptedException{
		//Screen screen = TerminalFacade.createScreen();
		TerminalSize wantedTSize = new TerminalSize(142,38);
		Terminal currentTerminal = TerminalFacade.createTerminal();
		Screen screen = new Screen(currentTerminal, wantedTSize);
		//screen.setCursorPosition(120,10);

		long lastUpdTime = System.currentTimeMillis();
		long currentTime = System.currentTimeMillis();
		Boolean running = true;

		//TerminalSize wantedTSize = new TerminalSize(142,38);
		TerminalSize currentTSize = screen.getTerminalSize();

		Coordinate playerCoord = new Coordinate(0,0); 
		int vWidth = 35; int vHeight = 35;
		Coordinate viewCoord = new Coordinate(vWidth,vHeight); // top left corner of the map's view
		String[][] view = new String[vWidth][vHeight]; //player's view
		MapGen currentMap = new MapGen(500+vWidth,500+vHeight);

		screen.startScreen();

		while (running){
			if (currentTime - lastUpdTime >= 90){
				Key key = screen.readInput();
				if (key != null && key.getKind() == Key.Kind.Escape){
					running = false;
				}
				String input = (key == null ? "":Character.toString(key.getCharacter()));
				switch(input){
				case "w":
					playerCoord.minusY();
					break;
				case "a":
					playerCoord.minusX();
					break;
				case "s":
					playerCoord.plusY();
					break;
				case "d":
					playerCoord.plusX();
					break;
				case "q":
					playerCoord.minusY();playerCoord.minusX();
					break;
				case "e":
					playerCoord.minusY(); playerCoord.plusX();
					break;
				case "x":
					playerCoord.plusY(); playerCoord.plusX();
					break;
				case "z":
					playerCoord.minusX(); playerCoord.plusY();
					break;
				}

				screen.clear();
				//screen.putString(0,0," ",Terminal.Color.BLACK,Terminal.Color.WHITE);

				//screen.putString(10,5,input, Terminal.Color.BLACK,Terminal.Color.WHITE); see input
				//System.out.println("height: " + currentTSize.getRows());
				//System.out.println("width: " + currentTSize.getColumns());
				screen.putString(playerCoord.getX(),playerCoord.getY(),"P", Terminal.Color.YELLOW,Terminal.Color.RED); 

				screen.updateScreenSize(); currentTSize = screen.getTerminalSize();
				if (currentTSize.getRows() != wantedTSize.getRows() || currentTSize.getColumns() != wantedTSize.getColumns()){
					//currentTerminal.onResized(wantedTSize);
				}

				lastUpdTime = System.currentTimeMillis();
				screen.refresh();
			}
			Thread.sleep(5);
			while(screen.readInput()!=null){}
			Thread.sleep(85);

			currentTime = System.currentTimeMillis();
		}
		screen.stopScreen();
		System.exit(1);
	}
}
