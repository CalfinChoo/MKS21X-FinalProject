public class Bullet{
  private Coordinate coord;
  private static BulletType bull;
  private static double slope;
  public Bullet(Coordinate startCoord, BulletType b, double slo){
    coord = startCoord;
    bull = b;
    slope = slo;
  }
  public int dealDamage(Person p) {
    return p.recieveDamage(bull.getDamage());
  }
  public Coordinate move() {
    
  }
}
