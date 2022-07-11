
public class Body {

	private Vector r;
	private Vector v;
	private final double mass;
	
	public Body(Vector r0, Vector v0, double m0) {
		r = r0;
		v = v0;
		mass = m0;
	}
	
	public void move(Vector force, double dt) {
		Vector a = force.scale(1/mass);
		v = v.plus(a.scale(dt));
		r = r.plus(v.scale(dt));
	}
	
	public Vector forceFrom(Body that) {
		double G = 6.67e-11;
		Vector delta = that.r.minus(this.r);
		double dist = delta.magnitude();
		double magnitude = (G*this.mass*that.mass) / (dist*dist*dist);
		Vector force = delta.scale(magnitude);
		return force;
	}
	
	public void draw() {
		StdDraw.setPenRadius(0.009);
		StdDraw.point(r.cartesian(0), r.cartesian(1));
			
		
	}
}
