// Imported in order to get user input
import java.util.Scanner;

// Creating a class
public class nim {
    // Creating a main branch
    public static void main(String[] args) {
        //printing all the piles
        System.out.println("Pile 1: 9\nPile 2: 9\nPile 3: 9");
        //variables storing all these values
        int pileOne = 9;
        int pileTwo = 9;
        int pileThree = 9;
        int stonesTaken = 0;
        int pileChosen = 0;
        //used to determine whether it is player 1 or 2's turn
        int count = 1;
        //user input
        Scanner scan = new Scanner(System.in);

        //Loop that keeps program running till every stone is taken
        while(pileOne!=0 || pileTwo!=0 || pileThree!=0){
            //Determining print statement for player 1 or 2
            if (count%2==0){
                System.out.printf("\nPlayer 2:\n");
            }
            //Determining print statement for player 1 or 2
            else{
                System.out.printf("\nPlayer 1:\n");
            }
            //user pile choice
            System.out.print("From which pile would you like to take? ");
            pileChosen = scan.nextInt();
            //user stone number selection
            System.out.print("How many stones would you like to take? ");
            stonesTaken = scan.nextInt();

            //subtracts the user's stone choice from the number of stones in the pile
            if (pileChosen == 1){
                pileOne-=stonesTaken;
            }
            else if (pileChosen==2){
                pileTwo-=stonesTaken; //subtracts the user's stone choice from the number of stones in the pile
            }
            else{
                pileThree-=stonesTaken; //subtracts the user's stone choice from the number of stones in the pile
            }
            System.out.printf("\nPile 1: %d\nPile 2: %d\nPile 3: %d\n", pileOne, pileTwo, pileThree); //formatted printing
            
            //determines which player took the last stone (through the count variable)
            if(pileOne==0 && pileTwo==0 && pileThree==0 && count%2==0){
                System.out.println("\nYou took the last stone. Player 2 loses.");
            }
            if(pileOne==0 && pileTwo==0 && pileThree==0 && count%2!=0){
                System.out.println("\nYou took the last stone. Player 1 loses.");
            }
            //incrementing the variable
            count++;

        }
    }
}
