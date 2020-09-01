package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;



public class MainMenu extends BasicGameState{
	
	Image backGround;
	Image arcadeMode;
	Image classicMode;
	Image logo;
	Image exit;
	Image banana;
	Image watermelon;
	Sound menuMusic;
	String mouse = "No input yet";

	
	public MainMenu(int state) {
		
	}
	
	public void init (GameContainer gc,StateBasedGame sbg) throws SlickException{
		backGround = new Image("res/background.jpg");
		arcadeMode = new Image("res/ArcadeMode.png");
		classicMode = new Image("res/Classic.png");
		banana = new Image("res/banana.png");
		watermelon = new Image ("res/watermelon.png");
		exit = new Image("res/exit.png");
		logo = new Image("res/logo.png");
		menuMusic = new Sound ("res/menu.wav");
		menuMusic.loop();
		
		
	}
	
	public void render(GameContainer gc,StateBasedGame sbg ,Graphics g) throws SlickException{
		backGround.draw(0, 0, 1200, 800);
		arcadeMode.draw(200,350,0.5f);
		classicMode.draw(800,350,0.5f);
		banana.draw(250,450,1f);
		watermelon.draw(870,450,1f);
		logo.draw(300,40);
		exit.draw(530,550,1f);
		watermelon.draw(575,595,0.6f);
		g.drawString(mouse,500,500);
		
	}
	
	public void update(GameContainer gc,StateBasedGame sbg,int delta) throws SlickException{
		int xPos = Mouse.getX();
		int yPos = Mouse.getY();
		Input input = gc.getInput();
		mouse = "Mouse position x pos"+ xPos +" y pos " + yPos;
		if(xPos>875 && xPos<960 && yPos<244 && yPos>174 && input.isMousePressed(0)) {
			sbg.enterState(1,new FadeOutTransition(),new FadeInTransition());
			
		}
		if(xPos<369 && xPos>265 && yPos<243 && yPos>206 && input.isMousePressed(0)) {
			sbg.enterState(2,new FadeOutTransition(),new FadeInTransition());
		}
		if(xPos>577 && xPos<626 && yPos>61 && yPos<104 && input.isMousePressed(0)) {
			System.exit(0);
		}
		
		
	}
	
	public int getID() {
		return 0;
	}
}