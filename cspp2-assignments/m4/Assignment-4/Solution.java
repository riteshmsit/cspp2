
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.*;
public class Solution
{/*
	Do not modify the main function 
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String reverse=reverseString(s);	
		System.out.println(reverse);		
	}
	//Write reverseString function
    public static String reverseString(String s) {
    	String reverse_string = "";
    	for (int i = s.length() - 1 ; i >= 0; i--) {
    		reverse_string += s.charAt(i);
    	}
    	return reverse_string;
    	
    }
}
