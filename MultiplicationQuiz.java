import java.util.Scanner; // alt + shift + o

public class MultiplicationQuiz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int correct = 0;
        int incorrect = 0;
        // Update: Let’s make the program stop if you get 5 right or 3 wrong
        while(correct != 5 && incorrect != 3) {
            // [1, 13)
            int a = (int)(Math.random() * 12) + 1;
            int b = (int)(Math.random() * 12) + 1;

            System.out.println(a + " * " + b + " = ?");
            int ans = in.nextInt();

            if(ans == a * b){
                System.out.println("Correct");
                correct++;
            }
            else {
                System.out.println("Incorrect! The answer is " + a * b);
                incorrect++;
            }

        }
        System.out.println("Congrats -- you answered " + correct + " correctly" + incorrect + " incorrectly.");
    }
}
