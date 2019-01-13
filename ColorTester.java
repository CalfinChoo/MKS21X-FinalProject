import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
public class ColorTester{
	private static void putScreen(Screen screen, int row, int width, String message, TextColor fore, TextColor back){
		for (int x = 0; x < message.length(); x++){
			screen.setCharacter(row+x,width, new TextCharacter(message.charAt(x), fore, back));
		}
	}
	private static void putScreenV(Screen screen, int row, int width, String message, TextColor fore, TextColor back){
		for (int x = 0; x < message.length(); x++){
			screen.setCharacter(row,width+x, new TextCharacter(message.charAt(x), fore, back));
		}
	}
	// input the character type then the R, G, then B color values (0 <= RBG <= 255)
	public static void main(String[] args)throws InterruptedException, IOException{
		Screen screen = new DefaultTerminalFactory().createScreen();
		//System.out.println(args[3]);
		TextCharacter chr = new TextCharacter(args[0].charAt(0),
			new TextColor.RGB(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])),
			TextColor.ANSI.DEFAULT
			);

		screen.startScreen();
		screen.setCharacter(1,1, chr);
		putScreen(screen,2,2, "hello", TextColor.ANSI.BLACK, TextColor.ANSI.WHITE);
		screen.refresh();
		Thread.sleep(1000);
		screen.close();
	}
}
