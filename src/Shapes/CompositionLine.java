package Shapes;

import java.awt.Graphics;

public class CompositionLine extends Line {

	public CompositionLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g) {
		int width = 10, height = 10;
		int dx = x2 - x1, dy = y2 - y1;
		double D = Math.sqrt(dx * dx + dy * dy);
		double xm = D - width, xn = xm, ym = height, yn = -height, x;
		double sin = dy / D, cos = dx / D;

		x = xm * cos - ym * sin + x1;
		ym = xm * sin + ym * cos + y1;
		xm = x;

		x = xn * cos - yn * sin + x1;
		yn = xn * sin + yn * cos + y1;
		xn = x;

		double xk = (height * 2 / D) * x1 + ((D - height * 2) / D) * x2;
		double yk = (height * 2 / D) * y1 + ((D - height * 2) / D) * y2;

		int[] xpoints = { x2, (int) xm, (int) xk, (int) xn };
		int[] ypoints = { y2, (int) ym, (int) yk, (int) yn };

		g.drawLine(x1, y1, x2, y2);
		g.fillPolygon(xpoints, ypoints, 4);
	}
}
