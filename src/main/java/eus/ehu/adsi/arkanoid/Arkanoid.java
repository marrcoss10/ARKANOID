package eus.ehu.adsi.arkanoid;

// Adapted from https://gist.github.com/Miretz/f10b18df01f9f9ebfad5

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import eus.ehu.adsi.arkanoid.view.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import eus.ehu.adsi.arkanoid.core.Game;

public class Arkanoid extends JFrame implements KeyListener {

	// Housekeeping
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(Arkanoid.class);

	// Game variables

	private Game game;
	private Paddle paddle = new Paddle(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT - 50);
	private Ball ball = new Ball(Config.SCREEN_WIDTH / 2, Config.SCREEN_HEIGHT / 2);
	private List<Brick> bricks = new ArrayList<Brick>();
	private ScoreBoard scoreboard = new ScoreBoard();

	private double lastFt;
	private double currentSlice;
	private static boolean continuar = false;
	
	public Arkanoid() {
		
		game = new Game ();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(false);
		this.setResizable(false);
		this.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		this.setTitle("Arkanoid");
		this.setVisible(true);
		this.addKeyListener(this);
		this.setLocationRelativeTo(null);
		this.createBufferStrategy(2);

		bricks = Game.initializeBricks(bricks);

	}

	public static void recibirPersonalizacion(String fondo, String bola, String ladrillo, String paddle, String sonido){
		Config.recibirColores(fondo, bola, ladrillo, paddle, sonido);
		continuar = true;
	}
	
	public void run() {
		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = bf.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		//Llamamos a la ventana de personalizacion
		Personalizacion p = new Personalizacion();
		p.setVisible(true);
		this.setVisible(false);
		while(!continuar){System.out.println("");}
		//Cerramos la ventana de personalizacion y abrimos la del juego
		p.setVisible(false);
		this.setVisible(true);
		game.setRunning(true);
		while (game.isRunning()) {

			long time1 = System.currentTimeMillis();

			if (!scoreboard.gameOver && !scoreboard.win) {
				logger.info("Playing");
				game.setTryAgain(false);
				update();
				drawScene(ball, bricks, scoreboard);

				// to simulate low FPS
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
				}

			} else {
				if (game.isTryAgain()) {
					logger.info("Trying again");
					game.setTryAgain(false);
					bricks = Game.initializeBricks(bricks);
					scoreboard.lives = Config.PLAYER_LIVES;
					scoreboard.score = 0;
					scoreboard.win = false;
					scoreboard.gameOver = false;
					scoreboard.updateScoreboard();
					ball.x = Config.SCREEN_WIDTH / 2;
					ball.y = Config.SCREEN_HEIGHT / 2;
					paddle.x = Config.SCREEN_WIDTH / 2;
				}
			}

			long time2 = System.currentTimeMillis();
			double elapsedTime = time2 - time1;

			lastFt = elapsedTime;

			double seconds = elapsedTime / 1000.0;
			if (seconds > 0.0) {
				double fps = 1.0 / seconds;
				logger.info("FPS: " + fps);
			}

		}

		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
	}

	private void update() {

		currentSlice += lastFt;

		for (; currentSlice >= Config.FT_SLICE; currentSlice -= Config.FT_SLICE) {

			ball.update(scoreboard, paddle);
			paddle.update();
			Game.testCollision(paddle, ball);

			Iterator<Brick> it = bricks.iterator();
			while (it.hasNext()) {
				Brick brick = it.next();
				Game.testCollision(brick, ball, scoreboard);
				if (brick.destroyed) {
					it.remove();
				}
			}
		}
	}

	private void drawScene(Ball ball, List<Brick> bricks, ScoreBoard scoreboard) {

		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = null;

		try {

			g = bf.getDrawGraphics();
			g.setColor(Config.BACKGROUND_COLOR);
			g.fillRect(0, 0, getWidth(), getHeight());

			ball.draw(g);
			paddle.draw(g);
			for (Brick brick : bricks) {
				brick.draw(g);
			}
			scoreboard.draw(g);

		} finally {
			g.dispose();
		}

		bf.show();

		Toolkit.getDefaultToolkit().sync();

	}

	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			game.setRunning(false);
		}
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			game.setTryAgain(true);
		}
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			paddle.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			paddle.moveRight();
			break;
		default:
			break;
		}
	}

	public void keyReleased(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			paddle.stopMove();
			break;
		default:
			break;
		}
	}

	public void keyTyped(KeyEvent arg0) {}

}
