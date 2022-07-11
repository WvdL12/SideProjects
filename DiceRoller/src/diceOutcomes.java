
public class diceOutcomes {
	
	public static void main(String[] args) {
		// NdD where N is number of dice, D is dice size
		int N = 3;
		int D = 10;
		
		int possible_outcomes = (int) Math.pow(D, N);
		int[] outcomes = new int[possible_outcomes];
		
		int array_itir = 0;
		
		for (int i=1; i<= D; i++) {
			for (int j=1; j<=D; j++) {
				for (int k=1; k<=D; k++) {
					//for (int l=1; l<=D; l++) {
						//for (int m=1; m<=D; m++) {
							//for (int n=1; n<=D; n++) {
								outcomes[array_itir] = i+j+k;
								array_itir++;
							//}
						//}
					//}
				}
			}
		}
		
		int max_roll = N*D;
		int[] outcome_distr = new int[max_roll];
		
		for (int i=0; i<max_roll; i++) {
			for (int j=0; j<possible_outcomes; j++) {
				if (outcomes[j] == i+1) 
					outcome_distr[i]++;
			}
			StdOut.println("Roll " + (i+1) + ": " + outcome_distr[i]);
		}
		
		StdOut.println();
		StdOut.println("Total: " + possible_outcomes);
		
	}
}
