public class Player extends Person{
  private int health;
  private int maxHealth;
  private Coordinate myPos;
  private Weapon weapon;
  private int facing;
  public Player(int mHea, Coordinate initialPos, Weapon defaultWeap, int initialDir) {
    maxHealth = mHea;
    health = maxHealth;
    myPos = initialPos;
    weapon = defaultWeap;
    facing = initialDir;
  }
  public int recieveDamage(int dam) {
    health -= dam;
  }
}
