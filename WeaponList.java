public class WeaponList {
  public static Weapon[] weapons;
  public static int numWeapons = 3;
  public WeaponList(){
    BulletType pistolBullet = new BulletType(1, 3, true); //BulletType(damage, speed, friendly?)
    BulletType smgBullet = new BulletType(3, 5, true);
    BulletType rifleBullet = new BulletType(5, 7, true);
    Weapon[] w = new Weapon[numWeapons];
    w[0] = new Weapon(pistolBullet, 3, Graphics.pistol, "pistol"); //Weapon(BulletType, rate of fire, graphic, weapon name)
    w[1] = new Weapon(smgBullet, 9, Graphics.smg, "smg");
    w[2] = new Weapon(rifleBullet, 9, Graphics.rifle, "rifle");
  }
}
