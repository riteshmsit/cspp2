import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
    /**
     * { var_description }.
     */
    private String questiontext;
    /**
     * { var_description }.
     */
    private String[] choices;
    /**
     * { var_description }.
     */
    private int correctAnswer;
    /**
     * { var_description }.
     */
    private int maxMarks;
    /**
     * { var_description }.
     */
    private int penalty;
    /**
     * { var_description }.
     */
    private String response;
    /**
     * Constructs the object.
     */
    Question() {

    }
    /**.
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     * @param      response1       The response 1
     */
    Question(final String question1, final String[] choices1, final
        int correctAnswer1, final int maxMarks1, final int penalty1,
        final String response1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
        this.response = null;

    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse() {
        if (response.equals(choices[correctAnswer - 1])) {
            return true;
        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return choices;
    }
    /**.
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        this.response = answer;

    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String printChoices() {
        String[] str = this.getChoice();
        String str1 = "";
        int i = 0;
        for (i = 0; i < str.length - 1; i++) {
            str1 += str[i] + "\t";
            //System.out.println("in printChoices" + i);
        }
        str1 += str[i];
        return str1;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private final int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    private int size, size1;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
        size1 = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        questions[size++] = q;
        //System.out.println(questions[size - 1].getQuestionText());

    }
    /**
     * Gets the question.
     *
     * @param      index  The index
     *
     * @return     The question.
     */
    public Question getQuestion(final int index) {
        return questions[index];
    }
    /**.
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        questions[size1].setResponse(answer);
        size1++;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return size;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**.
     * { var_description }
     */
    private static int v = 1;
    /**.
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                try {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (v == 1) {
                   startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (v == 1) {
                    displayScore(q);
                }
                break;
                default:
                break;
            }
        }
    }
    /**.
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The quarter
     *
     * @throws     Exception  { exception_description }
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        final int five = 5, four = 4, three = 3, two = 2, one = 1;
        if (q <= 0) {
            v = -1;
            throw new Exception("Quiz does not have questions");
        }
        for (int i = 0; i < q; i++) {
            String[] parts = scan.nextLine().split(":");
            if (parts.length < five || parts[0].length() <= 0) {
                v = -1;
                throw new Exception("Error! Malformed question");
            }
            if (parts[1].split(",").length < two) {
                v = -1;
                throw new Exception(parts[0]
                    + " does not have enough answer choices");
            }
            if (Integer.parseInt(parts[two]) > parts[1].split(",").length) {
                v = -1;
                System.out.print("Error! Correct answer choice number ");
                throw new Exception("is out of range for "
                    + parts[0]);
            }
            if (Integer.parseInt(parts[three]) <= 0) {
                v = -1;
                throw new Exception("Invalid max marks for " + parts[0]);
            }
            if (Integer.parseInt(parts[four]) > 0) {
                v = -1;
                throw new Exception("Invalid penalty for " + parts[0]);
            }
            quiz.addQuestion(new Question(parts[0],
                parts[one].split(","), Integer.parseInt(parts[two]),
                Integer.parseInt(parts[three]),
                Integer.parseInt(parts[four]), null));
        }
        System.out.println(q + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
        final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (int i = 0; i < q; i++) {
            quiz.setResponse(scan.nextLine());
            Question questions = quiz.getQuestion(i);
            System.out.println(questions.getQuestionText()
                + "(" + questions.getMaxMarks() + ")");
            System.out.println(questions.printChoices() + "\n");
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        int ts = 0;
        for (int i = 0; i < quiz.getsize(); i++) {
            Question questions = quiz.getQuestion(i);
            System.out.println(questions.getQuestionText());
            if (questions.evaluateResponse()) {
                System.out.println(" Correct Answer! - Marks Awarded: "
                    + questions.getMaxMarks());
                ts += questions.getMaxMarks();
            } else {
                System.out.println(" Wrong Answer! - Penalty: "
                    + questions.getPenalty());
                ts += questions.getPenalty();
            }
        }
        System.out.println("Total Score: " + ts);
    }
}








