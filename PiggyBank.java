//importing the module for taking in a user's input
import java.util.Scanner;

public class PiggyBank {
  public static void main(String[] args) {
    //printing welcome statement
    System.out.println("Welcome to the Electronic Piggy Bank!");

    //taking in user's current balance
    Scanner input = new Scanner(System.in);
    System.out.println("How much money is currently in the bank?"); //printing the question
    double money = (double) input.nextDouble(); // saving it in a double variable

    //printing out the menu
    System.out.println("MENU:\n(p) - Deposit a penny.\n(n) - Deposit a nickel.\n(d) - Deposit a dime.\n(q) - Deposit a quarter.\n(e) - Exit program.");

    input.nextLine(); //throwaway nextline input to prevent errors

    System.out.println("Please press a letter to select an option:"); //printing the question
    String option = (String) input.nextLine(); // saving it in a variable

    //while loop to continue giving the user choices until they press 'e'
    while(!option.equals("e")){    

        //adding a penny to the user's balance
        if (option.equals("p")){
            money+=0.01;
        }
        //adding a nickel to the user's balance
        else if (option.equals("n")){
            money+=0.05;
        }
        //adding a dime to the user's balance
        else if (option.equals("d")){
            money+=0.10;
        }
        //adding a quarter to the user's balance
        else if(option.equals("q")){
            money+=0.25;
        }
        //If the user enters a wrong input
        else{
            System.out.println("Invalid Option.");
        }
        //prints new balance after each operation
        System.out.printf("New balance: %.2f\n", (money));

        System.out.println("Please press a letter to select an option:"); //printing the question (loops)
        option = (String) input.nextLine(); // saving it in a variable (loops)

    }

    //prints the final balance and a goodbye statement
    System.out.printf("Final balance: %.2f", (money));
    System.out.println("\n\tGoodbye.");
}  
}
