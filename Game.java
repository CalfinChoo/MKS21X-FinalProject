import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
//javac -cp "lanterna(3).jar;." Game.java && java -cp "lanterna(3).jar;." Game
public class Game{
	private static void putString(Screen screen, int row, int width, String message, TextColor fore, TextColor back){
		for (int x = 0; x < message.length(); x++){
			screen.setCharacter(row+x,width, new TextCharacter(message.charAt(x), fore, back));
		}
	}
	private static void putStringV(Screen screen, int row, int width, String message, TextColor fore, TextColor back){
		for (int x = 0; x < message.length(); x++){
			screen.setCharacter(row,width+x, new TextCharacter(message.charAt(x), fore, back));
		}
	}
	private static void printView(TextCharacter[][] view){
		String out = "";
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				out+=view[y][x].getCharacter()+" ";
			}
			out += "\n";
		}
		System.out.println(out);
		System.out.println("-----------------------------------------------------------------");
	}
	private static void putToScreen(MapGen view, Screen screen, Coordinate tlcorner){ //Top Left Corner of the SCREEN
		//System.out.println(view.getWidth());
		for (int y = tlcorner.getY(), my = 0; my < view.getHeight(); y++,my++){
			for (int x = tlcorner.getX(), mx = 0; mx< view.getWidth(); x++, mx++){
				screen.setCharacter(x,y,view.getMap()[my][mx]);
				// add diff things based upon symbols in view.map
			}
		}
	}
	private static void updateView(MapGen view, MapGen currentMap, Coordinate playerCoord){
		Coordinate topLeft = new Coordinate(playerCoord.getX() - ((view.getWidth() - 1) / 2), playerCoord.getY() - ((view.getHeight() -1)/2));
		//System.out.println("topleft:("+topLeft.getX()+"," + topLeft.getY()+")");
		for (int h = topLeft.getY(), vh = 0; vh < view.getHeight(); h++, vh++){
			for (int w = topLeft.getX(),vw = 0; vw < view.getWidth();w++, vw++){
				view.setMap(vw,vh, currentMap.getMapP(w,h));
			}
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException{
		Screen screen = new DefaultTerminalFactory().createScreen();
		long lastUpdTime = System.currentTimeMillis();
		long currentTime = System.currentTimeMillis();
		Boolean running = true;

		TerminalSize currentTSize = screen.getTerminalSize();
		TerminalSize viewTSize = new TerminalSize(currentTSize.getColumns(), currentTSize.getRows());
 
		int vWidth = currentTSize.getColumns() - 5; int vHeight = currentTSize.getRows() - 2; //should always be odd, but the max is even b/c it starts from 0,  (51,35)
		Coordinate playerCoord = new Coordinate((vWidth-1)/2,(vHeight-1)/2); //player coord must be between vWidth and currentMapWidth - vWidth (same for height)
		MapGen view = new MapGen(vWidth,vHeight); //player's view
		int mWidth = 500; int mHeight = 500; 
		MapGen currentMap = new MapGen(mWidth+vWidth,mHeight+vHeight, vWidth, vHeight);
		updateView(view,currentMap, playerCoord);
		//testing with random objects
		//currentMap.setMap(10,10,"H"); currentMap.setMap(10,11,"H"); currentMap.setMap(9,10,"H");currentMap.setMap(9,11,"H");
		//playerCoord.setX(525); playerCoord.setY(517);

		//printView(view.getMap());
		Boolean isLastNull = false;
		screen.startScreen();
		try{ // stops the screen in the event of an exception
			while (running){
				KeyStroke key = screen.pollInput();
				if (currentTime - lastUpdTime >= 90){
					if (key == null) {isLastNull = true;} else {isLastNull = false;}
					if (key != null && key.getKeyType() == KeyType.Escape){
						running = false; break;
					}
					if (key != null && key.getKeyType() == KeyType.Character){
						switch(key.getCharacter()){ // wasd for moving and qezx for diagonal moving
						case 'w':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
								playerCoord.minusY();
							}
							break;
						case 'a':
							if (playerCoord.getX() > (view.getWidth()-1) / 2){
								playerCoord.minusX();
							}
							break;
						case 's':
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
								playerCoord.plusY();
							}
							break;
						case 'd':
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
								playerCoord.plusX();
							}
							break;
						case 'q':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
								playerCoord.minusY(); // w
							}
							if (playerCoord.getX() > (view.getWidth()-1) / 2){
								playerCoord.minusX(); // a
							}
							break;
						case 'e':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 ){
								playerCoord.minusY(); // w
							}
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
								playerCoord.plusX(); // d
							}
							break;
						case 'x':
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2)){
								playerCoord.plusX(); // d
							}
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
								playerCoord.plusY(); //s
							}
							break;
						case 'z':
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2)){
								playerCoord.plusY(); //s
							}
							if (playerCoord.getX() > (view.getWidth()-1) / 2){
								playerCoord.minusX(); // a
							}
							break;
						}
					}

					screen.doResizeIfNecessary(); currentTSize = screen.getTerminalSize();
					if (currentTSize.getRows() != viewTSize.getRows() || currentTSize.getColumns() != viewTSize.getColumns()){

						vWidth = currentTSize.getColumns() - 5; vHeight = currentTSize.getRows() - 2;
						view = new MapGen(vWidth,vHeight);
						viewTSize = currentTSize;
						//System.out.println("resizing");
					}

					screen.clear();
					//screen.putString(0,0," ",Terminal.Color.BLACK,Terminal.Color.WHITE);

					//screen.putString(10,5,input, Terminal.Color.BLACK,Terminal.Color.WHITE); see input
					//System.out.println("height: " + currentTSize.getRows());
					//System.out.println("width: " + currentTSize.getColumns());

					updateView(view,currentMap, playerCoord); //System.out.println(view.getHeight());
					putToScreen(view,screen, new Coordinate(3,1));
					putString(screen,1,0,"playerCoord:("+playerCoord.getX()+","+playerCoord.getY()+")",
						TextColor.ANSI.BLACK,new TextColor.RGB(255,255,255));
					//screen.setCharacter(1,1,new TextCharacter('T', TextColor.ANSI.WHITE, TextColor.ANSI.WHITE));
					//screen.putString(playerCoord.getX(),playerCoord.getY(),"P", Terminal.Color.YELLOW,Terminal.Color.BLUE); 

					lastUpdTime = System.currentTimeMillis();
					screen.refresh();
				}
				Thread.sleep(1);
				if (!isLastNull) {while(screen.pollInput()!=null){}}
				Thread.sleep(120);

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