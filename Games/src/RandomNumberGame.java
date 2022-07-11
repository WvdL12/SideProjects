
public class RandomNumberGame {

	public static void main(String[] args) {
		int n = (int) (Math.random()* 100 + 1);
		System.out.println("I'm thinking of a number between 1 and 100...can you guess what it is?");
		for (int i = 1; i <= 10; i = i + 1) {
			if (i == 9) {
				System.out.println("Last try.");
			}
			System.out.print("Make your guess: ");
			int g = Console.readInt();
			if (g == n) {
				System.out.println("Congratulations! You are correct!");
				i = 11;
			} else if (g > n) {
				if (i < 10) {
					System.out.println("Too high, try again...");
				} else {
					System.out.println("Too high. That was your last try.");
					System.out.println("My number was " + n);
				}
			} else if (g < n) {
				if (i < 10) {
					System.out.println("Too low, try again...");
				} else {
					System.out.println("Too low. That was your last try.");
					System.out.println("My number was " + n);
				}
			}
		}
		System.out.println("Thank you for playing");
	}
}
