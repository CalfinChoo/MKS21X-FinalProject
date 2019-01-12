public class BulletType {
  private static int damage;
  private static int speed;
  private static boolean friendly;
  public int getDamage() {
    return damage;
  }
  public int getSpeed() {
    return speed;
  }
  public boolean getFriendly() {
    return friendly;
  }
  public BulletType(int d, int s, boolean f) {
    damage = d;
    speed = s;
    friendly = f;
  }
}
