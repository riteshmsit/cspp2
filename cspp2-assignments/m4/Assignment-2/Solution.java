import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int r1 = s.nextInt();
		int c1 = s.nextInt();
		int a[][] = new int[r1][c1];
		for (int i = 0; i<r1;i++) {
			for (int j = 0; j<c1;j++) {
				a[i][j] = s.nextInt();
			}
		}
		int r2 = s.nextInt();
		int c2 = s.nextInt();
		int b[][] = new int [r2][c2];
		for (int i =0; i<r2; i++) {
			for(int j =0;j<c2;j++) {
				b[i][j] = s.nextInt();
			}
		}
		int c[][] = new int[r2][c2];
		for (int i =0; i<r2; i++) {
			for(int j =0;j<c2;j++) {
				c[i][j] = a[i][j] + b[i][j];
			}
		}
		if (r1!=r2 || c1!=c2) {
			System.out.println("not possible");
		}	else {
			for (int i =0; i<r2; i++) {
				for(int j =0;j<c2;j++) {
					c[i][j] = a[i][j] + b[i][j];
					System.out.print(c[i][j] + " ");					
			}
				System.out.println();
		}
		}	
	}
}