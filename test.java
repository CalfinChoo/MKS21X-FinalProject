import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
// javac -cp "lanterna(3).jar;." test.java && java -cp "lanterna(3).jar;." test
public class test{
	public static void main(String[] args) throws InterruptedException, IOException{
		Screen screen = new DefaultTerminalFactory().createScreen();
    //System.out.println(System.currentTimeMillis());

    long lastUpdTime = System.currentTimeMillis();
    long currentTime = System.currentTimeMillis();

    TextColor hi = TextColor.ANSI.WHITE;

    Boolean running = true;

    Coordinate playerCoord = new Coordinate(10,10);

    screen.startScreen();
    while (running){
      System.out.println("pop");
      if (currentTime - lastUpdTime >= 89 ){
        System.out.println("running");
        KeyStroke key = screen.pollInput();
        if (key != null && key.getKeyType() == KeyType.Escape){
          System.out.println("esc");
          screen.close(); running = false; break;
        }
        String input = (key == null ? "":Character.toString(key.getCharacter()));
        switch(input){ // wasd for moving and qezx for diagonal moving
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
            playerCoord.minusY(); // w
            playerCoord.minusX(); // a
          break;
        case "e":
            playerCoord.minusY(); // w
            playerCoord.plusX(); // d
          break;
        case "x":
            playerCoord.plusX(); // d
            playerCoord.plusY(); //s
          break;
        case "z":
            playerCoord.plusY(); //s
            playerCoord.minusX(); // a
          break;
        }

        screen.clear();
        screen.setCharacter(playerCoord.getY(), playerCoord.getX(), new TextCharacter('T', TextColor.ANSI.WHITE, TextColor.ANSI.WHITE));

        lastUpdTime = System.currentTimeMillis();
        screen.refresh();
      }
      Thread.sleep(5);
      while(screen.pollInput()!=null){}
      Thread.sleep(85);

      currentTime = System.currentTimeMillis();
    }
    screen.stopScreen();
    System.exit(1);
  }
}