
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
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
		int n = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String s) {
	    int d = Integer.parseInt(s);
		int last_digit, decimal_value = 0, i = 0;
		while (d != 0) {
			last_digit = d % 10;
			decimal_value += last_digit * (2^i);
			i += 1;
			d = d / 10;
		}
		String result = "" + decimal_value;
		return result;		
	}
}