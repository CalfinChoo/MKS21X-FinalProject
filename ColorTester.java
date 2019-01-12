import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
import java.awt.Color;
public class ColorTester{
	// input the character type then the R, G, then B color values (0 <= RBG <= 255)
	public static void main(String[] args)throws InterruptedException, IOException{
		Screen screen = new DefaultTerminalFactory().createScreen();
		System.out.println(args[3]);
		TextCharacter chr = new TextCharacter(args[0].charAt(0), 
			new TextColor.RGB(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])), 
			TextColor.ANSI.DEFAULT
			);

		screen.startScreen();
		screen.setCharacter(1,1, chr);
		screen.refresh();
		Thread.sleep(1000);
		screen.close();
	}
}
