import java.util.Scanner; //for taking in user input

public class RetirementCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Setting up a Scanner

        System.out.println("How much do you plan to save per year?");
        double savingsPerYear = input.nextDouble(); //savings per year (input from user and storing in a variable)

        System.out.println("How many years do you have until retirement?");
        int yearsLeft = input.nextInt(); //number of years left till retirement (input from user and storing in a variable)

        System.out.println("How much do you expect to earn per year?\n\t(Enter as percentage: 7.5% should be entered as 7.5)");
        double percent = input.nextDouble(); //earnings per year (input from user and storing in a variable)

        System.out.printf("%9s %18s %18s %15s %16s\n", "Year", "Starting", "Earnings", "Ending", "Deposited"); //formatted print

        //defining different variables for the loop
        double inc = savingsPerYear;
        double starting= savingsPerYear;
        double ending= (starting+(percent/100)*starting);
        double earning = ((percent/100)*starting);    

        
        //for loop
        for(int year=1; yearsLeft >= year; year+=1) {
            System.out.printf("%9d %,18.2f %,18.2f %,15.2f %,16.2f\n", year,starting, earning,ending, savingsPerYear); //formatted printing a table
            
            savingsPerYear+=inc; //adding to the yearly savings
            starting=ending+inc; // incrementing the starting value
            ending= (starting+(percent/100)*starting); //updating the ending value
            earning = ((percent/100)*starting); //updating the earning value
        }
    }
}
