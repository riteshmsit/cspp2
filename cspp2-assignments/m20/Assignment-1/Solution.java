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
    /**
     * Constructs the object.
     *
     * @param      question1       The question 1
     * @param      choices1        The choices 1
     * @param      correctAnswer1  The correct answer 1
     * @param      maxMarks1       The maximum marks 1
     * @param      penalty1        The penalty 1
     */
    Question(final String question1, final String[] choices1,
        final int correctAnswer1, final int maxMarks1, final int penalty1) {
        this.questiontext = question1;
        this.choices = choices1;
        this.correctAnswer = correctAnswer1;
        this.maxMarks = maxMarks1;
        this.penalty = penalty1;
    }
    /**.
     * Constructs the object.
     *
     * @param      q     The quarter
     */
    Question(final String q) {
        //this.q = response;
    }
    /**
     * { function_description }.
     *
     * @param      choice  The choice
     *
     * @return     { description_of_the_return_value }
     */
    public boolean evaluateResponse(final String choice) {
        if(this.getCorrectAnswer() == choice) {
            return true;



        }
        return false;
    }
    /**
     * Gets the correct answer.
     *
     * @return     The correct answer.
     */
    public String getCorrectAnswer() {
        return this.choices[this.correctAnswer - 1];
    }
    /**
     * Gets the question text.
     *
     * @return     The question text.
     */
    public String getQuestionText() {
        return this.questiontext;
    }
    /**
     * Gets the choice.
     *
     * @return     The choice.
     */
    public String[] getChoice() {
        return this.choices;
    }
    /**
     * Gets the maximum marks.
     *
     * @return     The maximum marks.
     */
    public int getMaxMarks() {
        return this.maxMarks;
    }
    /**
     * Gets the penalty.
     *
     * @return     The penalty.
     */
    public int getPenalty() {
        return this.penalty;
    }
    /**
     * Sets the response.
     *
     * @param      answer  The answer
     */
    public void setResponse(final String answer) {
        // System.out.println(this.getQuestionText(this) + "(" + this.getCorrectAnswer() + ")");
        // int i;
        // for (i = 0; i < choices.length - 1; i++) {
        //     System.out.print(choices[i] + "\t")
        // }
        this.response = answer; 
    }
    /**
     * Gets the response.
     *
     * @return     The response.
     */
    public String getResponse() {
        return this.response;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i;
        s += getQuestionText() + "(" + getMaxMarks() + ")";
        s += "\n";
        for (i = 0; i < this.choices.length - 1; i++) {
            s += this.choices[i] + "\t";
            //System.out.println("intostring");
        }
        s += this.choices[i];
        s += "\n";
        return s;
    }
}
/**
 * Class for quiz.
 */
class Quiz {
    /**
     * { var_description }.
     */
    private int onehundred = 100;
    /**
     * { var_description }.
     */
    private Question[] questions;
    /**
     * { var_description }.
     */
    //private Answers[] answers;
    //private Question[] questioninfo;
    public int size;
    /**
     * Constructs the object.
     */
    Quiz() {
        questions = new Question[onehundred];
        size = 0;
    }
    /**
     * Adds a question.
     *
     * @param      q     The question
     */
    public void addQuestion(final Question q) {
        this.questions[this.size++] = q;
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
    /**
     * Shows the report.
     *
     * @return     { description_of_the_return_value }
     */
    public String showReport() {
        String s = "";
        int total = 0, count = 0;
        for(int i = 0; i < this.size; i++) {
            if (questions[i].evaluateResponse(questions[i].getResponse())) {
                s += questions[i].getQuestionText();
                s += "\n" + "Correct Answer ! - Marks Awarded: " + questions[i].getMaxMarks();
                total += questions[i].getMaxMarks();
                count += 1;
            }  else {
                s += questions[i].getQuestionText();
                s += "\n" + "Wrong Answer! - Penalty: " + questions[i].getPenalty();
                total += questions[i].getPenalty();
                count += 1;
        }
        }
        if(count > 0) {
            return (s + "\n" + "Total Score: " + total);
        }
        return null;
    }
    public int getSize() {
        return size;
    }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    static int a = 1;

     /**
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
                try {
                    System.out.println("|----------------|");
                    System.out.println("| Load Questions |");
                    System.out.println("|----------------|");
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (a == 1) {
                    startQuiz(s, q, Integer.parseInt(tokens[1]));
                }
                //startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (a==1) {
                displayScore(q);
                }
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     */
    public static void loadQuestions(final Scanner scan,
        final Quiz quiz, final int q) throws Exception{
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                String line = scan.nextLine();
                String[] in = line.split(":");
                if (in.length == 5 && in[0].length() > 1) {
                    String[] choic = in[1].split(",");
                    if (choic.length > 1) {
                        if (Integer.parseInt(in[2]) <= choic.length) {
                            if (Integer.parseInt(in[3]) > 0) {
                                if (Integer.parseInt(in[4]) <= 0) {
                                    quiz.addQuestion(new Question(in[0],
                                        choic, Integer.parseInt(in[2]),
                                        Integer.parseInt(in[3]),
                                        Integer.parseInt(in[4])));
                                } else {
                                    a = -1;
                                    throw new Exception("Invalid penalty for "
                                        + in[0]);
                                }
                            } else {
                                a = -1;
                                throw new Exception(
                                    "Invalid max marks for " + in[0]);
                            }
                        } else {
                            a = -1;
                            throw new Exception(
                                "Error! Correct answer choice number"
                                + " is out of range for " + in[0]);
                        }
                    } else {
                        a = -1;
                        throw new Exception(in[0]
                            + " does not have enough answer choices");
                    }
                } else {
                    a = -1;
                    throw new Exception("Error! Malformed question");
                }
            }
            System.out.println(q + " are added to the quiz");
        } else {
            a = -1;
            throw new Exception("Quiz does not have questions");
        }
        
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
            //System.out.println(questions[i].getQuestion() + "(" + questions[i].getcc()+")");
            System.out.println(quiz.getQuestion(i).toString());
            //System.out.println();
            String line = scan.nextLine();
            quiz.getQuestion(i).setResponse(line);
            //answers[answersize++] = new Question(line);
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        //int total = 0, count = 0;
        // int total = 0;
        // for(int i = 0; i < size; i++) {
        //     System.out.println(questions[i].getQuestion(i));
        //     if(questions[i].evaluateResponse(questions[i].getChoice())) {
        //         // System.out.println("Correct Answer! - " + questions[i].getMaxMarks());
        //         // total += questions[i].getMaxMarks();
        //         // count++;
        //         questions[i].showReport();
        //         total += questions[i].getMaxMarks();
        //     } else {
        //         // System.out.println("Wrong answer! - Penalty " + questions[i].getPenalty());
        //         // total += questions[i].getPenalty();
        //         // count++;
        //         questions[i].showReport();
        //         total += questions[i].getPenalty();
        //     }
        // }
        // System.out.println("Total Score: " + total);
        System.out.println(quiz.showReport());
        // if (count > 0) {
        //     System.out.println("Total:" + total);
        // }
    }
}
