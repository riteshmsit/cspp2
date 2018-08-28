import java.util.Scanner;
/**.
 * { item_description }
 */
public class Solution {
    /**.
     * { function_description }
     *
     * @param      args  String argument
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        equation(a, b, c);
    }
    /**.
     * { function_description }
     *
     * @param      a     { first variable }
     * @param      b     { second variable }
     * @param      c     { third variable }
     */
    public static void equation(final int a, final int b, final int c) {
        double m1 = (-b + Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
        double m2 = (-b - Math.sqrt((b * b) - 4 * a * c)) / (2 * a);
        System.out.println(m1 + " " + m2);
    }       
    }

