package UPSCQuizApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    private List<Question> questions;

    public QuizApp() {
        this.questions = loadQuestions();
    }

    private List<Question> loadQuestions() {
        List<Question> loadedQuestions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("questions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String prompt = parts[0];
                String[] options = parts[1].split(",");
                int correctAnswerIndex = Integer.parseInt(parts[2]);
                Question question = new Question(prompt, options, correctAnswerIndex);
                loadedQuestions.add(question);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadedQuestions;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getPrompt());
            String[] options = question.getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((char) ('A' + j) + ") " + options[j]);
            }

            System.out.print("Your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);
            int userAnswerIndex = userAnswer - 'A';

            if (userAnswerIndex == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + (char) ('A' + question.getCorrectAnswerIndex()) + ".\n");
            }
        }

        System.out.println("Quiz completed. Your score: " + score + "/" + questions.size());
        if(score >=20){
            System.out.println("Congretulation You are On Right Path...!");
        } else{
            System.out.println("Time To Improve More...!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello UPSC Aspirant..! Enter Your Name:");
        String name = scanner.nextLine();
        System.out.println(name+ "! Now it's time to start our preparation, Answer the following Questions:");
        System.out.println();
        QuizApp quizApp = new QuizApp();
        quizApp.startQuiz();

    }
}
