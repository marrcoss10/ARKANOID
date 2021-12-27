package eus.ehu.adsi.arkanoid.view;

import java.awt.Color;
import java.awt.Graphics;


public class Paddle extends Rectangle {

	double velocity = 0.0;

	public Paddle(double x, double y) {
		this.x = x;
		this.y = y;
		this.sizeX = Config.PADDLE_WIDTH;
		this.sizeY = Config.PADDLE_HEIGHT;
	}

	public void update() {
		x += velocity * Config.FT_STEP;
	}

	public void stopMove() {
		velocity = 0.0;
	}

	public void moveLeft() {
		if (left() > 0.0) {
			velocity = -Config.PADDLE_VELOCITY;
		} else {
			velocity = 0.0;
		}
	}

	public void moveRight() {
		if (right() < Config.SCREEN_WIDTH) {
			velocity = Config.PADDLE_VELOCITY;
		} else {
			velocity = 0.0;
		}
	}

	public void draw(Graphics g) {
		g.setColor(Config.PADDLE_COLOR);
		g.fillRect((int) (left()), (int) (top()), (int) sizeX, (int) sizeY);
	}

	public void hacerMasGrande(){
		this.sizeX = sizeX + 30;
	}

	public void restablecerTamano(){
		this.sizeX = Config.PADDLE_WIDTH;
	}

}
