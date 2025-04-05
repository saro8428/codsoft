import java.util.Random;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        String playAgain;
        do{
           int guess = 0;
        int attempts = 0;
        int randomNumber;

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        randomNumber = random.nextInt(1, 101);
        System.out.println("Number Guessing Game");
        System.out.println("Number range between 1-100");


        do {
            System.out.println("Enter a Number :");

            guess = scanner.nextInt();
            attempts++;

            if (guess < randomNumber) {
                System.out.println("TO LOW !!!");
            } else if (guess > randomNumber) {
                System.out.println("TO HIGH !!!");
            } else {
                System.out.println("CORRECT !!! The Number was " + randomNumber);
                System.out.println("NO OF ATTEMPTS :" + attempts);
            }


        } while (guess != randomNumber);

        // Ask if user wants to play again
        scanner.nextLine(); // Clear newline
        System.out.print("Do you want to play again? (yes/no): ");
        playAgain = scanner.nextLine();

    } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing! Goodbye!!");

    }

}
