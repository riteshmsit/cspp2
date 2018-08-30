import java.util.*;
class Average {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for (int i = 0; i<n; i++) {
			arr[i] = s.nextInt();
		}
        int sum = 0;
        for (int i = 0; i<n; i++) {
        	sum = sum + arr[i];
        }
        double average = sum / n; //arr.length can be placed instead of n
        System.out.println(average);
	}
}