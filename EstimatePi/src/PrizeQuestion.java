
public class PrizeQuestion {

	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();

		double subdivisions = Double.parseDouble(args[0]);
		double counterS = 0;
		double counterC = 0;
		double sub2 = subdivisions / 2;
		double TOTAL = (subdivisions * subdivisions);
		System.out.println("Number of points: " + TOTAL);
		for (int i = 0; i <= subdivisions; i++) {
			for (int j = 0; j <=subdivisions; j++) {
				double x = i - sub2;
				double y = j - sub2;
				counterS++;
				if (x*x + y*y <= sub2*sub2) {
					//equation for the function of the circle is (i - sub2)^2 + (j - sub2)^2 = sub2^2
					counterC++;
				}
				if (counterS % (100000*100000) == 0) {
					System.out.println("Progress: " + counterS + "/" + TOTAL + "; Estimate: " + (counterC / counterS) * 4);
				}
			}
		}
		double Pi = (counterC / counterS) * 4;
		System.out.println(Pi);
		
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) / 1000.0 + "s.");
	}
}
