import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    private static int quizsize;
    private static int answersize;
    private static Quiz[] questions = new Quiz[25];
    private static Quiz[] answers = new Quiz[25];
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
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) throws Exception{
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (questionCount > 0) {
            for (int i = 0; i < questionCount; i++) {
            String[] in = s.nextLine().split(":");
            if(in.length == 5) {
                String[] choices = in[1].split(",");
                if(choices.length >= 2) {
                    if(Integer.parseInt(in[2]) > 0) {// && in[2] < choices.length) {
                        if (Integer.parseInt(in[3]) > 0) {
                            if(Integer.parseInt(in[4]) <= 0) {
                                questions[quizsize++] = new Quiz(in[0], choices, Integer.parseInt(in[2]), Integer.parseInt(in[3]), Integer.parseInt(in[4]));
                            } else {
                                throw new Exception("Invalid penalty for " + in[0]);
                            }
                        } else {
                            throw new Exception("Invalid max marks for " + in[0]);
                        }
                    } else {
                        throw new Exception("Correct Answer choice number isout of range for range for" + in[0]);
                    }
                } else {
                    throw new Exception(in[0] + "does not have enough answer choices");
                }
            } else {
                throw new Exception("Error! Malformed question");
            }
            }

        } else {
            throw new Exception("Quiz does not have questions");
        }

    System.out.println(questionCount + " are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 0; i < quizsize; i++) {
            //System.out.println(questions[i].getQuestion() + "(" + questions[i].getcc()+")");
            questions[i].printq();
            System.out.println();
            String line = s.nextLine();
            answers[answersize++] = new Quiz(line);


        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int total = 0, count = 0;
        for(int i = 0; i < answersize; i++) {
            System.out.println(questions[i].getquestion());
            if(questions[i].getcc().equals(answers[i].getanswer())) {
                System.out.println("Correct Answer! - " + questions[i].getscore());
                total += questions[i].getscore();
                count++;
            } else {
                System.out.println("Wrong answer! - Penalty " + questions[i].getpenalty());
                total += questions[i].getpenalty();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Total:" + total);
        }
    }
}
class Quiz {
    String[] choices;
    int maximummarks;
    int penalty;
    int cc;
    String question;
    String line;
    Quiz() {

    }
    Quiz(String line) {
        this.line = line;
    } 
    Quiz(String question, String[] choices, int cc, int maximummarks, int penalty) {
        this.question = question;
        this.choices = choices;
        this.cc = cc;
        this.maximummarks = maximummarks;
        this.penalty = penalty;
    }
    public String getcc() {
        return this.choices[this.cc - 1];
    }
    public int getpenalty() {
        return this.penalty;
    } 
    public String getquestion() {
        return this.question;
    }
    public int getscore() {
        return this.maximummarks;
    }
    public String getanswer() {
        return this.line;
    }
    public void printq() {
        System.out.println(this.question + "(" + this.maximummarks + ")");
        int i;
        for (i = 0; i < this.choices.length - 1;i++) {
            //System.out.print(questions[i].getquestion() + "(" + questions[i].getcc() +")");
            System.out.print(choices[i] + "\t");
        }
        System.out.print(this.choices[i]);
        System.out.println();
    }
}