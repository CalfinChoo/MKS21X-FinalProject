
/*
*
* Contains all the attributes, properties, and functions pertaining to the player.
*
*/

public class Player{
  private int health;
  private int maxHealth;
  private Coordinate coord;
//  Constructs a player
  public Player(int mHea, Coordinate pos) {
    maxHealth = mHea;
    health = maxHealth;
    coord = pos;
  }
//  Get and set commands for player
  public Coordinate getCoord() {
    return coord;
  }
  public int getMaxHealth() {
    return maxHealth;
  }
  public void setCoord(Coordinate pos) {
    coord = pos;
  }
  public int getHealth() {
    return health;
  }
//  Regeneration command
  public void addToHealth(int increment) {
    health += increment;
  }
//  Command to take damage / reduce health
  public void recieveDamage(Bullet inflictor) {
      health -= inflictor.getDamage();
  }
}
