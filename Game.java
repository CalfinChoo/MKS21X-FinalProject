import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
// javac -cp "lanterna.jar;." Game.java && java -cp "lanterna.jar;." Game
public class Game{
	public static void main(String[] args) throws InterruptedException{
		Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		screen.putString(10,5,"hello world", Terminal.Color.WHITE, Terminal.Color.BLACK);
		screen.refresh();
		Thread.sleep(300000);
		screen.stopScreen();
		System.exit(1);
	}
}
