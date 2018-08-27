import java.util.Scanner;
class Swap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number_1 = sc.nextInt();
		int number_2 = sc.nextInt();
		number_1 = number_1 * number_2;
		number_2 = number_1 / number_2;
		number_1 = number_1 / number_2;
		System.out.println(number_1);
		System.out.println(number_2);
		
	}
}