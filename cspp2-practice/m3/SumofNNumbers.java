import java.util.*;
class SumofNNumbers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		int n_numbers = s.nextInt();
		int sum_n_numbers = 0;
		for(int i = 1; i<=n_numbers; i++) {
			sum_n_numbers += i;
		}
		System.out.println(sum_n_numbers);
	}
}