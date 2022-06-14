import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
// import java.util.*;

/** A number guessing game. */
public class Game {
  public static void main(String[] args) {
    // Generating random number
    Random rand = new Random();
    int number = rand.nextInt(101);

    System.out.println("Welcome to the Guessing Game!");

    Scanner input = new Scanner(System.in);

    System.out.println("Enter your name: ");
    String name = input.nextLine(); // nextLine() - calling method from Scanner class on the object created

    int count = 0;

    int user_guess;

    Boolean guessIsCorrect = false;

    System.out.println("I'm thinking of a number between 0 and 100.");
    System.out.println("Try to guess the number.\n");

    // Guessing the valid number
    while (!guessIsCorrect) {
      System.out.println("Enter your guess: ");

      try {
        user_guess = input.nextInt();
      } catch (InputMismatchException e) {
        String badInput = input.next();
        System.out.println(badInput + " is not a valid number, try again.\n");
        continue;
      }

      if (user_guess < 0 || user_guess > 100) {
        System.out.println("The number should be between 0 and 100. Try again.");
        continue;
      }

      // User entered the number between 0 and 100 as was specifyed
      count++;

      if (user_guess > number) {
        System.out.println("Your guess is too high, try again.\n");
      } else if (user_guess < number) {
        System.out.println("Your guess is too low, try again.\n");
      } else {
        guessIsCorrect = true;
        System.out.println("Well done, " + name + "! You found my number in " + count
            + " tries!");
      }
    }
  }
}