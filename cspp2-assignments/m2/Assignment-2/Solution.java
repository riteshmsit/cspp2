import java.util.Scanner;
import java.lang.Math;
/**
 * { item_description }
 */
public class Solution {
	/*
	Do not modify this main function.
	*/
	/**
	 * { function_description }
	 *
	 * @param      args  String argument
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function and print the output.
	*/
	/**
	 * { function_description }
	 *
	 * @param      a     { first variable }
	 * @param      b     { second variable }
	 * @param      c     { third variable }
	 */
	public static void rootsOfQuadraticEquation(int a, int b, int c) {
		double m1 = (-b + Math.sqrt((b*b) - 4 * a * c))/(2 * a);
		double m2 = (-b - Math.sqrt((b*b) - 4 * a * c))/(2 * a);
		System.out.println(m1 + " " + m2);
	}		
	}

