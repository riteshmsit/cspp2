
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
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			long res = binaryToDecimal(s);
			System.out.println(res);
		}
				
	}
	public static long binaryToDecimal(String s) {
	    long binary_value = Integer.parseInt(s);
		long last_digit, decimal_value = 0, i = 0;
		while (binary_value != 0) {
			last_digit = binary_value % 10;
			decimal_value += last_digit * Math.pow(2,i);
			i += 1;
			binary_value = binary_value / 10;
		}
		return decimal_value;	
	}
}