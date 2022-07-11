
public class ComputerGuessingGame {

	public static void main(String[] args) {
		System.out.println("Think of an integer between 1 and 100...");
		System.out.println("I will try to guess your number.");
		System.out.println("When you're ready, type in '10'");
		Console.readInt();
		int b = 100;
		int a = 1;
		int i;
		for (i = 1; i <= 7; i = i + 1) {
			int g = (b + a) / 2;
			System.out.println("I think it's " + g + ". Am I correct?");
			System.out.println("(Enter 2 = too high, 0 = too low, 1 = correct.)");
			int user = Console.readInt();
			if (user == 2) {
				b = g - 1;
			} else if (user == 0) {
				a = g + 1;
			} else if (user == 1) {
				System.out.println("I won!");
				i = 99;
			}
			;
		}
		if (i != 100) {
			System.out.println("I lost...");
		}
		System.out.println("Thank you for the game.");
	}
}

/*
	while loop: 
	int answer;
	int lower = 1;
	int higher = 100;
	while (answer != 1) {
		int guess = (higher + lower) / 2;
		sysout "is it " + guess
		answer = Console.readInt()
		if  (answer == 2) {
			higher = guess - 1;
		} else if (answer == 1) {
			lower = guess +1;
		}
	}
*/