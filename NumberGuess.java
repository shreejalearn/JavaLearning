import java.util.Scanner;

public class Day05_GuessMyNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Generate a random number between 0 and 100 [0, 100)
        int num = (int)(Math.random() * 100) + 1;

        System.out.println("Can you guess this random number?");
        System.out.println("What is your guess: ");

        int guess = input.nextInt();
        int guesses = 1;

        while(guess != num){
            if(guess > num) System.out.println("Too high!");
            else System.out.println("Too low!");

            System.out.println("What is your next guess?");
            guess = input.nextInt();
            guesses++; // increment by 1
        }

        System.out.println("Correct! You got it in " + guesses + " guesses.");

    }
}
