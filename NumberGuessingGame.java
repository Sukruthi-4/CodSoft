
    import java.util.Random;
    import java.util.Scanner;
    
    public class NumberGuessingGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            
            int minNumber = 1;
            int maxNumber = 100;
            int secretNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            int guess = 0;
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess the number between " + minNumber + " and " + maxNumber);
            
            while (guess != secretNumber) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;
                
                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                }
            }
            
            scanner.close();
        }
    }
    

