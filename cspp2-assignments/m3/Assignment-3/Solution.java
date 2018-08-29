
import java.util.Scanner;
/*
    Do not modify this main function.
    */
    /**.
     * Class for solution.
     */
class Solution {
    /**.
     * { function_description }
     *
     * @param      args  Main method or function
     */
    static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(gcd(n1, n2));
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**.
     * { function_description }
     *
     * @param      n1    First number
     * @param      n2    Second number
     *
     * @return     { description_of_the_return_value }
     */
    public static int gcd(final int n1, final int n2) {
        if (n1 > n2) {
            for (int i = n2; i >= 1; i--) {
                if (n1 % i == 0 && n2 % i == 0) {
                    return i;
                }
            }
        }
        if (n1 < n2) {
            for (int i = n1; i >= 1; i--) {
                if (n1 % i == 0 && n2 % i == 0) {
                    return i;
                }
            }
        }
    return 1;
    }
}



