import java.util.Scanner;

public class QuizApplication {
SSS
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;  // Variable to keep track of the score
        int totalQuestions = 3;  // Total number of questions

        System.out.println("Welcome to the Simple Quiz Application!");
        System.out.println("Answer the following questions by typing the correct option number.\n");

        // Question 1
        System.out.println("1. What is the capital of France?");
        System.out.println("1) Berlin");
        System.out.println("2) Madrid");
        System.out.println("3) Paris");
        System.out.println("4) Rome");
        System.out.print("Your answer: ");
        int answer1 = scanner.nextInt();
        if (answer1 == 3) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer is 3) Paris.");
        }

        // Question 2
        System.out.println("\n2. Which planet is known as the Red Planet?");
        System.out.println("1) Earth");
        System.out.println("2) Mars");
        System.out.println("3) Jupiter");
        System.out.println("4) Venus");
        System.out.print("Your answer: ");
        int answer2 = scanner.nextInt();
        if (answer2 == 2) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer is 2) Mars.");
        }

        // Question 3
        System.out.println("\n3. Who wrote 'Hamlet'?");
        System.out.println("1) Charles Dickens");
        System.out.println("2) J.K. Rowling");
        System.out.println("3) Mark Twain");
        System.out.println("4) William Shakespeare");
        System.out.print("Your answer: ");
        int answer3 = scanner.nextInt();
        if (answer3 == 4) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Wrong! The correct answer is 4) William Shakespeare.");
        }

        // Display final score
        System.out.println("\nQuiz Completed!");
        System.out.println("Your final score is " + score + " out of " + totalQuestions);

        // Display message based on score
        if (score == totalQuestions) {
            System.out.println("Excellent! You got all the questions right.");
        } else if (score > 0) {
            System.out.println("Good job! You got " + score + " correct answers.");
        } else {
            System.out.println("Better luck next time!");
        }

        scanner.close();
    }
}
