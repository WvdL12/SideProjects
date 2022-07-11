
public class Vector {

	private final double[] coords;
	private final int l;
	
	public Vector(double[] a) {
		l = a.length;
		coords = new double[l];
		for (int i = 0; i < l; i++) {
			coords[i] = a[i];
		}
	}
	
	public Vector plus(Vector that) {
		double[] result = new double[l];
		for (int i = 0; i < l; i++) {
			result[i] = this.coords[i] + that.coords[i];
		}
		return new Vector(result);
	}
	
	public Vector minus(Vector that) {
		double[] result = new double[l];
		for (int i = 0; i < l; i++) {
			result[i] = this.coords[i] - that.coords[i];
		}
		return new Vector(result);
	}
	
	public Vector scale(double alpha) {
		double[] result = new double[l];
		for (int i = 0; i < l; i++)
			result[i] = alpha*coords[i];
		return new Vector(result);
	}
	
	public double dot(Vector that) {
		double result = 0.0;
		for (int i = 0; i < l; i++)
			result += this.coords[i]*that.coords[i];
		return result;
	}
	
	public double magnitude() {
		return Math.sqrt(this.dot(this));
	}
	
	public Vector direction() {
		return this.scale(1/this.magnitude());
	}
	
	public double cartesian(int i) {
		return this.coords[i];
	}
}
