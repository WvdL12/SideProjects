
public class universeGenerator {

	public static void main(String[] args) {
		int N = (int) (Math.random()*14 + 2);
		double pow = Double.parseDouble(args[0]);
		double rad = 1*Math.pow(10.0, pow);
		double[][] planets = new double [N][5];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				double mult;
				if (j < 2) mult =  Math.random()*(pow-2.0) + 1.0;
				else mult = Math.random();
				double x = Math.random()*Math.pow(10.0, mult);
				if (Math.random() > 0.5) x = x*(-1.0);
				planets[i][j] = x;
			}
			planets[i][4] = (Math.random()*4.0 + 1.0) * Math.pow(10, pow*3);
		}
		StdOut.println(N);
		StdOut.println(rad);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++)
				StdOut.print(planets[i][j] + " ");
			StdOut.println();
		}
		
	}
}
