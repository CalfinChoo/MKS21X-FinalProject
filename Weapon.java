public class Weapon {
  public static BulletType bullet;
  private static int rateOfFire;
  private static String[][][] graphic;
  public static String weaponName;
  public Weapon(BulletType bull, int rof, String[][][] graph, String wName){
    bullet = bull; rateOfFire = rof; graphic = graph; weaponName = wName;
  }
  public void shoot(Coordinate coord, double slope){
    Bullet b = new Bullet(coord, bullet, slope);
  }
}
