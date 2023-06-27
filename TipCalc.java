import java.util.Scanner;

public class Day02_TipCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter your bill amount: "); 
        double bill = in.nextDouble();

        // Calculate common tip amounts
        System.out.println("15% = " + bill * 0.15);
        System.out.println("17.5% = " + bill * 0.175);
        System.out.println("20% = " + bill * 0.2);

        // Get the users custom tip %
        System.out.print("Enter a custom tip amount %:");
        double tipPercent = in.nextDouble();
        double tipDecimal = tipPercent / 100;
        double tipAmount = bill * tipDecimal;
        System.out.println(tipPercent + "% = $" + tipAmount);
        System.out.printf("Total Bill: $%.2f \n" , (bill + tipAmount));
    }
}
