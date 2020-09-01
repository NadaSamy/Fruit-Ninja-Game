package gui;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameView extends StateBasedGame {
	
	public static final String gameName="Fruit Ninja";
	public static final int menu = 0; //first screen
	public static final int classicMode = 1;  //classic mode screen
	public static final int arcadeMode =2 ; //arcade mode screen
	
	public GameView (String gameName) {
		super(gameName);
		this.addState(new MainMenu(menu));
		this.addState(new ClassicMode(classicMode));
		this.addState(new ArcadeMode(arcadeMode));
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(classicMode).init(gc, this);
		this.getState(arcadeMode).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new GameView(gameName));
			appgc.setDisplayMode(1200,700, false);
			//appgc.setVSync(true);
			appgc.start();
			
		}catch(SlickException e) {
			e.printStackTrace();
		}

	}

}