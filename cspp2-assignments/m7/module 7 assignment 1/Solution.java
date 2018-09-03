import java.util.Scanner;
/**.
 * Class for input validator.
 */
class InputValidator {
    /*Write the atrributes and methods for InputValidator*/
    /**.
     * { input string for this }
     */
    private String value;
    /**.
     * { FIVE = 5 }
     */
    public static final int FIVE = 5;
    /**.
     * Constructs the object.
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        this.value = input;
    }
    /**.
     * { checks the length of the string }
     *
     * @return     { true or false }
     */
    public boolean validateData() {
        if (value.length() > FIVE) {
            return true;
        }
        return false;
    }
}
/**.
 * { class solution }
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    private Solution() {
    }
    /**.
     * { Main method }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}

