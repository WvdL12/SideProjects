import java.awt.Color;

public class Ball {
	private double rx, ry;
	private double vx, vy;
	private double radius;
	private Color col = StdDraw.BLACK;

	public Ball() {
		//rx = Math.random()*0.8 + 0.1; ry = Math.random()*0.8 + 0.1;
		rx = ry = 0.5;
		vx = 0.015 - Math.random() * 0.03;
		vy = 0.015 - Math.random() * 0.03;
		vy = 0.015 - Math.random() * 0.03;
		radius = 0.01 + Math.random() * 0.01;
	}

	public void move() {
		if ((rx + vx > 1.0) || (rx + vx < 0.0))
			vx = -vx;
		if ((ry + vy > 1.0) || (ry + vy < 0.0))
			vy = -vy;
		rx = rx + vx;
		ry = ry + vy;
	}

	public void setColor(Color c1) {
		col = c1;
	}
	
	public Color getColor() {
		return col;
	}
	
	public void draw() {
		StdDraw.setPenColor(col);
		StdDraw.filledCircle(rx, ry, radius);
		StdDraw.filledCircle(rx, ry, radius);
	}
}