import java.awt.Color;

public class ballAnimator {

	public static void main(String[] args) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setCanvasSize(720, 720);
		int N = Integer.parseInt(args[0]);
		Ball[] balls = new Ball[N];
		for (int i = 0; i < N; i++) {
			int r = (int) (Math.random()*255);
			int b = (int) (Math.random()*255);
			int g = (int) (Math.random()*255);
			Color x = new Color(r, g, b);
			balls[i] = new Ball();
			balls[i].setColor(x);
		}
		while (true) {
			for (int i = 0; i < N; i++) {
				balls[i].move();
				balls[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			StdDraw.clear();
		}
	}
}
