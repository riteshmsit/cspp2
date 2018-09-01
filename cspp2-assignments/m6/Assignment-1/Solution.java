import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static int oddComposites(final int n) {
	// write your code here
    	for (int i = 3; i <= n; i += 2) {
    		int flag = 0;
    		for (int j = 2; j <= i; j += 1) {
    			if (i % j == 0) {
    				flag = 1;
    			}
    		}
    		if (flag == 0) {
    			return i;
    		}
    	}
    return 1;
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(oddComposites(n));
        
    }
}

