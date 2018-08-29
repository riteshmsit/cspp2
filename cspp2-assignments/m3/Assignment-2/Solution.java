
import java.util.Scanner;
/*
    Do not modify this main function.
    */
/**.
 * { Class of the program }
 */
final class Solution {
    /**.
     * { To divide by 10 to get digits }
     */
    public static final int I = 10;
    /**.
     * { To count number of 7's }
     */
    public static final int D = 7;

/* Fill the main function to print the number of 7's between 1 to n*/
/**.
 * { main method or function }
 *
 * @param      args  The arguments
 */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int a = i, b = a;
            while (b != 0) {
                a = b % I;
                if (a == D) {
                    count += 1;
                }
                b = b / I;
            }
        }
        System.out.println(count);
    }
}



