//Java program to convert binary to decimal
import java.util.*;
/**.
 * { class of the program }
 */
final class Solution
{
/*
    Do not modify this main function.
    */
    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    public static void main(final String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //sc.nextLine();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            long res = binaryToDecimal(s);
            System.out.println(res);
        }         
    }
    /**.
     * { function to convert binary to decimal}
     *
     * @param      s     { String input which contains number }
     *
     * @return     { returns decimal value }
     */
    public static long binaryToDecimal(final String s) {
        //int binary = 1;
        //int decimal = 0;
        //for (int i =s.length()-1;i>=0;i--) {
        //if(s.charAt(i) == '1') {
        //decimal +=binary;
        //}
        //binary = binary *2;
        //}
        //String res = Integer.toString(decimal);
        //return res;
        long binary_value = Long.parseLong(s);
        long last_digit, i = 0;
        long decimal_value = 0;
        while (binary_value != 0) {
            last_digit = binary_value % 10;
            decimal_value += last_digit * Math.pow(2,i);
            i += 1;
            binary_value = binary_value / 10;
        }
        return decimal_value;
    }
}


