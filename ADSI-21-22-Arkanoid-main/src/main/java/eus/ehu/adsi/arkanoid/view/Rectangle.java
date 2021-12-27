package eus.ehu.adsi.arkanoid.view;

public class Rectangle extends GameObject {

	public double x;
	double y;
	double sizeX;
	double sizeY;

	public double left() {
		return x - sizeX / 2.0;
	}

	public double right() {
		return x + sizeX / 2.0;
	}

	public double top() {
		return y - sizeY / 2.0;
	}

	public double bottom() {
		return y + sizeY / 2.0;
	}

}
