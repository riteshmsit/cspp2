import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : 
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int [][] a, final int rows, final int columns) {

	// write ypur code here
        int b[][] = new int[rows][columns];
        int k = 100;
        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < columns; j += 1) {
                if (k - a[i][j] > 50 && k - a[i][j] < 100) {
                    b[i][j] = k - 100;
                } else if (k - a[i][j] == 0) {
                    b[i][j] = 0;
                } else if (k - a[i][j] < 50 && k - a[i][j] < 100) {
                    b[i][j] = k;
                } else {
                    b[i][j] = 0;
                }
                k += 100;
                /*for (int k = 100; k >= 400; k += 100) {
                    int diff = k - a[i][j];
                    if (diff)*/
                   /* if (k - a[i][j] > 50 && k - a[i][j] < 100) {
                        c[i][j] = k;
                    } else if (k - a[i][j] == 0) {
                        c[i][j] = k;
                    } else {
                        c[i][j] = k;
                    }
                }*/
            }
        }
        return b;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
