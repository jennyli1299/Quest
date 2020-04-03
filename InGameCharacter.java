// import java.util.Random;
// import java.util.*;

public abstract class InGameCharacter {
    protected String name;
    protected String type;
    protected int lvl;
    protected int exp;
    protected int maxhp;
    protected int hp;
    protected int strength;
    protected int defense;
    protected int agility;

    public void levelup() {
        if (this.exp >= lvl*10) {
        hp = maxhp;
        strength = (int)(strength*1.05);
        defense = (int)(defense*1.05);
        agility = (int)(agility*1.05);
        }
    }
    public int getLVL() {
        return lvl;
    }
    public int getHealth() {
        return hp;
    }
    public void gainEXP() {
        //fill
        this.exp += 2;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public void attack(InGameCharacter c) {
        // Random rand = new Random();
        // int dodgechance = rand.nextInt(2);
        if (c.type.equals("Monster")) {
            if (Math.random() <= c.agility/100) {
                System.out.println(c.name + " DODGED " + this.name + "'s attack!");
            }
            else {
                int dmg = (int)((this.strength-c.defense)*0.05); // CHANGED FROM 0.05 TO 0.5
                c.updhp(dmg);
                System.out.println(this.name + "'s attack was EFFECTIVE!" + " " + c.getName() + " has taken " + Integer.toString(dmg) + " damage.");
            }
        }
        else {
            if (Math.random() <= c.agility*0.0002) { //0.02
                System.out.println(c.name + " DODGED " + this.name + "'s attack!");
            }
            else {
                int dmg = (int)((this.strength-c.defense)*0.05); // CHANGED FROM 0.05 TO 0.5
                c.updhp(dmg);
                System.out.println(this.name + "'s attack was EFFECTIVE!" + " " + c.getName() + " has taken " + Integer.toString(dmg) + " damage.");
            }
        }
    }
    public void updhp (int h) {
        if (h > 0) {
            this.hp -= h;
        }
        if (this.hp <=0 ) {
        //PRINT STATEMENT
        System.out.println(this.name + " has FAINTED!");
        }
    }
    public abstract void reward();
    // public abstract void levelup();

    public boolean equals(InGameCharacter c) {
        return (this.name.equals(c.name));
    }
}