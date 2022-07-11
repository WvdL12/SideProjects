
public class universeSim {

	public static void main(String[] args) {
		StdDraw.setCanvasSize(700, 700);
		Universe newton = new Universe();
		double dt = 86400;
		StdDraw.enableDoubleBuffering();
		while (true) {
			StdDraw.clear();
			newton.increaseTime(dt);
			newton.draw();
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
}
