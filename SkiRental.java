// Imported in order to get user input
import java.util.Scanner;

// Creating a class
public class SkiRental{

    // Creating a main branch
public static void main(String[] args) {

    // Getting user input on the item name
    Scanner input = new Scanner(System.in);
    System.out.print("What are you buying/renting? "); // Printing a question to ask the user to input an item name
    String item = input.nextLine(); // Saving the input value of the item name in a string variable called "item"

    // Getting user input on the price of buying the item
    System.out.print("How much does it cost to BUY the "+item+"? ");  // Printing a question to ask the user to input the buying price of the item
    double price = input.nextDouble();  // Saving the input value of the price in a double variable called "price"

    input.nextLine(); // For capturing the additional newline character
    
    // Getting user input on the rental time unit
    System.out.print("What is the rental time unit? "); // Printing a question to ask the user to input the time unit for renting
    String time = input.nextLine(); // Saving the input value of the time unit in a string variable called "time"

    // Getting user input on the rental price per time unit
    System.out.print("How much does it cost to RENT the " + item+" per " +time +"? "); // Printing a question to ask the user to input the rental price per time unit
    double rent = input.nextDouble(); // Saving the input value of the rental price in a double variable called "rent"

    // Getting user input on the number of time units the item will be rented for
    System.out.print("How many "+time+"s do you plan to RENT? "); // Printing a question to ask the user to input the number of time units for renting
    int days = input.nextInt(); // Saving the input value of the number of time units in an integer variable called "days"

    // Calculating the total expected rental cost
    double rent_cost = (rent*days);
    System.out.printf("\nTotal expected rental cost: $%.2f\n", (rent_cost)); // Printing the total expected rental cost, rounded to two decimal places

    // Comparing the rental cost to the buying price
    if (rent_cost < price) {
        System.out.printf("It is cheaper to RENT; you'd save $%.2f\n", (price-rent_cost)); // Printing a message to indicate that renting is cheaper and how much the user would save
    }

    else{
        System.out.printf("It is cheaper to BUY\nyou'd save $%.2f\n" , (rent_cost-price)); // Printing a message to indicate that buying is cheaper and how much the user would save
    }

    System.out.println("The break even point would be "+(price/rent)+" "+time+"s");
    
}
}
