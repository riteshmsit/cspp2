import java.util.Scanner;
class degrees_to_fahrenheit {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	double celcius_degree = sc.nextDouble();
	double fahrenheit = celcius_degree *(9/5.0) + 32;
    System.out.println(fahrenheit);	
	}	
}