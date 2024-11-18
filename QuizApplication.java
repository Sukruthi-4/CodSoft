import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication 
{
   private static final int TIMER_DURATION = 10; 
   private static boolean answerSubmitted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
            "What is the capital of France?",
            "What is 5 + 7?",
            "Who wrote 'To Kill a Mockingbird'?"
        };
        String[] answers = {
            "Paris",
            "12",
            "Harper Lee"
        };

        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    if (!answerSubmitted) {
                        System.out.println("\nTime's up! Moving to the next question.");
                        answerSubmitted = true;
                    }
                }
            };

            timer.schedule(task, TIMER_DURATION * 1000);

            String userAnswer = scanner.nextLine();
            answerSubmitted = true; // user has submitted the answer

            if (answerSubmitted && !task.cancel()) {
                timer.cancel();
            }

            if (userAnswer.equalsIgnoreCase(answers[i])) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer is: " + answers[i]);
            }

            answerSubmitted = false; // reset for the next question
            System.out.println();
        }

        System.out.println("Quiz over! Your score: " + score + "/" + questions.length);
    }
}


