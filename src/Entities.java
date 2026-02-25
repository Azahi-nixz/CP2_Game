public class Entities {
    static String finalStats = "";
    static String finalName = "";
    static int exp = 0;
    static int finalExp = 0;
    static int level = 0;
    static int ATK = 0;
    static int DEF = 0;
    static int HP = 0;
    static int MP = 0;
    static int ACC = 0;
    static int SPD = 0;
    static int SANITY = 0;
    static int damage = 0;
    static int turn = 0;

   public boolean checkHit(String attacker) {
       double chance = (double) ATK / (ATK + SPD);
       return Math.random() < chance;
    }

    public static int calculateDamage() {

        damage = ATK - (DEF / 2);
        if (damage < 1) { damage = 1; }

        return damage;
    }

}
