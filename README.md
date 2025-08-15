# Online Quiz App

This console-based Quiz App, built with Java 17+, is designed to help you practice collections, control flow, and user-driven design. It showcases Java features like ArrayList, switch expressions, methods, and basic OOP to create a fun and flexible quiz platform—with Admin features to add/delete questions.

---

## Features

- Take a multiple-choice quiz with randomized questions and instant feedback
- Preloaded with 10 questions (add or delete your own as Admin)
- Admin panel: add new questions with options, or remove undesired ones
- Real-time scoring and pass/fail calculation
- Input validation and beginner-friendly feedback
- Uses collections, switch-case menu logic, and object-oriented principles
- Simple menu-driven interface

---

## Getting Started

### Prerequisites

- **Java 17** or later installed (tested with Java 17/21)
- Code editor like **VS Code** or **IntelliJ IDEA**
- Access to **Terminal** or **Command Prompt**

---

### How to Compile & Run

1. **Download** or **clone** the repo.  
2. Save source code as `QuizApp.java`.  
3. Open your terminal in that directory.

**Compile:**  
javac QuizApp.java


**Run:**  
java QuizApp


---

## Usage

- On startup, a menu displays:  
  1. Admin Mode  
  2. Take Quiz  
  3. Exit  
- **Admin Mode:** Add new questions (with options and answers) or delete existing ones (password: `admin123`).  
- **Player Mode:** Attempt the quiz with shuffled questions, answer by typing A/B/C/D, and get your score instantly.  
- Quit anytime by selecting Exit.

---

## Code Structure

**QuizApp**  
- Contains the `main` method, user interface loop, and menu logic.

**Question**  
- Simple class representing a single quiz question (question, options, correct answer), with a method to check correctness.

**Admin Functions**  
- Add/Delete/View questions, all in-memory (no file persistence).

**Player Functions**  
- Attempts quiz using current questions, displays score and feedback.

**Flowchart Overview:**  
![Flowchart](https://raw.githubusercontent.com/Burhan-21/Quiz-App/main/QuizApp/Flow%20chart%20Of%20Quiz%20App.png)



---

## Modern Java Concepts Used

- **ArrayList:** Easy resizing and managing dynamic collections of questions.  
- **Switch-Case & Enhanced Switch:** Clear menu-driven program execution.  
- **For/While loops:** Control program flow for repeated actions (menus, quizzes).  
- **Encapsulation:** Data and related methods grouped in the `Question` class.  
- **Input validation:** Prevents common user-entry errors.

---

## What I Learned

- Using collections (`ArrayList`) for dynamic data management.  
- Writing modular and beginner-friendly console apps with reusable code.  
- Implementing role-based access (Admin/Player).  
- Adding input validation and clear error messages for robust apps.  
- Designing and documenting Java projects for self-learning and teaching.

---

## Example Session

=== ONLINE QUIZ APP ===

1. Admin Mode
2. Take Quiz
3. Exit
4. 
Choose option: 2

Q1: What is the size of int in Java?
A. 2 bytes
B. 4 bytes
C. 8 bytes
D. Depends on OS
Your answer (A/B/C/D): B
✅ Correct!

...

----- RESULT -----
Score: 10/10
Percentage: 100.0%
🎉 You Passed!


**Admin session:**  

=== ADMIN MENU ===

1. Add Question
2. Delete Question
3. View Questions
4. Back to Main Menu
   
Enter choice: 1

Enter question text: What is JVM?
Enter option A: Java Virtual Machine
Enter option B: Java Vendor Machine
Enter option C: Java Visual Model
Enter option D: None of these
Enter correct option (A/B/C/D): A

✅ Question added successfully!


---

## FAQ / Common Issues

- **Wrong input (letters when numbers expected):** The app asks you again—no crash.  
- **Adding duplicate questions:** Allowed, but not recommended (questions are identified by order, not text).  
- **Deleting out-of-range questions:** Tells you if the number is invalid.  
- **Quiz looks the same each time:** Don’t worry, questions are shuffled for fairness!

---

## Interview Cheat Sheet

- **How do you shuffle a list in Java?**  
  `Collections.shuffle(list);`

- **What are Collections in Java?**  
  Frameworks for storing/manipulating groups of objects (like `ArrayList`, `Map`).

- **Difference between switch-case and if-else?**  
  Switch is cleaner for many discrete cases; if-else is for ranges/complex logic.

- **How do you accept/validate console input in Java?**  
  Use `Scanner` to get input; check type with `hasNextInt()` etc.

- **How do you add/remove items from an ArrayList?**  
  `add(element)` to add, `remove(index)` to remove.

---

## License

This is a learning-focused, beginner-friendly project.  
Feel free to adapt, enhance, or repurpose it for your needs, job interviews, or skill-building.
