
public class test {
	public static void main(String[] args) {
		double subdivisions = Double.parseDouble(args[0]);
		double [][] Square = new double [(int) (subdivisions + 1)][(int) (subdivisions + 1)];
		double [][] Circle = new double [(int) (subdivisions + 1)][(int) (subdivisions + 1)];
		double counterS = 0;
		double counterC = 0;
		double sub2 = subdivisions / 2;
		for (int i = 0; i <= subdivisions; i++) {
			for (int j = 0; j <=subdivisions; j++) {
				double x = i - sub2;
				double y = j - sub2;
				Square [i][j] = 1;
				counterS++;
				if (x*x + y*y <= sub2*sub2) {
					//equation for the function of the circle is (i - sub2)^2 + (j - sub2)^2 = sub2^2
					Circle [i][j] = 1;
					counterC++;
				}
			}
		}
		double Pi = (counterC / counterS) * 4;
		System.out.println(Pi);
	}
}
