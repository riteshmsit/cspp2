
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.*;
/**.
 * { class of the program }
 */
final class Solution
{
/*
	Do not modify this main function.
	*/
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
	public static long binaryToDecimal(String s) {
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