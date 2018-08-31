//Program to reverse a string
import java.util.Scanner;
/**.
 * { class of the program }
 */
final class Solution {
/*
    Do not modify the main function
    */
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { Main function }
     *
     * @param      args  Command Line Arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**.
     * { To reverse a string }
     *
     * @param      s     { Input sting }
     *
     * @return     { Reverse string }
     */
    public static String reverseString(final String s) {
        String reversestring = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversestring += s.charAt(i);
        }
        return reversestring;
    }
}
