package eus.ehu.adsi.arkanoid.view;

import java.awt.Graphics;

public class Ball extends GameObject {

	public double x;
	public double y;
	double radius = Config.BALL_RADIUS;
	public double velocityX = Config.BALL_VELOCITY;
	public double velocityY = Config.BALL_VELOCITY;

	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(Config.BALL_COLOR);
		g.fillOval((int) left(), (int) top(), (int) radius * 2,
				(int) radius * 2);
	}

	public void update(ScoreBoard scoreBoard, Paddle paddle) {
		x += velocityX * Config.FT_STEP;
		y += velocityY * Config.FT_STEP;

		if (left() < 0)
			velocityX = Config.BALL_VELOCITY;
		else if (right() > Config.SCREEN_WIDTH)
			velocityX = -Config.BALL_VELOCITY;
		if (top() < 0) {
			velocityY = Config.BALL_VELOCITY;
		} else if (bottom() > Config.SCREEN_HEIGHT) {
			velocityY = -Config.BALL_VELOCITY;
			x = paddle.x;
			y = paddle.y - 50;
			scoreBoard.die();
		}

	}

	public void hacerMasGrande(){
		radius = radius +5;
	}

	public void restablecerTamano(){
		radius = Config.BALL_RADIUS;
	}

	public void setVelocidad(){
		velocityY = Config.BALL_VELOCITY;
		velocityX = Config.BALL_VELOCITY;
	}

	public double left() {
		return x - radius;
	}

	public double right() {
		return x + radius;
	}

	public double top() {
		return y - radius;
	}

	public double bottom() {
		return y + radius;
	}

}