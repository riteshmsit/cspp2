import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : ritesh babu veluvolu
 */
final class Solution {
    /**.
     * Constructs the object.
     */
    /**.
     * { global }
     */
    final public static int H = 100;
    // For 100 value
    final public static int F = 50;
    // For 50 value
    final public static int FIVE = 500;
    /**.
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
    static int[][] roundHundred(final int[][] a,
        final int rows, final int columns) {

    // write your code here
        int[][] c = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                for (int k = H; k <= FIVE; k += H) {
                    if (k - a[i][j] > F && k - a[i][j] < H) {
                        c[i][j] = k - H;
                    } else if (k - a[i][j] == 0) {
                        c[i][j] = k;
                    } else if (k - a[i][j] < F && k - a[i][j] < H) {
                        c[i][j] = k;
                      }
                }
                }
        }
        return c;
    }
    /**.
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
