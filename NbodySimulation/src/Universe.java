public class Universe {
	
	private final int N;
	private final Body[] bodies;
	
	public Universe () {
		N = StdIn.readInt();
		double radius = StdIn.readDouble();
		StdDraw.setXscale(-radius, +radius);
		StdDraw.setYscale(-radius, +radius);
		
		bodies = new Body[N];
		for (int i = 0; i < N; i++) {
			double rx = StdIn.readDouble();
			double ry = StdIn.readDouble();
			double vx = StdIn.readDouble();
			double vy = StdIn.readDouble();
			double mass = StdIn.readDouble();
			double[] position = { rx, ry };
			double[] velocity = { vx, vy };
			Vector r = new Vector(position);
			Vector v = new Vector(velocity);
			bodies[i] = new Body(r, v, mass);
		}
	}
	
	public void increaseTime(double dt) {
		Vector[] f = new Vector[N];
		for (int i = 0; i < N; i++) {
			f[i] = new Vector(new double[2]);
			for (int j = 0; j < N; j++) 
				if (i != j) 
					f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
		}
		for (int i = 0; i < N; i++) 
			bodies[i].move(f[i], dt);
	}
	
	public void draw() {
		for (int i = 0; i < N; i++) 
			bodies[i].draw();
	}
	
}
