
public class RandomPi {

	public static void main(String[] args) {
		int T = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int count = 0;
		for (int i = 0; i < T; i++) {
			int r1 = (int) ( Math.random()*N + 1);
			int r2 = (int) ( Math.random()*N + 1);
			int min = (int) Math.min(r1, r2);
			if (r2 % min == 0 && r1 % min == 0) continue;
			boolean coprime = true;
			boolean[] divisorsTested = new boolean [min/2 + 1];
			for (int j = 2; j < min/2; j++) {
				if (divisorsTested[j]) continue;
				if (r2 % j == 0 && r1 % j == 0) {
					coprime = false;
					break;
				} else {
					divisorsTested[j] = true;
					int k = 2*j;
					while (k < min/2) {
						divisorsTested[k] = true;
						k += j;
					}
				}
			}
			if (coprime) count++;
		}
		System.out.println(count + "  " + T);
		double x = (count * 1.0)/(T * 1.0);
		double pi = Math.sqrt(6.0/x);
		System.out.println(pi);
	}
}
