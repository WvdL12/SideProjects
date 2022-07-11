import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*; 
//import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GameOfLife {

	static boolean[][] curGen;
	static boolean[][] nextGen;
	static int tick;
	static JFrame display = new JFrame("Welcome to the Game Of Life!");
	static GridBagConstraints cells = new GridBagConstraints();
	static 	GridBagConstraints button = new GridBagConstraints();
	static int speed = 200;
	static boolean loop = true;
	static boolean restart = false;
	static boolean pause = false;
	
	public static void main(String[] args) {
		display.setSize(730, 730);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cells.fill = GridBagConstraints.BOTH;
		cells.weightx = 0.5;
		cells.weighty = 0.5;
		int size = start();
		boolean[][] init = readArray(size);
		curGen = new boolean[size][size];
		nextGen = new boolean[size][size];
		copy(init, curGen);
		copy(curGen, nextGen);
		tick = 0;
		run();
	}

	private static int start() {
		JFrame input = new JFrame("Welcome to the Game Of Life!");
		input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String size;
		int s = 0;
		boolean validIn = false;
		do {
			size = JOptionPane.showInputDialog(input,"Please input a grid size:", "Welcome to the Game Of Life!", JOptionPane.QUESTION_MESSAGE);
			try {
				s = Integer.parseInt(size);
				if (s>0) validIn = true;
			} catch (Exception e) {
				
			}
		} while (!validIn);
		return s;
	}
	
	private static void run() {
		int s = curGen.length;
		JPanel pane = new JPanel();
		pane.setBackground(Color.gray);
		pane.setLayout(new GridBagLayout());
		GridBagConstraints label = new GridBagConstraints();
		label.gridy = 0;
		label.weightx = 0.5;
		label.fill = GridBagConstraints.NONE;
		label.gridwidth = s/2;
		JLabel generation = new JLabel("Generation:    ");
		JLabel genPerSec = new JLabel("Generations per second:   ");
		pane.add(generation, label);
		pane.add(genPerSec, label);
		JButton[][] gridDisplay = new JButton[s][s];
		for(int i=0; i<s; i++) {
			for (int j=0; j<s; j++) {
				gridDisplay[i][j] = new JButton();
				gridDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
				cells.gridx = j;
				cells.gridy = i + 1;
				pane.add(gridDisplay[i][j], cells);
			}
		}
		JButton[] interact = new JButton[5];
		interact[0] = new JButton("   <<  ");
		interact[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				speed = 2*speed;
				speed = Math.min(speed, 1600);
			}
		});
		interact[1] = new JButton(" Pause ");
		interact[1].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (pause) {
					interact[1].setText(" Pause ");
					pause = false;
				}
				else {
					interact[1].setText("  Play  ");
					pause = true;
				}
			}
		});
		interact[2] = new JButton("   >>  ");
		interact[2].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				speed = speed/2;
				speed = Math.max(speed, 25);
			}
		});
		interact[3] = new JButton("Restart");
		interact[3].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				loop = false;
				restart = true;
			}
		});
		interact[4] = new JButton("  Exit ");
		interact[4].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				loop = false;
				restart = false;
			}
		});
		int buttonWidth = s/5;
		button.gridy = s+1;
		button.gridwidth = buttonWidth;
		button.fill = GridBagConstraints.BOTH;
		for (int i=0; i<5; i++) {
			button.gridx = i*buttonWidth;
			if (i==4) button.gridwidth = GridBagConstraints.REMAINDER;
			pane.add(interact[i], button);
		}
		display.add(pane);
		display.setVisible(true);
		while(loop) {
			tick++;
			generation.setText("Generation: " + tick);
			genPerSec.setText("Generations per second: " + 1000.0/speed);
			for (int r=0; r < s; r++) 
				for (int c=0; c < s; c++) {
					int count = 0;
					//finite Life checks
					
					/*
					if ( r>0 && c>0 && curGen[r-1][c-1]) count++;
					if ( r>0 && curGen[r-1][c]) count++;
					if (r>0 && c+1<s && curGen[r-1][c+1]) count++;
					if (c>0 && curGen[r][c-1]) count++;
					if (c+1<s && curGen[r][c+1]) count++;
					if (r+1<s && c>0 && curGen[r+1][c-1]) count++;
					if (r+1<s && curGen[r+1][c]) count++;
					if (r+1<s && c+1<s && curGen[r+1][c+1]) count++;
					*/
					
					//looped Life checks
					if (r == 0) {
						if (curGen[s-1][c]) count++;
						if (curGen[r+1][c]) count++;
						if (c == 0) {
							if (curGen[s-1][s-1]) count++;
							if (curGen[s-1][c+1]) count++;
							if (curGen[r][s-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[r+1][s-1]) count++;
							if (curGen[r+1][c+1]) count++;
						} else if (c == s-1) {
							if (curGen[s-1][c-1]) count++;
							if (curGen[s-1][0]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][0]) count++;
							if (curGen[r+1][c-1]) count++;
							if (curGen[r+1][0]) count++;
						} else {
							if (curGen[s-1][c-1]) count++;
							if (curGen[s-1][c+1]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[r+1][c-1]) count++;
							if (curGen[r+1][c+1]) count++;
						}
					} else if (r == s-1) {
						if (curGen[0][c]) count++;
						if (curGen[r-1][c]) count++;
						if (c == 0) {
							if (curGen[r-1][s-1]) count++;
							if (curGen[r-1][c+1]) count++;
							if (curGen[r][s-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[0][s-1]) count++;
							if (curGen[0][c+1]) count++;
						} else if (c == s-1) {
							if (curGen[r-1][c-1]) count++;
							if (curGen[r-1][0]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][0]) count++;
							if (curGen[0][c-1]) count++;
							if (curGen[0][0]) count++;
						} else {
							if (curGen[r-1][c-1]) count++;
							if (curGen[r-1][c+1]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[0][c-1]) count++;
							if (curGen[0][c+1]) count++;
						}
					} else {
						if (curGen[r-1][c]) count++;
						if (curGen[r+1][c]) count++;
						if (c == 0) {
							if (curGen[r-1][s-1]) count++;
							if (curGen[r-1][c+1]) count++;
							if (curGen[r][s-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[r+1][s-1]) count++;
							if (curGen[r+1][c+1]) count++;
						} else if (c == s-1) {
							if (curGen[r-1][c-1]) count++;
							if (curGen[r-1][0]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][0]) count++;
							if (curGen[r+1][c-1]) count++;
							if (curGen[r+1][0]) count++;
						} else {
							if (curGen[r-1][c-1]) count++;
							if (curGen[r-1][c+1]) count++;
							if (curGen[r][c-1]) count++;
							if (curGen[r][c+1]) count++;
							if (curGen[r+1][c-1]) count++;
							if (curGen[r+1][c+1]) count++;
						}
					}			
			
					if (count == 3) nextGen[r][c] = true;
					else if(count != 2) nextGen[r][c] = false;
				}
			copy(nextGen, curGen);
//			if (tick == 1) {
//				try {
//					Thread.sleep(speed);
//				} catch (Exception e) {}
//			}
			for (int i=0; i<s; i++) {
				for (int j=0; j<s; j++) {
					if (curGen[i][j]) gridDisplay[i][j].setBackground(Color.black);
					else gridDisplay[i][j].setBackground(Color.white);
				}
			}
			display.setVisible(true);
			try {
				Thread.sleep(speed);
			} catch (Exception e) {}
			while (pause && loop) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {}
			}
		}
		if (restart) {
			loop = true;
			restart = false;
			speed = 500;
			display.remove(pane);
			display.setVisible(false);
			int size = start();
			boolean[][] init = readArray(size);
			curGen = new boolean[size][size];
			nextGen = new boolean[size][size];
			copy(init, curGen);
			copy(curGen, nextGen);
			tick = 0;
			run();
		}
		display.dispose();
		System.exit(0);
		
	}

	{ //terminal display
//	private static void display(boolean[][] grid) {
//		int s = grid.length;
//		int buttonSize = 600/s;
//		JButton[][] gridDisplay = new JButton[s][s];
//		for(int i=0; i<s; i++) {
//			for (int j=0; j<s; j++) {
//				gridDisplay[i][j] = new JButton();
//				gridDisplay[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
//				gridDisplay[i][j].setBounds(50 + j*buttonSize, 50 + i*buttonSize, buttonSize, buttonSize);
//				if (grid[i][j]) gridDisplay[i][j].setBackground(Color.black);
//				else gridDisplay[i][j].setBackground(Color.white);
//				display.add(gridDisplay[i][j]);
//			}
//		}
//		display.setVisible(true);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {}
//		display.setVisible(false);
//	}
	}
	
	private static void copy(boolean[][] a, boolean[][] b) {
		int n = a.length;
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < n; j++) 
				b[i][j] = a[i][j];
	}

	private static boolean[][] readArray(int size) {
		boolean[][] temp = new boolean[size][size];
		JButton[][] grid = new JButton[size][size];
//		JFrame inputCond = new JFrame("Welcome to the Game Of Life!");
//		inputCond.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		inputCond.setSize(730, 730);
		JPanel pane = new JPanel(new GridBagLayout());
		pane.setBounds(0, 0, 730, 730);
		pane.setBackground(Color.gray);
		//int buttonSize = 600/size;
		boolean[] condSet = new boolean[1];
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				grid[i][j] = new JButton();
				//grid[i][j].setBounds(50 + j*buttonSize, 50 + i*buttonSize, buttonSize, buttonSize);
				grid[i][j].setBackground(Color.white);
				grid[i][j].setBorder(BorderFactory.createLineBorder(Color.darkGray));
				grid[i][j].addActionListener(new ActionListener () {
					public void actionPerformed(ActionEvent e) {
						int r=0, c=0;
						outer: for(r=0; r<size; r++) {
							for(c=0; c<size; c++) {
								if(e.getSource() == grid[r][c]) break outer;
							}
						}
						if (temp[r][c]) {
							temp[r][c] = false;
							grid[r][c].setBackground(Color.white);
						} else {
							temp[r][c] = true;
							grid[r][c].setBackground(Color.black);
						}
					}
				});
				cells.gridx = j;
				cells.gridy = i;
				pane.add(grid[i][j], cells);
			}
		}
		JButton done = new JButton("Start.");
		//done.setBounds(300, 655, 100, 30);
		done.setBackground(Color.lightGray);
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				condSet[0] = true;
			}
		});
		JButton random = new JButton("Randomise");
		random.setBackground(Color.lightGray);
		random.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				double prob = 0.3;
				for (int i = 0; i < size; i++) {
					for (int j = 0; j < size; j++) {
						if (Math.random() < prob) {
							grid[i][j].setBackground(Color.black);
							temp[i][j] = true;
						}
						else {
							grid[i][j].setBackground(Color.white);
							temp[i][j] = false;
						}
					}
				}
			}
		});
		
		button.gridx = 0;
		button.gridwidth = size/2;
		button.gridy = size;
		button.fill = GridBagConstraints.BOTH;
		pane.add(done, button);
		button.gridx = size/2;
		button.gridwidth = GridBagConstraints.REMAINDER;
		pane.add(random, button);
		display.add(pane);
		display.setVisible(true);
		while(true) {
			try {
				Thread.sleep(10);
			} catch (Exception e) {};
			if (condSet[0]) {
				display.remove(pane);
				return temp;
			}
		}
	}
}
