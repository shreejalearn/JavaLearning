package Day1;
public class Javamon {
    private String name;
    private int health;
    private int strength;
    private double accuracy;

    public Javamon(String name) {
        this.name=name;
        this.health=100;
        this.strength=20;
        this.accuracy=.8;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getStrength(){
        return this.strength;
    }

    public double getAccuracy(){
        return this.accuracy;
    }

    public void setHealth(int health){
        if(health<0){
            this.health=0;
        }
        else{
            this.health=health;
        }
    }

    public void setName(String name){
        this.name=name;
    }

    public void setStrength(int strength){
        if(strength<=0){
            this.strength=1;
        }
        else{
            this.strength=strength;
        }
    }

    public void setAccuracy(double accuracy){
        if(accuracy>=0.01 && accuracy<=1.0){
            this.accuracy=accuracy;
        }
        else if(accuracy<0.01){
            this.accuracy=0.01;
        }

        else if(accuracy>1){
            this.accuracy=1;
        }
    }

    public String toString(){
        return this.name+" ["+this.health+"]";
    }

    public void takeDamage(int damage){
        if(damage>this.health){
            this.health=0;
        }
        else{
            this.health-=damage;
        }
    }

    public Boolean isDefeated(){
        if(this.health==0){
            return true;
        }
        return false;
    }

    public int calculateAttackDamage(){
        int damage = (int) (Math.random() * strength) + 1;
        return damage;
    
    }
    public boolean calculateAttackSuccess() {
        double random = Math.random();
        if (random <= accuracy) {
            return true;
        } else {
            return false;
        }
    }    

    public String attemptAttack(Javamon enemy) {
        if (this.calculateAttackSuccess()) {
            int damage = this.calculateAttackDamage();
            if( damage > enemy.health){
                enemy.health = 0;
            }
            else{
                enemy.health-=damage;
            }
            return this.name + " attacks " + enemy.name + " and deals " + damage + " damage.";
        } 
        else {
            return this.name + " attacks " + enemy.name + " - but the attack misses!";
        }
    }    
}
