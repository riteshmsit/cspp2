import java.util.Scanner;
import java.lang.Math;

public class Solution {
	/*
	Do not modify this main function.
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
	public static void rootsOfQuadraticEquation(int a, int b, int c) {
		double m1 = (-b + Math.sqrt((b*b) - 4 * a * c))/2 * a;
		double m2 = (-b - Math.sqrt((b*b) - 4 * a * c))/2 * a;
		System.out.println(m1 + " " + m2);
	}		
	}
