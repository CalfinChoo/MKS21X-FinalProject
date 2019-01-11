public class Weapon {
  public static Bullet bullet;
  private static int rateOfFire;
  private static String[][][] graphic;
  public static String weaponName;
  public Weapon(Bullet bulletType, int rof, String[][][] graph, String weaponName){
    bullet = bulletType; rateOfFire = rof; graphic = graph; this.weaponName = weaponName;
  }
  public void shoot(Coordinate coord){

  }

}
