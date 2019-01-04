import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
// javac -cp "lanterna.jar;." Game.java && java -cp "lanterna.jar;." Game
public class Game{
	public static void main(String[] args){
		Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		long lastUpdTime = System.currentTimeMillis();
		long currentTime = System.currentTimeMillis();
		Boolean running = true;

		while (running){
			if (currentTime - lastUpdTime >= 17){
				Key key = screen.readInput();
				if (key != null && key.getKind() == Key.Kind.Escape){
					running = false;
				}
				String input = (key == null ? "":Character.toString(key.getCharacter()));
				screen.clear();
				screen.putString(10,5,input, Terminal.Color.BLACK,Terminal.Color.WHITE);
				
				lastUpdTime = System.currentTimeMillis();
				//screen.doResizeIfNecessary();
				screen.refresh();
			}
			currentTime = System.currentTimeMillis();
		}
		screen.stopScreen();
		System.exit(1);
	}
}
