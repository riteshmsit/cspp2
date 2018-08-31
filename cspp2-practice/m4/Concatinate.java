import java.util.*;
class Concatinate {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String sample_string = "hello ";
		String input_string = s.nextLine();
		String concat_string = sample_string.concat(input_string,"!");
		System.out.println(concat_string);
	}
}