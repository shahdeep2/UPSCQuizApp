package UPSCQuizApp;

public class Question {
    private String prompt;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String prompt, String[] options, int correctAnswerIndex) {
        this.prompt = prompt;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getPrompt() {
        return prompt;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}
