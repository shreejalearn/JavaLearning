public class AccountTester {
    public static void main(String[] args) {
        Account a1 = new Account("Checking", 1.5, 1000);
        Account a2 = new Account("Savings", 2.3);
        Account a3 = new Account(a1);

        if (a3.getAccountName().equals("Checking") &&
                a3.getInterestRate() == 1.5)
            System.out.println("Passed 1");
        else
            System.out.println("Failed 1");

        a3.setAccountName("Money Market");
        a3.setInterestRate(1.8);

        System.out.println("Quiz Output...");
        System.out.println("1 - " + a1);
        System.out.println("2 - " + a2);
        System.out.println("3 - " + a3);
        System.out.println();

        if ((a2.getBalance()) == 0)
            System.out.println("Passed 2");
        else
            System.out.println("Failed 2");

        if ((a2.getInterestRate()) == 2.3)
            System.out.println("Passed 3");
        else
            System.out.println("Failed 3");

        if (a2.withdraw(500) == false)
            System.out.println("Passed 4");
        else
            System.out.println("Failed 4");

        if (a1.withdraw(1001) == false)
            System.out.println("Passed 5");
        else
            System.out.println("Failed 5");

        if (a1.withdraw(900) == true)
            System.out.println("Passed 6");
        else
            System.out.println("Failed 6");

        a2.deposit(500);

        if ((a2.getBalance()) == 500)
            System.out.println("Passed 7");
        else
            System.out.println("Failed 7");

        a2.deposit(200);

        if ((a2.getBalance()) == 700)
            System.out.println("Passed 8");
        else
            System.out.println("Failed 8");

        a3.deposit(500);

        a1.applyAnnualInterest();
        a2.applyAnnualInterest();
        a3.applyAnnualInterest();

        if (((int)a2.getBalance()) == 716)
            System.out.println("Passed 9");
        else
            System.out.println("Failed 9");

        System.out.println(a2.getAccountName() + ": " + a2);
        System.out.println(a3.getAccountName() + ": " + a3);
        System.out.println("Transfering $50 from " + a3.getAccountName() + " to " + a2.getAccountName());

        if (a3.transfer(a2, 500000) == false) 
            System.out.println("Passed 10a");
        else
            System.out.println("Failed 10a");
      

        if (a3.transfer(a2, 50)) 
            System.out.println("Passed 10b");
        else
            System.out.println("Failed 10b");
        

        if (((int)a2.getBalance()) == 766 && ((int)a3.getBalance()) == 1477)
            System.out.println("Passed 11");
        else
            System.out.println("Failed 11");

        System.out.println("\nEnding status...");
        System.out.println("1 - " + a1);
        System.out.println("2 - " + a2);
        System.out.println("3 - " + a3);
    }
}
