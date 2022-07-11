
public class Pig {

	public static void main(String[] args) {
		int player = 0;
		int cpu = 0;
		int roll = -1;
		int choice = -1;
		int Roundscore = 0;
		int turn = 0; // 0 == human, 1 == cpu
		int game = 0;
		System.out.println("Welcome to the game!");
		System.out.println("");
		System.out.println("The player goes first.");
		
		while (player < 100 && cpu < 100) {
			if (turn == 0) {
				if (game == 1) {
					System.out.println("");
					System.out.println("---------- PLAYER'S TURN ----------");
				}
				while (roll != 1 && choice != 0) {
					roll = (int) (Math.random() * 6 + 1);
					System.out.println("Your roll is " + roll);
					if (roll == 1) {
						System.out.println("You lose your turn. You gained no points.");
						System.out.println("The scores are: Player - " + player + ", Computer - " + cpu);
						Roundscore = 0;
					} else {
						Roundscore = Roundscore + roll;
						System.out.println("Your Round score is " + Roundscore + ". Do you wish to roll again?");
						System.out.println("(Enter 0 for no, and 1 for yes.)");
						choice = Console.readInt();
						if (choice == 0) {
							player = player + Roundscore;
							System.out.println("You chose not to roll again. You gained " + Roundscore + " points.");
							System.out.println("The scores are: Player - " + player + ", Computer - " + cpu);
						} else if (choice == 1) {
							System.out.println("You roll again...");
						}
					}
				}
			}
			if (player < 100) {
				turn = 1;
			} else {
				turn = 2;
			}
			roll = 0;
			choice = -1;
			Roundscore = 0;
			game = 1;
			if (turn == 1) {
				System.out.println("");
				System.out.println("---------- COMPUTER'S TURN ----------");
				while (roll != 1 && choice != 0) {
					roll = (int) (Math.random() * 6 + 1);
					System.out.println("The computer's roll is " + roll);
					if (roll == 1) {
						System.out.println("The computer loses its turn. They gained no points.");
						System.out.println("The scores are: Player - " + player + ", Computer - " + cpu);
					} else {
						Roundscore = Roundscore + roll;
						choice = (int) (Math.random() * 2);
						if (cpu + Roundscore >= 100) {
							choice = 0;
						} else if (Roundscore < 6) {
							choice = 1;
						} else if (Roundscore >= 20) {
							choice = 0;
						}
						if (choice == 0) {
							cpu = cpu + Roundscore;
							System.out.println("The computer chose not to roll again. They gained " + Roundscore + " points.");
							System.out.println("The scores are: Player - " + player + ", Computer - " + cpu);
						} else if (choice == 1) {
							System.out.println("The computer rolls again...");
						}
					}
				}
			}
			if (cpu < 100) {
				turn = 0;
			} else {
				turn = 3;
			}
			roll = 0;
			choice = -1;
			Roundscore = 0;
		}
		System.out.println("");
		if (turn == 2) {
			System.out.println("The player has won the game! Congratulations! The final scores are: Player - " + player + ", Computer - " + cpu);
		} else if (turn == 3) {
			System.out.println("The computer has won the game! The final scores are: Player - " + player + ", Computer - " + cpu);
		}
		System.out.println("Thank you for playing the game.");
	}
}
