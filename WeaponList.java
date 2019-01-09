public class WeaponList {
  public static Weapon[] weapons;
  public static int numWeapons = 3;
  WeaponList(){
    Weapons = new Weapon[numWeapons];
    Weapons[0] = new Weapon(new Bullet(), 3, Graphics.pistol, "pistol");
  }
}
