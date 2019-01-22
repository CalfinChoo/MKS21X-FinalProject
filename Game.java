import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
// javac -cp "lanterna(3).jar;." Game.java && java -cp "lanterna(3).jar;." Game
public class Game{ //places a string on the screen
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
	private static void printView(String[][] view){// /for testing
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
	private static void printView(TextCharacter[][] view){ //for testing
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
		//places the view on the map
		for (int y = tlcorner.getY(), my = 0; my < view.getHeight(); y++,my++){
			for (int x = tlcorner.getX(), mx = 0; mx< view.getWidth(); x++, mx++){
				screen.setCharacter(x,y,view.getMap()[my][mx]);
				// add diff things based upon symbols in view.map
			}
		}
	}
	private static void updateView(MapGen view, MapGen currentMap, Coordinate playerCoord){
		// updates the view onto the map due to the change in the players coordinates
		Coordinate topLeft = new Coordinate(playerCoord.getX() - ((view.getWidth() - 1) / 2), playerCoord.getY() - ((view.getHeight() -1)/2));
		//System.out.println("topleft:("+topLeft.getX()+"," + topLeft.getY()+")");
		for (int h = topLeft.getY(), vh = 0; vh < view.getHeight(); h++, vh++){
			for (int w = topLeft.getX(),vw = 0; vw < view.getWidth();w++, vw++){
				view.setMap(vw,vh, currentMap.getMapP(w,h));
			}
		}

	}
	private static void placePlayer(Screen screen, MapGen view, Coordinate tlcorner, int direction, boolean onLava){
		// places the player directly on the screen
		for (int y = view.getHeight() / 2 - 2 + tlcorner.getY(), gy = 0; gy < 5;gy++,y++){
			for (int x = view.getWidth() / 2 - 3 + tlcorner.getX(), gx = 0; gx < 7; gx++,x++){
				if (onLava){
					screen.setCharacter(x,y,new TextCharacter(Graphics.Player[direction][gy][gx].charAt(0), new TextColor.RGB(255,0,0),
					view.getMap()[y-tlcorner.getY()][x-tlcorner.getX()].getBackgroundColor(),
					SGR.BOLD)); //player red when on lava
				}
				else {screen.setCharacter(x,y,new TextCharacter(Graphics.Player[direction][gy][gx].charAt(0), Graphics.PlayerCM[direction][gy][gx],
					view.getMap()[y-tlcorner.getY()][x-tlcorner.getX()].getBackgroundColor(),
					SGR.BOLD));
				}
			}
		}
	}
	private static Boolean canMove(Coordinate playerCoord, MapGen map, int direction){
		//sees if the plaeyr can move
		if (direction == 0){
			for (int x = playerCoord.getX() - 3; x<=playerCoord.getX() +3;x++){
				//System.out.println("|"+map.getSymMap()[playerCoord.getY()-3][x]+"|");
				if (map.getSymMap()[playerCoord.getY()-3][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 1){
			for (int y = playerCoord.getY() - 2; y < playerCoord.getY() +3; y++){
				if (map.getSymMap()[y][playerCoord.getX() + 4] == "w"){
					return false;
				}
			}
			return true;
		}
		if (direction == 2){
			for (int x = playerCoord.getX() - 3; x<playerCoord.getX() +4;x++){
				//System.out.println("|"+map.getSymMap()[playerCoord.getY()-3][x]+"|");
				if (map.getSymMap()[playerCoord.getY()+3][x] == "w"){
					return false;
				}
			}
			return true;
		}
		else if (direction == 3){
			for (int y = playerCoord.getY() - 2; y < playerCoord.getY() +3; y++){
				if (map.getSymMap()[y][playerCoord.getX() - 4] == "w"){
					return false;
				}
			}
			return true;
		}
		return false;
	}
	private static void clearPatch(TextCharacter[][] bigMap, Enemy enemy, int xCoord, int yCoord){
		// gets rid of the enemy from the screen (replaces them with spaces and the correct background color)
		int zeroX = (enemy.getWidth()-1)/2;
		int zeroY = (enemy.getHeight()-1)/2;
		for (int y = 0; y < enemy.getHeight();y++){
			for (int x = 0; x < enemy.getWidth(); x++){
				bigMap[y+yCoord-zeroY][x+xCoord-zeroX] = new TextCharacter(' ',
					TextColor.ANSI.DEFAULT,
					bigMap[y+yCoord-zeroY][x+xCoord-zeroX].getBackgroundColor()
					);
			}
		}

	}
	private static void clearOne(TextCharacter[][] bigMap, Coordinate coord){
		// clear one tile on the screen (for bullets)
		bigMap[coord.getY()][coord.getX()] = new TextCharacter(' ', TextColor.ANSI.DEFAULT, bigMap[coord.getY()][coord.getX()].getBackgroundColor());
	}
	private static void updateEnemies(MapGen map, Coordinate playerCoord, long time){
		//  updates the enemies shooting and movement
		Enemy badGuy;
		for (int e = 0; e < map.getEnemies().size(); e++){ int direction = -1;
			badGuy = map.getEnemies().get(e);
			if (badGuy.getHealth() <= 0) {
				map.getEnemies().remove(e);
				clearPatch(map.getMap(), badGuy, badGuy.getXPos(),badGuy.getYPos());
				map.enemiesLeft--;
				return;//enemies are dereferneced and die when their health is lower than zero
			}
			int px = playerCoord.getX(); int py = playerCoord.getY();
			int x = badGuy.getXPos() - px; int y = badGuy.getYPos() - py;
			boolean gyx = y > x; boolean gymx = y > -1 * x;
			if (gyx && gymx){ direction = 0;}
			else if (!gyx && gymx) {direction = 3;}
			else if (!gyx && !gymx){direction = 2;}
			else if (gyx && !gymx) {direction = 1;} //determines where the enemeis are facing using the line y=x and y=-x from the x-y plane
			clearPatch(map.getMap(), badGuy, badGuy.getXPos(),badGuy.getYPos()); //might not need tis due to screen.clear()
			badGuy.moveRandom(map,time); // bagguy move randomly
			MapGen.stickEnemyOnMap(map.getMap(),badGuy, badGuy.getXPos(),badGuy.getYPos(),direction); //add enemy on map
			badGuy.attack(map, playerCoord, time); //enemy attacks
		}
	}
	private static boolean onLava(MapGen map, Coordinate playerCoord, Player p){
		for (int x = playerCoord.getX() - 3; x < playerCoord.getX() + 4; x++){
			for (int y = playerCoord.getY() - 2; y < playerCoord.getY() + 3; y++){
				if (map.getSymMap()[y][x] == "l"){
					return true;
				}
			}
		}
		return false;
	}
	private static void updateBullets(MapGen map, long time, Player p){
		//moves and places the bullets on the map
		Bullet bullet;
		for (int b = 0; b < map.getBullets().size(); b++){
			bullet = map.getBullets().get(b);
			clearOne(map.getMap(), bullet.getCoord());
			if (!bullet.speedAway(map, time)){
				map.getBullets().remove(b);
				return; 
			}
			map.setMap(bullet.getCoord().getX(), bullet.getCoord().getY(), new TextCharacter('0', bullet.getColor(),
				map.getMap()[bullet.getCoord().getY()][bullet.getCoord().getX()].getBackgroundColor(), SGR.BOLD)
			);
			if (bullet.checkForPlayer(p) && !bullet.getGood()) {
				p.recieveDamage(bullet);
				map.getBullets().remove(b);
				clearOne(map.getMap(), bullet.getCoord());
			}
			for (int e = 0; e < map.getEnemies().size(); e++) {
				Enemy badGuy = map.getEnemies().get(e);
				if (bullet.checkForEnemy(badGuy) && bullet.getGood()) {
					badGuy.recieveDamage(bullet);
					map.getBullets().remove(b);
					clearOne(map.getMap(), bullet.getCoord());
				}
			}
		}
	}
	public static void shoot(MapGen map, Coordinate playerCoord){
		Enemy badGuy=map.getEnemies().get(0); double closest = 1000;
		Enemy target = badGuy;
		for (int e = 0; e < map.getEnemies().size(); e++){
			badGuy = map.getEnemies().get(e);
			double dist = Math.sqrt(Math.pow(playerCoord.getX() - badGuy.getXPos(),2)+Math.pow(playerCoord.getY()-badGuy.getYPos(),2));
			if (dist < closest){
				closest = dist;
				target = badGuy;
			}
		}
		badGuy = target;
		boolean ru = badGuy.getXPos() > playerCoord.getX() - 7/2;
		boolean lu = badGuy.getXPos() > playerCoord.getX() + 7/2;
		boolean bh = badGuy.getYPos() < playerCoord.getY() + 5/2;
		boolean th = badGuy.getYPos() < playerCoord.getY() - 5/2;
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
		else if (th && lu){direction = 4;} //getting direction to shoot in 
		map.getBullets().add(new Bullet(new Coordinate(playerCoord), 5, direction, true, 'p'));
	}
	public static void main(String[] args) throws InterruptedException, IOException{
		Screen screen = new DefaultTerminalFactory().createScreen();
		long lastUpdTime = System.currentTimeMillis();
		long currentTime = System.currentTimeMillis();
		long lastShot = 0;
		Boolean running = true;
		int currentLevel = 0;


		TerminalSize currentTSize = screen.getTerminalSize();
		TerminalSize viewTSize = new TerminalSize(currentTSize.getColumns(), currentTSize.getRows());

		int vWidth = currentTSize.getColumns() % 2 == 0 ? currentTSize.getColumns() - 3: currentTSize.getColumns() - 2;
		int vHeight = currentTSize.getRows() % 2 == 0 ? currentTSize.getRows() - 3: currentTSize.getRows() - 2;
		int oldWidth = vWidth; int oldHeight = vHeight;
		//should always be odd, but the max is even b/c it starts from 0,  (51,35)

		Coordinate playerCoord = new Coordinate((vWidth-1)/2 + 3,(vHeight-1)/2 + 2); //player coord must be between vWidth and currentMapWidth - vWidth (same for height)
		MapGen view = new MapGen(vWidth,vHeight); //player's view
		int mWidth = 696; int mHeight = 351;
		MapGen currentMap = new MapGen(mWidth+vWidth,mHeight+vHeight, vWidth, vHeight, currentLevel);
		updateView(view,currentMap, playerCoord);
		//MapGen newMap = new MapGen(currentMap, 11,11);

		//Testing area
		//MapGen test = new MapGen(20,20,9,9);
		//printView(test.getSymMap());
		//test = new MapGen(test,9,11);
		//printView(test.getSymMap());

		Coordinate spawnPoint = new Coordinate(0, 0);
		if (MapGen.ran == 0) spawnPoint = new Coordinate((vWidth-1)/2 + 116,(vHeight-1)/2 + 58);
		if (MapGen.ran == 1) spawnPoint = new Coordinate((vWidth-1)/2 + mWidth - vWidth - 40,(vHeight-1)/2 + mHeight - vHeight - 38);
		playerCoord = new Coordinate(spawnPoint);
		//playerCoord.setX(534); playerCoord.setY(509);

		//printView(view.getMap());
		//System.out.println(currentMap.enemiesLeft);
		//System.out.println(currentMap.getEnemies().size());
		Boolean isLastNull = false;
		Boolean doorOpen = true;
		int direction = 2;
		long healthTime = 0;
		long lavaTime = 0;
		//~,0,~
		//3,~,1
		//~,2,~
		Player p = new Player(50, playerCoord);
		screen.startScreen();
		try{ // stops the screen in the event of an exception
			while (running){
				KeyStroke key = screen.pollInput();
				if (currentTime - lastUpdTime >= 61){
					if (p.getHealth() < p.getMaxHealth() && currentTime - healthTime > 250) {
						p.addToHealth(1);
						healthTime = currentTime;
					}
					if (key == null) {isLastNull = true;} else {isLastNull = false;}
					if (key != null && key.getKeyType() == KeyType.Escape){
						System.out.println("you coward! what could be more important than this game right now!!!");
						System.out.println("you are not worthy of this awesome game!");
						running = false; break;
					}
					if (key != null && key.getKeyType() == KeyType.Character){
						switch(key.getCharacter()){ // wasd for moving and qezx for diagonal moving
						case 'w':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 + 2 && Enemy.canMove(playerCoord, currentMap, 0, 7, 5)){
								playerCoord.minusY();
							}
							direction = 0;
							break;
						case 'a':
							if (playerCoord.getX() > (view.getWidth()-1) / 2 + 3 && Enemy.canMove(playerCoord,currentMap, 3, 7,5)){
								playerCoord.minusX();
							}
							direction = 3;
							break;
						case 's':
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2) - 2 && canMove(playerCoord,currentMap,2)){
								playerCoord.plusY();
							}
							direction = 2;
							break;
						case 'd':
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2) - 3 && canMove(playerCoord,currentMap,1)){
								playerCoord.plusX();
							}
							direction = 1;
							break;
						case 'q':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 + 2 && Enemy.canMove(playerCoord, currentMap, 0, 7, 5)){
								playerCoord.minusY(); // w
							}
							if (playerCoord.getX() > (view.getWidth()-1) / 2 + 3 && Enemy.canMove(playerCoord,currentMap, 3, 7,5)){
								playerCoord.minusX(); // a
							}
							direction = 3;
							break;
						case 'e':
							if (playerCoord.getY() > (view.getHeight() - 1) /2 + 2 && Enemy.canMove(playerCoord, currentMap, 0, 7, 5)){
								playerCoord.minusY(); // w
							}
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2) - 3 && canMove(playerCoord,currentMap,1)){
								playerCoord.plusX(); // d
							}
							direction = 1;
							break;
						case 'x':
							if(playerCoord.getX() < mWidth + ((vWidth-1) / 2) - 3 && canMove(playerCoord,currentMap,1)){
								playerCoord.plusX(); // d
							}
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2) - 2 && canMove(playerCoord,currentMap,2)){
								playerCoord.plusY(); //s
							}
							direction = 1;
							break;
						case 'z':
							if(playerCoord.getY() < mHeight + ((vHeight-1) / 2) - 2 && canMove(playerCoord,currentMap,2)){
								playerCoord.plusY(); //s
							}
							if (playerCoord.getX() > (view.getWidth()-1) / 2 + 3 && Enemy.canMove(playerCoord,currentMap, 3, 7,5)){
								playerCoord.minusX(); // a
							}
							direction = 3;
							break;
						case ' ':
							if (currentTime - lastShot > 300){
								shoot(currentMap, playerCoord);
								lastShot = currentTime;
							}
						}
					}

					screen.doResizeIfNecessary(); currentTSize = screen.getTerminalSize();

					if (currentTSize.getRows() != viewTSize.getRows() || currentTSize.getColumns() != viewTSize.getColumns()){
						//System.out.println(vWidth + ":" + vHeight);
						vWidth = currentTSize.getColumns() % 2 == 0 ? currentTSize.getColumns() - 3: currentTSize.getColumns() - 2;
						vHeight = currentTSize.getRows() % 2 == 0 ? currentTSize.getRows() - 3: currentTSize.getRows() - 2;
						playerCoord.setX(playerCoord.getX() - (oldWidth-1)/2 + (vWidth-1)/2);
						playerCoord.setY(playerCoord.getY() - (oldHeight-1)/2 + (vHeight-1)/2);
						//System.out.println(vWidth + ":" + vHeight);
						view = new MapGen(vWidth,vHeight);
						currentMap = new MapGen (currentMap, vWidth, vHeight); //new map with diff border
						viewTSize = new TerminalSize(currentTSize.getColumns(), currentTSize.getRows());
						oldHeight = vHeight;
						oldWidth = vWidth;
					} //creates a new map if tthe screen is resized b/c of the border changing


					screen.clear();
					//screen.putString(0,0," ",Terminal.Color.BLACK,Terminal.Color.WHITE);

					//screen.putString(10,5,input, Terminal.Color.BLACK,Terminal.Color.WHITE); see input
					//System.out.println("height: " + currentTSize.getRows());
					//System.out.println("width: " + currentTSize.getColumns());
					screen.setCharacter(0,0, new TextCharacter(' ',TextColor.ANSI.BLACK, TextColor.ANSI.WHITE));
					Coordinate tlcorner = new Coordinate(1,1);
					updateEnemies(currentMap,playerCoord,currentTime);
					updateBullets(currentMap,currentTime, p);
					boolean onLava = onLava(currentMap, playerCoord, p);
					if (onLava && currentTime-lavaTime > 200){
						p.addToHealth(-1);
					}


					updateView(view,currentMap, playerCoord); //System.out.println(view.getHeight());
					putToScreen(view,screen, tlcorner);
					placePlayer(screen, view, tlcorner, direction, onLava);
					//putString(screen,1,0,"PlayerCoord:("+(playerCoord.getX() - (vWidth-1)/2) +","+(playerCoord.getY() - (vHeight-1)/2)+")",
						//new TextColor.RGB(255,255,255),TextColor.ANSI.BLACK);
					p.setCoord(playerCoord);

					putString(screen,1,0,"PlayerCoord:("+playerCoord.getX()+","+playerCoord.getY()+")",
						new TextColor.RGB(255,255,255),TextColor.ANSI.BLACK);
					putString(screen,24,0,"Health:" + p.getHealth(), TextColor.ANSI.RED, TextColor.ANSI.BLACK);
					putString(screen,34,0,"Enemies Left:"+ currentMap.getEnemies().size(), TextColor.ANSI.CYAN, TextColor.ANSI.BLACK);

					if (currentMap.getEnemies().size() == 0){
						System.out.println("congratulations you have suceeded where normal people would fail. ");
						System.out.println("the world will always remember you");
						break;
					}
					lastUpdTime = System.currentTimeMillis();
					screen.refresh();
				}
				Thread.sleep(1);
				if (!isLastNull) {while(screen.pollInput()!=null){}}
				Thread.sleep(60);

				currentTime = System.currentTimeMillis();
			}
			screen.stopScreen();
			System.exit(1);
		}
		catch(Exception e){
			e.printStackTrace();
			if (vWidth < 10 || vHeight < 10){
				System.out.println("you made the size of the window too small!! seriously why would you do that?");
			}
			else {System.out.println("wow! you managed to find a bug. if you really want it fixed comment on github and email calvin and it might get fixed (though I doubt it)");
			}
			screen.stopScreen();
			System.exit(1);
		}
	}
}
