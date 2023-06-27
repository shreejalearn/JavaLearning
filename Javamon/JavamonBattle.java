package Day1;
import java.util.Scanner;

public class JavamonBattle {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Javamon j1 = new Javamon("FirstJavamon");
    Javamon j2 = new Javamon("SecondJavamon");
    
    prepare(j1, j2, input);

    battle(j1, j2, input);

  }

  public static void battle(Javamon j1, Javamon j2, Scanner input) {
    
    System.out.printf("\n%s challenges %s to a battle!\n", j1.getName(), j2.getName());
        
    int turn = 1;
    
    // As long as neither Javamon instances are defeated...
    while ( ! ( j1.isDefeated() || j2.isDefeated() )) {
            
      //On odd turns, j1 attacks j2. On even turns, j2 attacks j1.
      //Set the attacker/defender variables to refer to the appropriate Javamon instances.
      
      Javamon attacker;
      Javamon defender;
      if (turn % 2 == 1) {
        attacker = j1;
        defender = j2;
      }
      else {
        attacker = j2;
        defender = j1;
      }

      System.out.printf("\nTurn %d: %s prepares to attack %s!\n", turn, attacker, defender);

      System.out.println("Press <enter> to attack!");
      input.nextLine(); 

      String report = attacker.attemptAttack(defender);
      System.out.println(report);

      //next turn
      turn++;

    }

    //Fight conclusion: Determine who was defeated and report the winner.
    if (j1.isDefeated())
      System.out.println(j1.getName() + " is defeated! " + j2.getName() + " wins!");
    else
      System.out.println(j2.getName() + " is defeated! " + j1.getName() + " wins!");

  }

  public static void prepare(Javamon j1, Javamon j2, Scanner input) {
    
    System.out.printf("Enter Javamon #1's name: ");
    j1.setName(input.nextLine());
    System.out.printf("Enter " + j1.getName() + "'s health: ");
    j1.setHealth(Integer.parseInt(input.nextLine()));
    System.out.printf("Enter " + j1.getName() + "'s strength: ");
    j1.setStrength(Integer.parseInt(input.nextLine()));
    System.out.printf("Enter " + j1.getName() + "'s accuracy: ");
    j1.setAccuracy(Double.parseDouble(input.nextLine()));

    System.out.printf("\nJavamon #1 Summary: %s [H:%d, S:%d, A:%.2f]\n\n",
        j1.getName(), j1.getHealth(), j1.getStrength(), j1.getAccuracy());

    System.out.printf("Enter Javamon #2's name: ");
    j2.setName(input.nextLine());
    System.out.printf("Enter " + j2.getName() + "'s health: ");
    j2.setHealth(Integer.parseInt(input.nextLine()));
    System.out.printf("Enter " + j2.getName() + "'s strength: ");
    j2.setStrength(Integer.parseInt(input.nextLine()));
    System.out.printf("Enter " + j2.getName() + "'s accuracy: ");
    j2.setAccuracy(Double.parseDouble(input.nextLine()));

    System.out.printf("\nJavamon #2 Summary: %s [H:%d, S:%d, A:%.2f]\n\n",
        j2.getName(), j2.getHealth(), j2.getStrength(), j2.getAccuracy());

  }


}