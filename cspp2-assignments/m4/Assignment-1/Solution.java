import java.util.Scanner;
/**.
 * Class for solution.
 */
final class Solution {
/*
    Fill this main function to print maximum of given array
    */
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { Main function }
     *
     * @param      args  Argument array or command prompt arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]arr = new int[n];
        int maximum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > maximum) {
                maximum = arr[i];
            }
        }
        System.out.println(maximum);
    }
}


