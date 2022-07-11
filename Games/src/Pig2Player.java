
public class Pig2Player {

	public static void main(String[] args) {
		int p1 = 0;
		int p2 = 0;
		int roll = -1;
		int choice = -1;
		int Roundscore = 0;
		int turn = 1;
		int game = 0;
		System.out.println("Welcome to the game!");
		System.out.println("");
		System.out.println("Player 1 goes first.");
		while (p1 < 100 && p2 < 100) {
			if (turn == 1) {
				if (game == 1) {
					System.out.println("");
					System.out.println("---------- PLAYER 1'S TURN ----------");
				}
				while (roll != 1 && choice != 0) {
					roll = (int) (Math.random() * 6 + 1);
					System.out.println("Your roll is " + roll);
					if (roll == 1) {
						System.out.println("Player 1 loses their turn. They gained no points.");
						System.out.println("The scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
						Roundscore = 0;
					} else {
						Roundscore = Roundscore + roll;
						System.out.println("Your Round score is " + Roundscore + ". Do you wish to roll again?");
						System.out.println("(Enter 0 for no, and 1 for yes.)");
						choice = Console.readInt();
						if (choice == 0) {
							p1 = p1 + Roundscore;
							System.out.println("Player 1 chose not to roll again. They gained " + Roundscore + " points.");
							System.out.println("The scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
						} else if (choice == 1) {
							System.out.println("You rolls again...");
						}
					}
				}
				if (p1 < 100) {
					turn = 2;
				} else {
					turn = 11;
				}
			}
			roll = -1;
			choice = -1;
			Roundscore = 0;
			game = 1;
			if (turn == 2) {
				System.out.println("");
				System.out.println("---------- PLAYER 2'S TURN ----------");
				while (roll != 1 && choice != 0) {
					roll = (int) (Math.random() * 6 + 1);
					System.out.println("Your roll is " + roll);
					if (roll == 1) {
						System.out.println("Player 2 loses their turn. They gained no points.");
						System.out.println("The scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
						Roundscore = 0;
					} else {
						Roundscore = Roundscore + roll;
						System.out.println("Your Round score is " + Roundscore + ". Do you wish to roll again?");
						System.out.println("(Enter 0 for no, and 1 for yes.)");
						choice = Console.readInt();
						if (choice == 0) {
							p2 = p2 + Roundscore;
							System.out.println("Player 2 chose not to roll again. They gained " + Roundscore + " points.");
							System.out.println("The scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
						} else if (choice == 1) {
							System.out.println("You roll again...");
						}
					}
				}
				if (p2 < 100) {
					turn = 1;
				} else {
					turn = 22;
				}
			}
			roll = -1;
			choice = -1;
			Roundscore = 0;
		}
		System.out.println("");
		if (turn == 11) {
			System.out.println("Player 1 has won the game! Congratulations! The final scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
		} else if (turn == 22) {
			System.out.println("Player 2 has won the game! Congratulations! The final scores are: Player 1 - " + p1 + ", Player 2 - " + p2);
		}
		System.out.println("Thank you for playing the game.");
	}
}
