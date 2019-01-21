import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import java.io.IOException;
//javac -cp "lanterna(3).jar;." Graphics.java && java -cp "lanterna(3).jar;." Graphics
public class Graphics{
  /*
 * Contains all the sprites used in the game.
 * Sprites are saved as static 3-Dimensional String Arrays containing the different orientations/directions of the model.
 * The common format used in storing the orientations is 1) Up, 2) Right, 3) Down, 4) Left
 */

 // Sprite of the player model (7x5)
  public static String Player[][][] =
  {
    {
      {"_", "/", "X", "X", "X", "\\", "_"},
      {"(", " ", " ", " ", " ", " ", ")"},
      {"/", "\\", "X", "X", "X", "/", "\\"},
      {"V", "/", ".", "-", ".", "\\", "V"},
      {" ", "d", "b", " ", "d", "b", " "}
    },
    {
      {"_", "/", "X", "X", "X", "\\", "_"},
      {"(", " ", " ", "o", "~", "o", ")"},
      {"/", "\\", "X", "X", "/", "\\", "_"},
      {"V", "/", "/", "\\", "\\", " ", " "},
      {" ", "H", "b", " ", "H", "b", " "}
    },
    {
      {"_", "/", "X", "X", "X", "\\", "_"},
      {"(", " ", "o", "~", "o", " ", ")"},
      {"/", "\\", "X", "X", "X", "/", "\\"},
      {"V", "/", ".", "-", ".", "\\", "V"},
      {" ", "d", "b", " ", "d", "b", " "}
    },
    {
      {"_", "/", "X", "X", "X", "\\", "_"},
      {"(", "o", "~", "o", " ", " ", ")"},
      {"_", "/", "\\", "X", "X", "/", "\\"},
      {" ", " ", "/", "/", "\\", "\\", "V"},
      {" ", "d", "H", " ", "d", "H", " "}
    }
  };
  public static TextColor[][][] PlayerCM =
    {
      {
        {new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153)},
        {new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, new TextColor.RGB(255, 221, 153)},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT}
      },
      {
        {new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153)},
        {new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(255, 221, 153)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT}
      },
      {
        {new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153)},
        {new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, new TextColor.RGB(255, 221, 153)},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT}
      },
      {
        {new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38)},
        {new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153)},
        {new TextColor.RGB(255, 221, 153), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210), new TextColor.RGB(210, 210, 210)},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, TextColor.ANSI.BLUE, new TextColor.RGB(255, 221, 153)},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT, new TextColor.RGB(140, 140, 140), new TextColor.RGB(140, 140, 140), TextColor.ANSI.DEFAULT}
      },
    };
  //  Sprite of the TinyEnemy, or Devilish Imp (9x5)
  public static String TinyEnemy[][][] =
  {
    {
      {" ", " ", " ", "(", "_", ")", "L", "|", "J"},
      {" ", " ", "(", " ", " ", " ", ")", "|", " "},
      {"A", " ", "o", "/", " ", "\\", "0", "|", " "},
      {" ", "\\", "_", "\\", "_", "/", " ", "|", " "},
      {" ", " ", " ", "d", " ", "b", " ", "|", " "}
    },
    {
      {" ", " ", " ", "(", "_", ")", "L", "|", "J"},
      {" ", " ", "(", " ", "o", "o", ")", "|", " "},
      {"A", " ", "o", "/", " ", "\\", "0", "|", " "},
      {" ", "\\", "_", "\\", "_", "/", " ", "|", " "},
      {" ", " ", " ", "d", " ", "b", " ", "|", " "}
    },
    {
      {"L", "|", "J", "(", "_", ")", " ", " ", " "},
      {" ", "|", "(", "o", " ", "o", ")", " ", " "},
      {" ", "|", "0", "/", " ", "\\", "o", " ", "y"},
      {" ", "|", " ", "\\", "_", "/", "_", "/", " "},
      {" ", "|", " ", "d", " ", "b", " ", " ", " "}
    },
    {
      {"L", "|", "J", "(", "_", ")", " ", " ", " "},
      {" ", "|", "(", "o", "o", " ", ")", " ", " "},
      {" ", "|", "0", "/", " ", "\\", "o", " ", "y"},
      {" ", "|", " ", "\\", "_", "/", "_", "/", " "},
      {" ", "|", " ", "d", " ", "b", " ", " ", " "}
    }
  };
  public static TextColor[][][] TinyCM =
  {
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.RED, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.RED, TextColor.ANSI.RED, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT}
    },
    {
      {new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.BLACK, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 255, 128), TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.RED, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    }
  };

  //  Sprite of SmallEnemy, or Skeleton (9x7)
  public static String SmallEnemy[][][] =
  {
    {
      {" ", " ", ".", "-", "-", "-", ".", " ", " "},
      {" ", "(", " ", " ", "_", " ", " ", ")", " "},
      {" ", " ", "\\", "_", "_", "_", "/", "@", " "},
      {" ", "/", "/", "{", "8", "}", "\\", "\\", "@"},
      {" ", "U", " ", "{", "8", "}", " ", "|", "@"},
      {" ", " ", "/", "/", " ", "\\", "\\", "@", " "},
      {" ", " ", "V", " ", " ", " ", "V", " ", " "}
    },
    {
      {" ", " ", ".", "-", "-", "-", ".", " ", " "},
      {" ", "(", "_", " ", "o", " ", "o", ")", " "},
      {" ", " ", " ", "\\", "W", "W", "/", "@", " "},
      {" ", "/", "/", "{", "8", "}", "\\", "|", "@"},
      {" ", "U", " ", "{", "8", "}", " ", "|", "@"},
      {" ", " ", "/", "/", " ", "\\", "\\", "@", " "},
      {" ", " ", "V", " ", " ", " ", "V", " ", " "}
    },
    {
      {" ", " ", ".", "-", "-", "-", ".", " ", " "},
      {" ", "(", " ", "o", " ", "o", " ", ")", " "},
      {" ", "@", "\\", "W", "w", "W", "/", " ", " "},
      {"@", "|", "/", "{", "8", "}", "\\", "\\", " "},
      {"@", "|", " ", "{", "8", "}", " ", "U", " "},
      {" ", "@", "/", "/", " ", "\\", "\\", " ", " "},
      {" ", " ", "V", " ", " ", " ", "V", " ", " "}
    },
    {
      {" ", " ", ".", "-", "-", "-", ".", " ", " "},
      {" ", "(", "o", " ", "o", " ", "_", ")", " "},
      {" ", "@", "\\", "W", "W", "/", " ", " ", " "},
      {"@", "|", "/", "{", "8", "}", "\\", "\\", " "},
      {"@", "|", " ", "{", "8", "}", " ", "U", " "},
      {" ", "@", "/", "/", " ", "\\", "\\", " ", " "},
      {" ", " ", "V", " ", " ", " ", "V", " ", " "}
    }
  };
  public static TextColor[][][] SmallCM =
  {
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    }
  };

  //  Sprite of MediumEnemy, or Bow Centaur (13x9 vertically, 19x9 horizontally)
  public static String MediumEnemy[][][] =
  {
    {
      {" ", " ", " ", " ", " ", "{", "_", "_", "}", " ", "@", " ", " "},
      {" ", " ", " ", " ", "_", "\\", " ", " ", "/", "_", "|", "@", " "},
      {" ", " ", " ", "/", ".", " ", "|", "|", " ", ".", "|", "@", " "},
      {" ", " ", ":", " ", "/", "\\", "'", "'", "/", "\\", "-", "@", " "},
      {" ", " ", "(", "J", ",", "'", "-", "-", "\\", " ", "|", "@", " "},
      {" ", "/", "/", " ", " ", " ", " ", " ", "|", " ", "@", " ", " "},
      {"/", "/", "/", "_", "/", ";", "/", "\\", "\\", " ", " ", " ", " "},
      {" ", "|", "/", "|", "|", "|", "/", "/", "/", " ", " ", " ", " "},
      {" ", "|", "|", "|", "|", "|", "/", "/", " ", " ", " ", " ", " "}
    },
    {
      {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "{", "v", "}", " ", " ", " ", "@", " ", " "},
      {" ", " ", " ", " ", " ", " ", " ", " ", " ", "_", "\\", "\"", "/", "_", " ", " ", "|", "@", " "},
      {" ", " ", " ", " ", " ", " ", " ", ".", "'", ".", "_", ".", "_", ".", "\\", "_", "|", "_", "@"},
      {" ", " ", " ", " ", " ", " ", ":", "/", " ", "\\", "{", "}", "/", "\\", "-", "-", "|", "-", "@"},
      {" ", "_", ".", "-", "-", "(", "J", "-", ",", "'", "-", "-", "\\", " ", " ", " ", "|", "@", " "},
      {"/", "/", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", " ", " ", " ", "@", " ", " "},
      {" ", "|", " ", "\\", "_", "/", "'", "-", "'", ";", "/", "\\", "\\", " ", " ", " ", " ", " ", " "},
      {" ", "|", "/", " ", "|", "|", " ", "|", "|", " ", "_", "/", "/", " ", " ", " ", " ", " ", " "},
      {" ", "|", "|", " ", "|", "|", " ", "|", "|", " ", "\\", "/", " ", " ", " ", " ", " ", " ", " "}
    },
    {
      {" ", " ", "@", " ", "{", "\\", "/", "}", " ", " ", " ", " ", " "},
      {" ", "@", "|", "_", "\\", "'", "'", "/", "_", " ", " ", " ", " "},
      {" ", "@", "|", ".", "_", "-", "-", "_", ".", "\\", " ", " ", " "},
      {" ", "@", "-", "/", "\\", "{", "}", "/", "\\", " ", ";", " ", " "},
      {" ", "@", "|", " ", "/", "-", "-", "'", ",", "J", ")", " ", " "},
      {" ", " ", "@", " ", "|", " ", " ", " ", " ", " ", "\\", "\\", " "},
      {" ", " ", " ", " ", "/", "/", "\\", ";", "\\", "_", "/", "\\", "\\"},
      {" ", " ", " ", " ", "\\", "\\", "\\", "|", "|", "|", "\\", "|", " "},
      {" ", " ", " ", " ", " ", "\\", "\\", "|", "|", "|", "|", "|", " "}
    },
    {
      {" ", " ", "@", " ", " ", " ", "{", "v", "}", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
      {" ", "@", "|", " ", " ", "_", "\\", "\"", "/", "_", " ", " ", " ", " ", " ", " ", " ", " ", " "},
      {"@", "_", "|", "_", "/", ".", "_", ".", "_", ".", "'", ".", " ", " ", " ", " ", " ", " ", " "},
      {"@", " ", "-", "-", "-", "/", "\\", "{", "}", "/", " ", "\\", ":", " ", " ", " ", " ", " ", " "},
      {" ", "@", "|", " ", " ", " ", "/", "-", "-", "'", ",", "-", "J", ")", "-", "-", ".", "_", " "},
      {" ", " ", "@", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", "\\"},
      {" ", " ", " ", " ", " ", " ", "/", "/", "\\", ";", "'", "-", "'", "\\", "_", "/", " ", "|", " "},
      {" ", " ", " ", " ", " ", " ", "\\", "\\", "_", " ", "|", "|", " ", "|", "|", " ", "\\", "|", " "},
      {" ", " ", " ", " ", " ", " ", " ", "\\", "/", " ", "|", "|", " ", "|", "|", " ", "|", "|", " "}
    }
  };
  public static TextColor[][][] MediumCM =
  {
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(115, 77, 38)},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), TextColor.ANSI.BLACK, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.BLACK, new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT}
    },
    {
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), new TextColor.RGB(255, 221, 153), TextColor.ANSI.WHITE, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(255, 221, 153), new TextColor.RGB(255, 221, 153), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51)},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.BLACK, new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT},
      {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT, new TextColor.RGB(153, 102, 51), new TextColor.RGB(153, 102, 51), TextColor.ANSI.DEFAULT}
    }
  };

  //  Sprite of LargeEnemy, or Dragon (25x11 vertically, 31x11 horizontally)
  public static String LargeEnemy[][][] =
    {
      {
        {" ", " ", " ", " ", ".", "-", "-", ".", " ", " ", " ", " ", " ", " ", " ", " ", ".", "-", "-", ".", " ", " ", " ", " ", " "},
        {" ", " ", " ", "/", "/", "`", "^", "\\", "\\", " ", " ", " ", " ", " ", " ", "/", "/", "^", "`", "\\", "\\", " ", " ", " ", " "},
        {" ", " ", "/", "/", " ", "^", " ", "^", "\\", "(", "\\", "_", "_", "/", ")", "/", "^", " ", "^", "^", "\\", "\\", " ", " ", " "},
        {" ", "/", "/", "^", " ", "^", "^", " ", "^", "\\", "\\", "_", "_", "/", "/", " ", "^", "^", " ", "^", "^", "\\", "\\", " ", " "},
        {"/", "/", "^", "_", "^", "^", "_", "^", " ", " ", "\\", "_", "_", "/", " ", "^", "_", "^", "^", "^", "_", "^", "\\", "\\", " "},
        {"\\", "`", "/", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", "\\", "`", "/", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", "/", " ", " ", " ", " ", " ", " ", "\\", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", "/", " ", " ", ",", " ", " ", ",", " ", " ", "\\", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "(", " ", " ", "(", " ", " ", " ", " ", ")", " ", " ", ")", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "_", "\\", " ", " ", "\\", " ", " ", "/", " ", " ", "/", "_", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "(", "(", "(", "'", ".", "_", "=", "=", "_", ".", "'", ")", ")", ")", " ", " ", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "/", "`", " ", "`", "\\", "\\", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "/", "`", "/", "`", "`", "\\", " ", "\\", "\\", " ", " ", " ", "%", "/", "\"", "-", ",", "_", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", "/", "`", "/", "`", " ", "{", " ", " ", "\\", " ", "\\", "\\", " ", "%", "|", " ", "o", " ", " ", "_", "<", " "},
        {" ", " ", " ", " ", " ", " ", " ", "/", "`", "/", "`", "{", " ", "{", " ", " ", "{", " ", "\\", " ", "\\", "\\", "%", "(", " ", " ", "(", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", "\\", "`", "/", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", ".", "\\", "'", "\\", "%", ")", " ", " ", "\\", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", "`", "_", ".", "-", "`", " ", " ", " ", " ", " ", " ", " ", " ", " ", "'", " ", " ", " ", " ", ")", " ", " "},
        {"<", "%", ";", "-", ".", "_", "_", ".", "-", "`", "_", " ", " ", " ", "/", " ", " ", ")", " ", " ", " ", " ", " ", ",", " ", " ", " ", "/", " ", " ", " "},
        {" ", " ", " ", "`", "'", "-", ".", ".", "-", "`", " ", "\"", ".", "/", " ", "/", "`", " ", " ", " ", " ", " ", " ", "/", " ", "/", "`", "_", "\\", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", "_", "\\", "`", "'", "-", "=", "-", "'", "`", "\\", "_", "\\", " ", "`", "`", "`", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "`", "`", "`", " ", " ", " ", " ", " ", " ", " ", "`", "`", "`", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", ".", "-", "-", ".", " ", " ", " ", " ", " ", " ", " ", " ", ".", "-", "-", ".", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", "/", "`", "^", "\\", "\\", " ", " ", " ", " ", " ", " ", "/", "/", "^", "`", "\\", "\\", " ", " ", " "},
        {" ", " ", " ", "/", "/", " ", "^", " ", "^", "\\", "(", "\\", "_", "_", "/", ")", "/", "^", " ", "^", "^", "\\", "\\", " ", " "},
        {" ", " ", "/", "/", "^", " ", "^", "^", " ", "^", "/", "o", " ", " ", "o", "\\", " ", "^", "^", " ", "^", "^", "\\", "\\", " "},
        {" ", "/", "/", "^", "_", "^", "^", "_", "^", " ", "(", ".", "_", "_", ".", ")", " ", "^", "_", "^", "^", "^", "_", "\\", "\\"},
        {" ", "\\", "`", "/", "\\", "_", "/", "\\", "_", "/", "/", " ", " ", " ", " ", "\\", "\\", "_", "/", "\\", "_", "/", "\\", "`", "/"},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", "/", " ", " ", " ", " ", " ", " ", "\\", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", "/", " ", ",", " ", " ", " ", " ", ",", " ", "\\", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", "(", " ", "(", " ", " ", " ", " ", " ", " ", ")", " ", ")", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", "\\", " ", "\\", ".", "_", "_", ".", "/", " ", "/", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", "(", "(", "(", "`", " ", " ", "'", ")", ")", ")", " ", " ", " ", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "_", " ", "_", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "_", " ", " ", " ", " ", " ", "/", "/", "`", " ", "`", "\\", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", "_", ",", "-", "\"", "\\", "%", " ", " ", " ", "/", "/", " ", "/", "`", "`", "\\", "`", "\\", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", ">", "_", "_", " ", "o", " ", "|", "%", " ", "/", "/", " ", "/", " ", " ", "}", " ", "`", "\\", "`", "\\", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", ")", " ", " ", ")", "%", "/", "/", " ", "/", " ", "}", " ", " ", "}", " ", "}", "`", "\\", "`", "\\", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", "/", " ", " ", "(", "%", "/", "'", "/", ".", "\\", "_", "/", "\\", "_", "/", "\\", "_", "/", "\\", "`", "/", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", "(", " ", " ", " ", " ", "'", " ", " ", " ", " ", " ", " ", " ", " ", " ", "`", "-", ".", "_", "`", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", "\\", " ", " ", " ", ",", " ", " ", " ", " ", " ", "(", " ", " ", "\\", " ", " ", " ", "_", "`", "-", ".", "_", "_", ".", "-", ";", "%", ">"},
        {" ", " ", "/", "_", "`", "\\", " ", "\\", " ", " ", " ", " ", " ", " ", "`", "\\", " ", "\\", ".", "\"", " ", "`", "-", ".", ".", "-", "'", "`", " ", " ", " "},
        {" ", "`", "`", "`", " ", "/", "_", "/", "`", "'", "-", "=", "-", "'", "`", "/", "_", "/", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "`", "`", "`", " ", " ", " ", " ", " ", " ", " ", "`", "`", "`", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
      }
    };
  public static TextColor[][][] LargeCM =
    {
      {
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT},
        {new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0) , TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
      },
      {
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
      },
      {
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(0, 102, 0), TextColor.ANSI.WHITE, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.WHITE, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0)},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0)},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
      },
      {
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, new TextColor.RGB(102, 255, 102), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), TextColor.ANSI.BLACK, new TextColor.RGB(153, 255, 153), new TextColor.RGB(102, 255, 102), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(102, 255, 102), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0)},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.BLACK, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), new TextColor.RGB(0, 102, 0), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
        {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
      }
    };

    //  Sprite of BossOne, or Grim Reaper (21x17)
  public static String BossOne[][][] =
    {
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", "_", "_", "_", "_", ",", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {"/", ".", "-", "-", "-", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {"`", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", "_", "_", "_", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "(", "=", "\\", ".", " ", " ", "/", " ", " ", " ", "\\", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", "\\", "/", "\\", "_", "H", " ", " ", " ", "H", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", "_", "\\", " ", "|", "\\", " ", " ", " ", "/", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", "/", " ", "\\", "/", "/", "-", "\\", "\\", "_", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", ")", "/", "\\", "/", " ", " ", " ", "|", " ", "\\", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", "(", "'", "|", " ", " ", " ", "|", " ", "|", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", " ", "\\", "|", " ", " ", " ", "/", " ", "\\", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", "\\", "_", "_", "_", "\\", " ", " ", "\\", " ", " ", " "},
        {" ", " ", " ", " ", " ", "\\", " ", " ", " ", " ", "/", " ", " ", " ", "\\", ".", "-", "-", "\\", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", " ", " ", "|", " ", " ", " ", " ", " ", "(", "|", "\\", "`", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", " ", "/", " ", " ", " ", " ", " ", " ", " ", "\\", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", "'", ".", " ", " ", " ", " ", " ", " ", " ", ".", "'", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "\\", " ", "'", ".", "_", ".", "-", ".", "_", ".", "'", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ",", "_", "_", "_", "_", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "-", "-", "-", ".", "\\"},
        {" ", " ", " ", " ", " ", " ", " ", "_", "_", "_", " ", " ", " ", " ", " ", "|", " ", " ", " ", " ", "`"},
        {" ", " ", " ", " ", " ", " ", "/", " ", ".", "-", "\\", " ", " ", ".", "/", "=", ")", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", "|", "\"", "|", "_", "/", "\\", "/", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", ";", " ", " ", "|", "-", ";", "|", " ", "/", "_", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", " ", "\\", "_", "|", " ", "|", "/", " ", "\\", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", "/", " ", " ", " ", " ", " ", " ", "\\", "/", "\\", "(", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", "|", " ", " ", " ", "/", " ", " ", "|", "`", " ", ")", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", "/", " ", " ", " ", "\\", " ", "_", "/", " ", " ", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", "/", "-", "-", ".", "_", "/", " ", " ", "\\", " ", " ", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", "`", "/", "|", ")", " ", " ", " ", " ", "|", " ", " ", " ", " ", "/", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", " ", " ", " ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " ", " ", " ", " "},
        {" ", " ", ".", "'", " ", " ", " ", " ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " ", " ", " ", " "},
        {" ", "/", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", " ", " ", "|", " ", " ", " ", " ", " ", " "},
        {"(", "_", ".", "-", ".", "_", "_", ".", "_", "_", ".", "/", " ", " ", "/", " ", " ", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", ",", "_", "_", "_", "_", " "},
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "|", "-", "-", "-", ".", "\\"},
        {" ", " ", " ", " ", " ", " ", " ", "_", "_", "_", " ", " ", " ", " ", " ", "|", " ", " ", " ", " ", "`"},
        {" ", " ", " ", " ", " ", " ", "/", ".", "-", ".", "\\", " ", " ", ".", "/", "=", ")", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "H", " ", "\"", " ", "H", "_", "/", "\\", "/", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "\\", "\\", "_", "/", "/", "|", " ", "/", "_", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "_", "/", "/", "-", "\\", "\\", "/", " ", "\\", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", " ", "|", " ", " ", " ", "\\", "/", "\\", "(", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "|", " ", "|", " ", " ", " ", "|", "'", ")", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", " ", "\\", " ", " ", " ", "|", "/", " ", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", "/", " ", " ", "/", "_", "_", "_", "/", " ", " ", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", "/", "-", "-", ".", "/", " ", " ", " ", "\\", " ", " ", " ", " ", "/", " ", " ", " ", " ", " "},
        {" ", " ", "`", "/", "|", ")", " ", " ", " ", " ", " ", "|", " ", " ", "|", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "/", " ", " ", " ", " ", " ", " ", " ", "\\", " ", "|", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", "'", ".", " ", " ", " ", " ", " ", " ", " ", ".", "'", "|", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "'", ".", "_", ".", "-", ".", "_", ".", "'", " ", "/", " ", " ", " ", " ", " ", " "}
      },
      {
        {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", "_", "_", "_", "_", ",", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {"/", ".", "-", "-", "-", "|", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {"`", " ", " ", " ", " ", "|", " ", " ", " ", " ", " ", "_", "_", "_", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", "(", "=", "\\", ".", " ", " ", "/", "-", ".", " ", "\\", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", "\\", "/", "\\", "_", "|", "\"", "|", " ", " ", "|", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", "_", "\\", " ", "|", ";", "-", "|", " ", " ", ";", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", "/", " ", "\\", "|", " ", "|", "_", "/", " ", "\\", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", ")", "/", "\\", "/", " ", " ", " ", " ", " ", " ", "\\", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", "(", " ", "'", "|", " ", " ", "\\", " ", " ", " ", "|", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", "\\", "_", " ", "/", " ", " ", " ", "\\", " ", " ", " "},
        {" ", " ", " ", " ", " ", "|", " ", " ", " ", " ", "/", " ", " ", "\\", "_", ".", "-", "-", "\\", " ", " "},
        {" ", " ", " ", " ", " ", "\\", " ", " ", " ", " ", "|", " ", " ", " ", " ", "(", "|", "\\", "`", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " ", " ", " ", "\\", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", " ", " ", " ", "|", " ", " ", " ", " ", " ", " ", "'", ".", " ", " "},
        {" ", " ", " ", " ", " ", " ", "|", " ", " ", "/", " ", " ", " ", " ", " ", " ", " ", " ", " ", "\\", " "},
        {" ", " ", " ", " ", " ", " ", "\\", " ", " ", "\\", ".", "_", "_", ".", "_", "_", ".", "-", ".", "_", ")"}
      }
    };
    public static TextColor[][][] BossOneCM =
      {
        {
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
        },
        {
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
        },
        {
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT}
        },
        {
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.WHITE, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.WHITE, TextColor.ANSI.WHITE, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.DEFAULT},
          {TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, new TextColor.RGB(115, 77, 38), TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK, TextColor.ANSI.BLACK}
        }
      };
    public static String pistol[][][] = {
      {
        {}
      }
    };
    public static String smg[][][] = {{{}}};
    public static String rifle[][][] = {{{}}};
    public static void main(String[] args) throws InterruptedException, IOException {
    /*  for (String[][] x : Player) {
        for (String[] y : x) {
          for (String z : y) {
            System.out.print(z);
          }
          System.out.println();
        }
        System.out.println();
      } */

    Screen screen = new DefaultTerminalFactory().createScreen();
    String[][][] model = Player;
    TextColor[][][] modelCM = PlayerCM;
		screen.startScreen();
    int countRows = 1;
    int countCols = 0;
    TextCharacter chr = new TextCharacter('h', TextColor.ANSI.DEFAULT, TextColor.ANSI.DEFAULT, SGR.BOLD);
    for (int x = 0; x < model.length; x++) {
      for (int y = 0; y < model[x].length; y++) {
        for (int z = 0; z < model[x][y].length; z ++) {
          chr = new TextCharacter(model[x][y][z].charAt(0), modelCM[x][y][z], TextColor.ANSI.DEFAULT, SGR.BOLD);
            if (z == model[x][y].length - 1) {
              screen.setCharacter(countCols, countRows, chr);
              countRows += 1;
              countCols = 0;
              if (y == model[x].length - 1) countRows += 1;
            }
            else {
              screen.setCharacter(countCols, countRows, chr);
              countCols++;
            }
            screen.refresh();
        }
      }
    }
		//Thread.sleep(3000);
    //screen.close();
  }
}
