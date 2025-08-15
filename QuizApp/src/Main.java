import java.util.*;

class Question {
    String questionText;
    List<String> options;
    char correctOption;

    public Question(String questionText, List<String> options, char correctOption) {
        this.questionText = questionText;
        this.options = new ArrayList<>(options);
        this.correctOption = Character.toUpperCase(correctOption);
    }

    public boolean isCorrect(char userAnswer) {
        return Character.toUpperCase(userAnswer) == correctOption;
    }
}

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Question> questions = new ArrayList<>();

    public static void main(String[] args) {
        preloadQuestions();

        boolean running = true;
        while (running) {
            System.out.println("\n=== ONLINE QUIZ APP ===");
            System.out.println("1. Admin Mode");
            System.out.println("2. Take Quiz");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1 -> adminMenu();
                case 2 -> takeQuiz();
                case 3 -> { running = false; System.out.println("Exiting Quiz App. Goodbye!"); }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // -------- ADMIN MENU --------
    private static void adminMenu() {
        System.out.print("Enter Admin Password: ");
        String pass = sc.next();
        if (!pass.equals("admin123")) {
            System.out.println("❌ Wrong password!");
            return;
        }

        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("\n=== ADMIN MENU ===");
            System.out.println("1. Add Question");
            System.out.println("2. Delete Question");
            System.out.println("3. View Questions");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");
            int adminChoice = getIntInput();

            switch (adminChoice) {
                case 1 -> addQuestion();
                case 2 -> deleteQuestion();
                case 3 -> viewQuestions();
                case 4 -> adminRunning = false;
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Add a new question
    private static void addQuestion() {
        sc.nextLine(); // consume newline
        System.out.print("Enter question text: ");
        String text = sc.nextLine();

        List<String> opts = new ArrayList<>();
        for (char opt = 'A'; opt <= 'D'; opt++) {
            System.out.print("Enter option " + opt + ": ");
            opts.add(opt + ". " + sc.nextLine());
        }

        System.out.print("Enter correct option (A/B/C/D): ");
        char correct = sc.next().charAt(0);

        questions.add(new Question(text, opts, correct));
        System.out.println("✅ Question added successfully!");
    }

    // Delete question by number
    private static void deleteQuestion() {
        viewQuestions();
        System.out.print("Enter question number to delete: ");
        int index = getIntInput() - 1;

        if (index >= 0 && index < questions.size()) {
            questions.remove(index);
            System.out.println("✅ Question deleted successfully!");
        } else {
            System.out.println("❌ Invalid question number!");
        }
    }

    // View all questions (Admin mode)
    private static void viewQuestions() {
        if (questions.isEmpty()) {
            System.out.println("No questions available.");
            return;
        }
        for (int i = 0; i < questions.size(); i++) {
            System.out.println((i + 1) + ". " + questions.get(i).questionText);
        }
    }

    // -------- PLAYER MODE --------
    private static void takeQuiz() {
        if (questions.isEmpty()) {
            System.out.println("No questions available. Ask Admin to add.");
            return;
        }

        int score = 0;
        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);

        for (int i = 0; i < shuffled.size(); i++) {
            Question q = shuffled.get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Your answer (A/B/C/D): ");
            char ans = sc.next().charAt(0);

            if (q.isCorrect(ans)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: " + q.correctOption);
            }
        }

        System.out.println("\n----- RESULT -----");
        System.out.println("Score: " + score + "/" + shuffled.size());
        double percent = (score * 100.0) / shuffled.size();
        System.out.println("Percentage: " + percent + "%");
        System.out.println(percent >= 70 ? "🎉 You Passed!" : "📚 You Failed.");
    }

    // -------- HELPERS --------
    private static void preloadQuestions() {
        questions.add(new Question("What is the size of int in Java?",
                Arrays.asList("A. 2 bytes", "B. 4 bytes", "C. 8 bytes", "D. Depends on OS"), 'B'));
        questions.add(new Question("Which keyword is used to inherit a class?",
                Arrays.asList("A. implements", "B. inheriting", "C. extends", "D. super"), 'C'));
        questions.add(new Question("Which collection allows key-value pairs?",
                Arrays.asList("A. List", "B. Set", "C. Map", "D. Queue"), 'C'));
        questions.add(new Question("Which loop is also called 'for-each' loop?",
                Arrays.asList("A. while", "B. enhanced for-loop", "C. for loop", "D. infinite loop"), 'B'));
        questions.add(new Question("Which is not a Java keyword?",
                Arrays.asList("A. static", "B. Boolean", "C. void", "D. try"), 'B'));
        questions.add(new Question("What is the default value of boolean?",
                Arrays.asList("A. true", "B. false", "C. null", "D. 0"), 'B'));
        questions.add(new Question("Which method is used to start a thread?",
                Arrays.asList("A. init()", "B. run()", "C. start()", "D. execute()"), 'C'));
        questions.add(new Question("Which access modifier makes a variable visible to all?",
                Arrays.asList("A. private", "B. public", "C. protected", "D. default"), 'B'));
        questions.add(new Question("Which interface does java.util.List extend?",
                Arrays.asList("A. Collection", "B. Iterable", "C. Map", "D. Array"), 'A'));
        questions.add(new Question("Which method sorts a list in Java?",
                Arrays.asList("A. Collections.sort()", "B. sort()", "C. Arrays.order()", "D. list.sort()"), 'A'));
    }

    private static int getIntInput() {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
