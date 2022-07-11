import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*; 
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class roller {

	static boolean run = true;
	static JFrame display;
	static boolean[] advTracker;
	
	
	private int diceAmount;
	private int diceSize;
	
	public roller(int amount, int size) {
		this.diceAmount = amount;
		this.diceSize = size;
	}
	
	private void newDice(int amount, int size) {
		this.diceAmount = amount;
		this.diceSize = size;
	}
	
	private int[] roll() {
		int[] rolls = new int[this.diceAmount];
		for (int i = 0; i < diceAmount; i++) 
			rolls[i] = (int) (Math.random()*diceSize + 1);
		return rolls;
		
	}
	
	public static void main(String[] args) {
		initialise();
		roller diceRoller = new roller(0, 0);
		while (run) {
			int [] input = diceInput();
			diceRoller.newDice(input[0], input[1]);
			int[] result = diceRoller.roll();
			displayResult(result, input);
		}

	}

	private static void displayResult(int[] result, int[] input) {
		int total = 0;
		for (int i = 0; i < input[0]; i++) {
			total += result[i];
			StdOut.print(result[i] + " ");
			if (i < input[0] - 1)
				StdOut.print("+");
		}
		total += input[2];
		/*
		if (input[2] >= 0)
			StdOut.print("+");
		StdOut.println(input[2] + " =");
		StdOut.println();
		StdOut.println(total);
		StdOut.println();
		*/
		
	}

	private static int[] diceInput() {
		String raw_input = StdIn.readLine();
		int[] input = new int[3];
		
		/*
		int first_seperator_at = raw_input.indexOf("d");
		int second_seperator_at = raw_input.indexOf(" ");
		input[0] = Integer.parseInt(raw_input.substring(0, first_seperator_at));
		if (second_seperator_at != -1) {
			input[1] = Integer.parseInt(raw_input.substring(first_seperator_at + 1, second_seperator_at));
			input[2] = Integer.parseInt(raw_input.substring(second_seperator_at + 1));		
		} else {
			input[1] = Integer.parseInt(raw_input.substring(first_seperator_at + 1));
			input[2] = 0;
		}
			*/
		
		return input;
	}

	private static void initialise() {
		display = new JFrame("Dice Roller v1.0");
		advTracker = new boolean[2];
		display.setBounds(0, 0, 300, 300);
		JPanel input = new JPanel();
		JButton adv = new JButton("Advantage");
		adv.setBackground(Color.lightGray);
//		adv.setBounds(160, 20, 130, 50);
		JButton disadv = new JButton("Disadvantage");
		disadv.setBackground(Color.lightGray);
//		disadv.setBounds(160, 90, 130, 50);
		
		input.add(adv);
		input.add(disadv);
		display.add(input);
		
		display.setVisible(true);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		StdOut.println("Welcome! Please input your required dice roll in the following format:");
		StdOut.println("(number of rolls)d(dice size) +/-(modifier)");
		StdOut.println("Example: 5d8 +4");
		StdOut.println();
		*/
		
	}

}
