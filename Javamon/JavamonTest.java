package Day1;
public class JavamonTest {
  
    public static void testDefaultGets() {
      System.out.println("TEST: Constructor # 1/ Default data fields / Getters / toString.");
  
      Javamon j = new Javamon("MYNAME");
      System.out.println(j);
      if (j.getHealth() != 100)
        throw new RuntimeException("After instantiation, getHealth returns " + j.getHealth() + "; default should be 100, set in constructor");
  
      if (j.getStrength() != 20)
        throw new RuntimeException("After instantiation, getStrength returns " + j.getStrength() + "; default should be 20, set in constructor");
   
      if (j.getAccuracy() != .8)
        throw new RuntimeException("After instantiation, getAccuracy returns " + j.getAccuracy() + "; default should be .8, set in constructor");

        if (!j.toString().equals("MYNAME [100]"))
        throw new RuntimeException("toString returns \"" + j + "\"; not proper format/showing default health, should be \"MYNAME [100]\"");
  
      System.out.println("\tPASSED!");
    }
    
    public static void testValidSetsAndGets(){
      System.out.println("TEST: Getters & Setters (valid inputs).");
  
      Javamon j = new Javamon("MYORIGNAME");
      j.setName("MYNEWNAME");
      if(!j.getName().equals("MYNEWNAME"))
        throw new RuntimeException("Getter/Setter for name doesn't work");
  
      j.setHealth(1234);
      if (j.getHealth() != 1234)
        throw new RuntimeException("Getter/Setter for health doesn't work");
  
      j.setStrength(1234);
      if (j.getStrength() != 1234)
        throw new RuntimeException("Getter/Setter for strength doesn't work");
  
      j.setAccuracy(.125);
      if (j.getAccuracy() != .125)
        throw new RuntimeException("Getter/Setter for accuracy doesn't work");
  
      if (!j.toString().equals("MYNEWNAME [1234]"))
        throw new RuntimeException("toString returns \"" + j + "\"; not showing updated name/health (or of proper format), should be \"MYNEWNAME [1234]\"");
  
      System.out.println("\tPASSED!");
  
    }
    
    
    public static void testInvalidSetsAndGets(){
      System.out.println("TEST: Setters (handling invalid inputs).");
  
      Javamon j = new Javamon("MYNAME");
      j.setHealth(-1);
      if (j.getHealth() != 0)
        throw new RuntimeException("setHealth allows negative values; should enforce minimum of 0 health.");
        
      j.setStrength(0);
      if (j.getStrength() != 1)
        throw new RuntimeException("setStrength allows non-positive values; should enforce minimum of 1 strength.");
  
      j.setAccuracy(.009);
      if (j.getAccuracy() != .01)
        throw new RuntimeException("setAccuracy allows values less than 1%; should enforce minimum of 1% accuracy.");
  
      j.setAccuracy(1.1);
      if (j.getAccuracy() != 1.0)
        throw new RuntimeException("setAccuracy allows values above 100%; should enforce maximum of 100% accuracy.");
  
      if (!j.toString().equals("MYNAME [0]"))
        throw new RuntimeException("toString returns \"" + j + "\"; not showing updated name/health (or of proper format), should be \"MYNAME [0]\"");
  
      System.out.println("\tPASSED!");
  
    }
    
    public static void testTakeDamageDefeated(){
  
      System.out.println("TEST: takeDamage / isDefeated.");
  
      Javamon j = new Javamon("MYNAME");
      
      j.setHealth(10);
      j.takeDamage(9);
      if (j.getHealth() != 1)
        throw new RuntimeException("takeDamage does not reduce health properly when taking damage less than health.");
  
      if (j.isDefeated() )
        throw new RuntimeException("isDefeated incorrectly states being defeated at 1 health.");
  
      j.setHealth(10);
      j.takeDamage(10);
      if (j.getHealth() != 0)
        throw new RuntimeException("takeDamage does not reduce health to 0 when taking damage equal to health.");
  
      if (!j.isDefeated())
        throw new RuntimeException("isDefeated incorrectly states being undefeated at 0 health.");
  
      j.setHealth(10);
      j.takeDamage(11);
      if (j.getHealth() != 0)
        throw new RuntimeException("takeDamage does not reduce health to 0 when taking damage greater than health.");
  
      if (!j.isDefeated())
        throw new RuntimeException("isDefeated incorrectly states being undefeated at 0 health.");
      
      System.out.println("\tPASSED!");
    }
    
    public static void testCalculateAttackStrength(int strength){
      System.out.println("TEST: calculateAttackStrength");
  
      // Passing this test does not guarantee fully working, 
      // only basic sanity checks.
      // Check report to get a better idea of how things are working.
  
      int TRIALS = 10000;
      Javamon j = new Javamon("MYNAME");
  
      j.setStrength(strength);
      int totalDamage = 0;
      for (int i = 0; i < TRIALS; i++){
  
        int damage = j.calculateAttackDamage();
  
        if (damage <= 0){
          throw new RuntimeException("calculateAttackDamage returned nonpositive damage; should never do this");
        }
  
        if (damage > strength){
          throw new RuntimeException("calculateAttackDamage returned damage greater than strength; should never do this");
        }
  
        totalDamage += damage;
      }
      System.out.println("\tPASSED...? Check REPORT:");
  
      System.out.printf("\tcalculateAttackDamage with %d strength over %d trials: Average %.1f\n", strength, TRIALS, (double) totalDamage / TRIALS);
    }
  
    public static void testCalculateAttackSuccess(double accuracy){
  
      System.out.println("TEST: calculateAttackSuccess");
  
      // Check report to get a better idea of how things are working.
  
      int TRIALS = 1000000;
      Javamon j = new Javamon("MYNAME");
  
      j.setAccuracy(accuracy);
      int totalHits = 0;
      for (int i = 0; i < TRIALS; i++){
  
        boolean hit = j.calculateAttackSuccess();
  
        if (hit)
          totalHits ++;
      }
  
      if (totalHits == 0){
        throw new RuntimeException("calculateAttackSuccess always returns false.");
      }
  
      if (totalHits == TRIALS && accuracy != 1){
        throw new RuntimeException("calculateAttackDamage always returns true.");
      }
      
      System.out.println("\tPASSED...? Check REPORT:");
  
      System.out.printf("\tcalculateAttackSuccess with %.2f accuracy over %d trials: %d are trues\n", accuracy, TRIALS, totalHits);
    }
  
    public static void testAttemptAttack(int strength, double accuracy){
      System.out.println("TEST: attemptAttack");
  
      // Passing this test does not guarantee fully working, 
      // only basic sanity checks.
      // Check report to get a better idea of how things are working.
  
      int TRIALS = 10000;
  
      Javamon j = new Javamon("Attacker");
      Javamon j2 = new Javamon("Defender");
      int enemyHealth = strength * 2;
  
      //Run 1 - check valid attack damages (100% accuracy)
      j.setHealth(100);
      j.setStrength(strength);
      j.setAccuracy(1);
      for (int i = 0; i < TRIALS; i++){
        j2.setHealth(enemyHealth);
        j.attemptAttack(j2);
        int damage = enemyHealth - j2.getHealth(); 
        
        if (damage < 0 )
          throw new RuntimeException("attemptAttack caused negative damage; should never do this");
  
        if (damage == 0 )
          throw new RuntimeException("attemptAttack caused 0 damage at 100% accuracy; should not ever miss");
  
        if(damage > strength)
          throw new RuntimeException("attemptAttack caused " + damage + " at 10 strength; should not deal more damage than strength");
  
        if (j.getHealth() != 100)
          throw new RuntimeException("attemptAttack changed the attacker's health; only the defender's health should change");
  
        j2.setHealth(1);
        j.attemptAttack(j2);
        
        if (j2.getHealth() < 0 )
          throw new RuntimeException("attemptAttack caused enemy health to become negative; should never do this");
  
      }
  
      System.out.println("\tPASSED...? Check REPORT:");
  
      //Run 2 - try attacking with given accuracy
      j.setStrength(strength);
      j.setAccuracy(accuracy);
      int countMisses = 0;
      int totalDamage = 0;
      for (int i = 0; i < TRIALS; i++){
        j2.setHealth(enemyHealth);
        
        j.attemptAttack(j2);
  
        int damage = enemyHealth - j2.getHealth(); 
  
        if (damage == 0) {
          countMisses++;
        }
        else 
          totalDamage += damage;
         
      }
      int countHits = TRIALS - countMisses;
      System.out.printf("\t%d attacks @ Str: %d & Acc: %.2f:\n\tHits: %d | Misses: %d\n\tAverage Damage dealt on hit: %.1f\n", 
                            TRIALS, strength, accuracy, countHits, countMisses, (double) totalDamage/countHits);
  
    }
      
    public static void main(String[] args){
      testDefaultGets();
      
      testValidSetsAndGets();
      
      testInvalidSetsAndGets();
      
      testTakeDamageDefeated();
      
      //You may change the parameters of the following tests.
  
      testCalculateAttackStrength(50);
  
      testCalculateAttackSuccess(.75);
      
      testAttemptAttack(100, .5);
  
    }
    
  }