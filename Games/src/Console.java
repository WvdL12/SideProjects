import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Console {

	private static Scanner scanner = new Scanner(
	  new BufferedReader(new InputStreamReader(System.in)));

	public static String readLine() {
		return scanner.nextLine();
	}

	public static int readInt() {
		return scanner.nextInt();
	}
	
}
