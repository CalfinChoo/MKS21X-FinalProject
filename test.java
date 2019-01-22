
// javac -cp "lanterna(3).jar;." test.java && java -cp "lanterna(3).jar;." test
public class test{
  public static String SmallEnemyBullet = "0";
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
	public static void main(String[] args) {
	 String[][] guy = {
      {"_", "/", "X", "X", "X", "\\", "_"},
      {"(", " ", " ", "o", "~", "o", ")"},
      {"/", "\\", "X", "X", "/", ";", "="},
      {"V", "/", "/", "\\", "\\", " ", " "},
      {" ", "H", "b", " ", "H", "b", " "}
    };
    printView(guy);
  }
}