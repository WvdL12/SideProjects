
public class Yahtzee {

	public static void main(String[] args) {
		int[] P1Score = new int[14];
		int[] P2Score = new int[14];
		for (int i = 0; i < 14; i++) {
			P1Score[i] = -1;
			P2Score[i] = -1;
		}
		System.out.println("----------WELCOME TO YAHTZEE!----------");
		System.out.println("      (press any key to continue)");
		System.out.println();
		Console.readLine();
		GamePlay(P1Score, P2Score);
		System.out.println();
		int FinalScore1 = FinalScore(P1Score);
		int FinalScore2 = FinalScore(P2Score);
		System.out.print("That was the last round. Your final scores are:	Player 1 - " + FinalScore1
				+ ",		Player 2 - " + FinalScore2);
		System.out.println();
		if (FinalScore1 > FinalScore2) {
			System.out.println("---PLAYER 1 WINS!!!---");
		} else if (FinalScore1 < FinalScore2) {
			System.out.println("---PLAYER 2 WINS!!!---");
		} else {
			System.out.println("---IT'S A DRAW!!!---");
		}
	}

	public static int FinalScore(int[] Score) {
		int s = 0;
		for (int i = 0; i < 13; i++) {
			s += Score[i];
		}
		int bonus = 0;
		for (int i = 0; i < 6; i++) {
			bonus += Score[i];
		}
		if (bonus >= 63) {
			s += 35;
		}
		return s;
	}

	public static void GamePlay(int[] P1Score, int[] P2Score) {
		boolean Player1Turn = true;
		for (int i = 0; i < 26; i++) {
			if (Player1Turn) {
				System.out.println("------PLAYER 1------");
			} else {
				System.out.println("------PLAYER 2------");
			}
			int[] Roll = new int[0];
			int[] Hand = new int[5];
			int nrkept = 0;
			for (int r = 0; r < 3; r++) {
				Roll = new int[5 - nrkept];
				int keep = 0;
				System.out.println("You roll:");
				for (int dice = 0; dice < 5 - nrkept; dice++) {
					Roll[dice] = (int) (Math.random() * 6 + 1);
					System.out.print("  " + Roll[dice]);
				}
				System.out.println();
				if (r != 2) {
					System.out.println("How many dice would you like to take?");
					keep = Console.readInt();
					if (keep == 5) {
						for (int dice = 0; dice < 5; dice++) {
							Hand[dice] = Roll[dice];
						}
					} else if (keep != 0) {
						System.out.println("Which one(s)? (1, 2, 3, 4 or 5)");
						for (int dice = nrkept; dice < nrkept + keep; dice++) {
							int whichDice = Console.readInt();
							Hand[dice] = Roll[whichDice - 1];
						}
					}
				} else {
					keep = 5 - nrkept;
					int whichDice = 0;
					for (int dice = nrkept; dice < nrkept + keep; dice++) {
						Hand[dice] = Roll[whichDice];
						whichDice++;
					}
				}
				nrkept += keep;
				System.out.println("Your hand is:");
				for (int p = 0; p < nrkept; p++) {
					System.out.print("  " + Hand[p]);
				}
				System.out.println();
				if (nrkept == 5) {
					r = 3;
				}
			}
			ChooseScore(Hand, Player1Turn, P1Score, P2Score);
			Player1Turn = !Player1Turn;
			System.out.println();
			// next player's turn

		}
	}

	public static void ChooseScore(int[] Hand, boolean Player1Turn, int[] P1Score, int[] P2Score) {
		System.out.println("Indicate where you want to put your score.");
		System.out.println("--GROUP 1--          --GROUP 2--");
		System.out.println("  (1)  Ones		  (7)  Three-of-a-kind");
		System.out.println("  (2)  Twos		  (8)  Four-of-a-kind");
		System.out.println("  (3)  Threes		  (9)  Full - House");
		System.out.println("  (4)  Fours		  (10) Small Straight");
		System.out.println("  (5)  Fives		  (11) Big Straight");
		System.out.println("  (6)  Sixes		  (12) Yahtzee!");
		System.out.println("		(13) Chance");
		System.out.println(" 		(14) Scrap score");
		int ScoreChoice = Console.readInt();
		while (Player1Turn && P1Score[ScoreChoice - 1] != -1) {
			System.out.println("You've already scored there, choose again.");
			ScoreChoice = Console.readInt();
		}
		while (!Player1Turn && P2Score[ScoreChoice - 1] != -1) {
			System.out.println("You've already scored there, choose again.");
			ScoreChoice = Console.readInt();
		}
		if (ScoreChoice >= 1 && ScoreChoice <= 6) {
			int d = 0;
			for (int j = 0; j < Hand.length; j++) {
				if (Hand[j] == ScoreChoice) {
					d++;
				}
			}
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = d * ScoreChoice;
			} else {
				P2Score[ScoreChoice - 1] = d * ScoreChoice;
			}
		} else if (ScoreChoice == 7 || ScoreChoice == 8 || ScoreChoice == 13) {
			int c = 0;
			for (int k = 0; k < 5; k++) {
				c += Hand[k];
			}
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = c;
			} else {
				P2Score[ScoreChoice - 1] = c;
			}
		} else if (ScoreChoice == 9) {
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = 25;
			} else {
				P2Score[ScoreChoice - 1] = 25;
			}
		} else if (ScoreChoice == 10) {
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = 30;
			} else {
				P2Score[ScoreChoice - 1] = 30;
			}
		} else if (ScoreChoice == 11) {
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = 40;
			} else {
				P2Score[ScoreChoice - 1] = 40;
			}
		} else if (ScoreChoice == 12) {
			if (Player1Turn) {
				P1Score[ScoreChoice - 1] = 50;
			} else {
				P2Score[ScoreChoice - 1] = 50;
			}
		} else if (ScoreChoice == 14) {
			System.out.println("Which score do you want to scrap?");
			System.out.println("(use above-listed input values, 7 - 12)");
			int scrap = Console.readInt();
			if (Player1Turn) {
				P1Score[scrap - 1] = 0;
			} else {
				P2Score[scrap - 1] = 0;
			}
		}
		if (Player1Turn) {
			System.out.println("--PLAYER 1 SCORE--");
			PrintScore(P1Score);
		} else {
			System.out.println("--PLAYER 2 SCORE--");
			PrintScore(P2Score);
		}

	}

	public static void PrintScore(int[] Score) {
		System.out.println("--GROUP 1--		--GROUP 2--");
		System.out.println("  Ones - " + Score[0] + "		  Three-of-a-kind - " + Score[6]);
		System.out.println("  Twos - " + Score[1] + "		  Four-of-a-kind - " + Score[7]);
		System.out.println("  Threes - " + Score[2] + "		  Full - House - " + Score[8]);
		System.out.println("  Fours - " + Score[3] + "		  Small Straight - " + Score[9]);
		System.out.println("  Fives - " + Score[4] + "		  Big Straight - " + Score[10]);
		System.out.println("  Sixes - " + Score[5] + "		  Yahtzee! - " + Score[11]);
		System.out.println(" 			  Chance - " + Score[12]);
		System.out.println("**NOTE: (-1) indicates an unplayed category.");
	}
}
