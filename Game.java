import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
// javac -cp "lanterna.jar;." Game.java && java -cp "lanterna.jar;." Game
public class Game{
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
	private static void fill(String[][] stuff){
		for (int y = 0; y < stuff.length; y++){
			for (int x = 0; x < stuff[0].length; x++){
				stuff[y][x] = "0";
			}
		}
	}
	private static void putToScreen(MapGen view, Screen screen, Coordinate tlcorner){ //Top Left Corner of the SCREEN
		//System.out.println(view.getWidth());
		for (int y = tlcorner.getY(), my = 0; my < view.getHeight(); y++,my++){
			for (int x = tlcorner.getX(), mx = 0; mx< view.getWidth(); x++, mx++){
				screen.putString(x,y,view.getMap()[my][mx],view.getCMP(mx,my), view.getBCM()[my][mx]);
				// add diff things based upon symbols in view.map
			}
		}
	}
	private static void updatePlayerCoord(Coordinate playerCoord, Coordinate oldPlayerCoord, MapGen currentMap){
		
	}
	private static void updateView(MapGen view, MapGen currentMap, Coordinate playerCoord){
		Coordinate topLeft = new Coordinate(playerCoord.getX() - ((view.getWidth() - 1) / 2), playerCoord.getY() - ((view.getHeight() -1)/2));
		//System.out.println("topleft:("+topLeft.getX()+"," + topLeft.getY()+")");
		for (int h = topLeft.getY(), vh = 0; vh < view.getHeight(); h++, vh++){
			for (int w = topLeft.getX(),vw = 0; vw < view.getWidth();w++, vw++){
				view.setMap(vw,vh, currentMap.getMapP(w,h));
				view.setCM(vw,vh, currentMap.getCMP(w,h));
			}
		}
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
 
		int vWidth = 51; int vHeight = 35; //should always be odd, but the max is even b/c it starts from 0,  (51,35)
		Coordinate playerCoord = new Coordinate((vWidth-1)/2,(vHeight-1)/2); //player coord must be between vwidth and currentMapWidth - vwidth (same for height)
		Coordinate oldPlayerCoord = new Coordinate(playerCoord.getX(), playerCoord.getY());
		MapGen view = new MapGen(vWidth,vHeight); //player's view
		int mWidth = 500; int mHeight = 500; 
		MapGen currentMap = new MapGen(mWidth+vWidth,mHeight+vHeight, vWidth, vHeight);
		updateView(view,currentMap, playerCoord);
		//testing with random objects
		currentMap.setMap(10,10,"H"); currentMap.setMap(10,11,"H"); currentMap.setMap(9,10,"H");currentMap.setMap(9,11,"H");
		playerCoord.setX(525); playerCoord.setY(517);

		//printView(view.getMap());
		screen.startScreen();
		try{ // stops the screen in the even of an exception
			while (running){
				if (currentTime - lastUpdTime >= 90){
					Key key = screen.readInput();
					if (key != null && key.getKind() == Key.Kind.Escape){
						running = false; 
					}
					String input = (key == null ? "":Character.toString(key.getCharacter()));
					switch(input){ // wasd for moving and qezx for diagonal moving
					case "w":
						if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
							playerCoord.minusY();
						}
						break;
					case "a":
						if (playerCoord.getX() > (view.getWidth()-1) / 2){
							playerCoord.minusX();
						}
						break;
					case "s":
						if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
							playerCoord.plusY();
						}
						break;
					case "d":
						if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
							playerCoord.plusX();
						}
						break;
					case "q":
						if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
							playerCoord.minusY(); // w
						}
						if (playerCoord.getX() > (view.getWidth()-1) / 2){
							playerCoord.minusX(); // a
						}
						break;
					case "e":
						if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
							playerCoord.minusY(); // w
						}
						if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
							playerCoord.plusX(); // d
						}
						break;
					case "x":
						if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
							playerCoord.plusX(); // d
						}
						if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
							playerCoord.plusY(); //s
						}
						break;
					case "z":
						if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
							playerCoord.plusY(); //s
						}
						if (playerCoord.getX() > (view.getWidth()-1) / 2){
							playerCoord.minusX(); // a
						}
						break;
					}

					screen.clear();
					//screen.putString(0,0," ",Terminal.Color.BLACK,Terminal.Color.WHITE);

					//screen.putString(10,5,input, Terminal.Color.BLACK,Terminal.Color.WHITE); see input
					//System.out.println("height: " + currentTSize.getRows());
					//System.out.println("width: " + currentTSize.getColumns());

					updateView(view,currentMap, playerCoord); //System.out.println(view.getHeight());
					putToScreen(view,screen, new Coordinate(3,1));
					screen.putString(1,0,"playerCoord:("+playerCoord.getX()+","+playerCoord.getY()+")",Terminal.Color.BLACK,Terminal.Color.WHITE);
					//screen.putString(playerCoord.getX(),playerCoord.getY(),"P", Terminal.Color.YELLOW,Terminal.Color.BLUE); 

					//screen.updateScreenSize(); currentTSize = screen.getTerminalSize();
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
		catch(Exception e){
			e.printStackTrace();
			screen.stopScreen();
			System.exit(1);
		}
	}
}
