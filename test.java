// for testing stuff in lanterna
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
// javac -cp "lanterna.jar;." test.java && java -cp "lanterna.jar;." test
public class test{
	public static void main(String[] args) throws InterruptedException{
		Screen screen = TerminalFacade.createScreen();
		screen.startScreen();
		Thread.sleep(3000);
		Key key = screen.readInput();
		if (key != null){String in = Character.toString(key.getCharacter());}
		String in = "";
		screen.putString(10,5,in,Terminal.Color.BLACK,Terminal.Color.WHITE);
		screen.refresh();
		Thread.sleep(3000);

		screen.stopScreen();
		System.exit(1);
	}
}