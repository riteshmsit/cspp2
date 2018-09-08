import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 * @author : Ritesh Babu Veluvolu
 */
class Set {
    //your code goes here...
    //Good luck :-)
    private int size;
    private int[] arr;

    public Set() {
        size = 0;
        arr = new int[200];

    }
    public int size() {
        return size;
    }
    public void add(int arrayelement) {
        int flag = 0;
        if (size == arr.length) {
            arr = resize();
            arr[size++] = arrayelement;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arrayelement == arr[i]) {
                    flag = 1;
                }
            if (flag == 0) {
                arr[size++] = arrayelement;
            }
            }
            
        }
    }
    public int[] resize() {
        arr = Arrays.copyOf(arr, 2 * arr.length);
        return arr;
    }
    public void add(int[] arrayelements) {
        for (int i = 0; i < arrayelements.length; i++) {
            if (size == arr.length) {
            arr = resize();
            add(arrayelements[i]);
        } else {
            add(arrayelements[i]);
        }
        }       
    }
    public String toString() {
        if (size == 0) {
            return "{}";
        } else {
        String s1 = "{";
        for (int i = 0; i < size - 1; i++) {
            s1 += arr[i] + ",";
        }
        return s1 + arr[size - 1] + "}";
        }
    }

    public boolean contains(int arrayelement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arrayelement) {
                return true;
            }
        }
        return false;
    }
    /*public Set intersection(Set array2) {
        Set intersection = new Set();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (arr[i] == array2[j]) {
                    intersection.add(arr[i]);
                    break;
                }
            }
        }
        return intersection;
    }
    public Set retainAll(int[] array2) {
        Set retained = new Set();
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (arr[i] == array2[j]) {
                    retained.add(arr[i]);
                    break;
                }
            }
        }
        return retained;
    }
    public int[][] cartesianProduct(Set array2) {
        int[][] cartesian = new int[arr.length][array2.length];
        if (arr.length == 0 || array2.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                int[][] cartesian = add(arr[i]);
                cartesian = add(array2[j]);
            }
        }
        return cartesian;
    }*/ 
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "size":
                System.out.println(s.size());
                break;
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                /*case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;*/
                default:
                break;
            }
        }
    }
}




















