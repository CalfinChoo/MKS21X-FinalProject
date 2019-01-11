public class Bullet{
  private Coordinate coord;
  private static int damage;
  private static int speed;
  private static boolean friendly;
  private static double slope;
  public Bullet(Coordinate startCoord, int dam, int spe, boolean fri, double slo){
    coord = startCoord;
    damage = dam;
    speed = spe;
    friendly = fre;
    slope = slo;
  }
  public boolean getGood() {
    return friendly;
  }
  public int getSpeed() {
    return speed;
  }
  public int dealDamage(Person p) {
    return p.recieveDamage(damage);
    this = null;
  }
}
