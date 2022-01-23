package eus.ehu.adsi.arkanoid;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import eus.ehu.adsi.arkanoid.core.Game;
import eus.ehu.adsi.arkanoid.view.Ball;
import eus.ehu.adsi.arkanoid.view.Brick;


public class GameTests {
	
	private static final Logger logger = LogManager.getLogger(GameTests.class);

	@Test
	public void shouldIntersect() {
		Brick mBrick = new Brick(0, 0);
		Ball mBall = new Ball(0, 0);
		assertTrue(Game.isIntersecting(mBrick, mBall));
	}
	
	@Test
	public void shouldNotIntersect() {
		Brick mBrick = new Brick(5, 4);
		Ball mBall = new Ball(45, 45);
		assertFalse(Game.isIntersecting(mBrick, mBall));
	}

}
