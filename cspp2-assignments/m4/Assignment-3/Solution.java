//Java program to convert binary to decimal
import java.util.Scanner;
/**.
 * { class of the program }
 */
final class Solution {
/*
    Do not modify this main function.
    */
    /**.
     * Initializing repeated value to variable.
     */
    public static final int D = 10;
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    public static void main(final String[] args) {
    //Scanner maethod of reading input    
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
        long binaryvalue = Long.parseLong(s);
        long lastdigit, i = 0;
        long decimalvalue = 0;
        while (binaryvalue != 0) {
            lastdigit = binaryvalue % D;
            decimalvalue += lastdigit * Math.pow(2, i);
            i += 1;
            binaryvalue = binaryvalue / D;
        }
        return decimalvalue;
    }
}


