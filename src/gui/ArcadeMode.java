package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ArcadeMode extends BasicGameState{
	Image backGround;
	Image score1;
	Image gameOver;
	Image time;
	
	public ArcadeMode(int state) {
		
	}
	
	public void init (GameContainer gc,StateBasedGame sbg) throws SlickException{
		backGround = new Image("res/background.jpg");
		score1 = new Image("res/score.png");
		gameOver = new Image("res/GameOver.png");
		time = new Image("res/time.png");
		
		
	}
	
	public void render(GameContainer gc,StateBasedGame sbg ,Graphics g) throws SlickException{
		backGround.draw(0,0,1200,800);
		score1.draw(40,50,0.7f);
		time.draw(900,50,0.7f);
	}
	
	public void update(GameContainer gc,StateBasedGame sbg,int delta) throws SlickException{
		
	}
	
	public int getID() {
		return 2;
	}
  }