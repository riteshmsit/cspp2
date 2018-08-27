import java.util.Scanner;
class quotient_remainder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number_1 = sc.nextInt();
		int number_2 = sc.nextInt();
		int quotient = number_1 / number_2;
		int remainder = number_1 % number_2;
		System.out.println(quotient);
		System.out.println(remainder);
	}
}