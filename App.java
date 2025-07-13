import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<Question> questions;
    private int score;

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz! Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        User user = new User(username, password);
        questions = initializeQuestions();

        for (Question question : questions) {
            System.out.println("\n" + question.getQuestion());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your choice (1-4): ");
            int userChoice = scanner.nextInt();

            if (userChoice == question.getCorrectAnswer()) {
                score++;
            }
        }

        System.out.println("\nQuiz ended for user: " + user.getUsername());
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    private List<Question> initializeQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("What is Java?",
                new String[]{"a) A programming language", "b) An operating system", "c) A database system", "d) A browser"}, 1));

        questions.add(new Question("What is the entry point for all Java programs?",
                new String[]{"a) void main()", "b) main()", "c) public static void main(String[] args)", "d) start()"}, 3));

        questions.add(new Question("Which data type is used to store whole numbers?",
                new String[]{"a) int", "b) double", "c) char", "d) boolean"}, 1));

        questions.add(new Question("Syntax for single-line comment in Java?",
                new String[]{"a) # comment", "b) // comment", "c) /* comment */", "d) -- comment"}, 2));

        questions.add(new Question("Keyword to define constant in Java?",
                new String[]{"a) constant", "b) var", "c) final", "d) fixed"}, 3));

        return questions;
    }

    public static void main(String[] args) {
        App quiz = new App();
        quiz.startQuiz();
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
