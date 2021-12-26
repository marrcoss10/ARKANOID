package eus.ehu.adsi.arkanoid.core;

import java.util.List;

import eus.ehu.adsi.arkanoid.view.Ball;
import eus.ehu.adsi.arkanoid.view.Brick;
import eus.ehu.adsi.arkanoid.view.Config;
import eus.ehu.adsi.arkanoid.view.GameObject;
import eus.ehu.adsi.arkanoid.view.Paddle;
import eus.ehu.adsi.arkanoid.view.ScoreBoard;

public class Game {
	private boolean running;
	private boolean tryAgain;
	
	public Game () {
		this.setRunning(false);
		this.setTryAgain(false);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isTryAgain() {
		return tryAgain;
	}

	public void setTryAgain(boolean tryAgain) {
		this.tryAgain = tryAgain;
	}
	
	public static void testCollision(Paddle mPaddle, Ball mBall) {
		if (!Game.isIntersecting(mPaddle, mBall))
			return;
		mBall.velocityY = -Config.BALL_VELOCITY;
		if (mBall.x < mPaddle.x)
			mBall.velocityX = -Config.BALL_VELOCITY;
		else
			mBall.velocityX = Config.BALL_VELOCITY;
	}
	
	public static void testCollision(Brick mBrick, Ball mBall, ScoreBoard scoreboard) {
		if (!Game.isIntersecting(mBrick, mBall))
			return;

		mBrick.destroyed = true;

		scoreboard.increaseScore();

		double overlapLeft = mBall.right() - mBrick.left();
		double overlapRight = mBrick.right() - mBall.left();
		double overlapTop = mBall.bottom() - mBrick.top();
		double overlapBottom = mBrick.bottom() - mBall.top();

		boolean ballFromLeft = overlapLeft < overlapRight;
		boolean ballFromTop = overlapTop < overlapBottom;

		double minOverlapX = ballFromLeft ? overlapLeft : overlapRight;
		double minOverlapY = ballFromTop ? overlapTop : overlapBottom;

		if (minOverlapX < minOverlapY) {
			mBall.velocityX = ballFromLeft ? -Config.BALL_VELOCITY : Config.BALL_VELOCITY;
		} else {
			mBall.velocityY = ballFromTop ? -Config.BALL_VELOCITY : Config.BALL_VELOCITY;
		}
	}
	
	public static boolean isIntersecting(GameObject mA, GameObject mB) {
		return mA.right() >= mB.left() && mA.left() <= mB.right()
				&& mA.bottom() >= mB.top() && mA.top() <= mB.bottom();
	}
	
	public static List<Brick> initializeBricks(List<Brick> bricks) {
		bricks.clear();
		for (int iX = 0; iX < Config.COUNT_BLOCKS_X; ++iX) {
			for (int iY = 0; iY < Config.COUNT_BLOCKS_Y; ++iY) {
				bricks.add(new Brick(
						(iX + 1) * (Config.BLOCK_WIDTH + 3) + 22,
						(iY + 2) * (Config.BLOCK_HEIGHT + 3) + 50)
						);
			}
		}
		return bricks;
	}

}
