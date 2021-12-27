package eus.ehu.adsi.arkanoid.view;

import java.awt.Graphics;

public class Brick extends Rectangle {

	public boolean destroyed = false;
	public boolean suerte = false;

	public Brick(double x, double y) {
		this.x = x;
		this.y = y;
		this.sizeX = Config.BLOCK_WIDTH;
		this.sizeY = Config.BLOCK_HEIGHT;
	}

	public void draw(Graphics g) {
		if(suerte){
			g.setColor(Config.BRICK_ESP_COLOR);
		}else {
			g.setColor(Config.BRICK_COLOR);
		}
		g.fillRect((int) left(), (int) top(), (int) sizeX, (int) sizeY);
	}

	public void setSuerte(){
		suerte = true;
	}

	public boolean esSuerte(){return suerte;}

	public double getPosicionX(){
		return x;
	}

	public double getPosicionY(){
		return y;
	}
}