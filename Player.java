public class Player extends Person{
  private int health;
  private int maxHealth;
  private Coordinate coord;
  public Player(int mHea, Coordinate pos) {
    maxHealth = mHea;
    health = maxHealth;
    coord = pos;
  }
  public Coordinate getCoord() {
    return coord;
  }
  public int getMaxHealth() {
    return maxHealth;
  }
  public void addToHealth(int increment) {
    health += increment;
  }
  public void setCoord(Coordinate pos) {
    coord = pos;
  }
  public int getHealth() {
    return health;
  }
  public void recieveDamage(Bullet inflictor) {
      health -= inflictor.getDamage();
  }
}
