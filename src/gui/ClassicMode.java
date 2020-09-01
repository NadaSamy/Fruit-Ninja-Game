package gui;
 

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import control.*;
import control.GameState;
import states.*;
import java.util.Random;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import gameobjects.GameObject;
import gameobjects.GameObjectFactory;

public class ClassicMode extends BasicGameState{
	Image backGround;
	Image score1;
	Image gameOver;
	Image lives; 
	Image livesX;
	
	Sound s;
	Sound slice;
	Sound slice2;
	Sound splatter;
	Sound dangerSound;
	Sound fatalSound;
	
	
	GameControl gameControl=new GameControl();
	ArrayList<GameObject> gameObjects = new ArrayList<>();
	int counter=0;
	GameObjectFactory factory=new GameObjectFactory();
	GameState gameState = new GameState();
	ReadXml readXml;
	StateJAXB state;

	int randomNumber;
	ArrayList<String> fruits=new ArrayList<String>();
	List<GameState> list=new ArrayList<GameState>();
	Random rand = new Random();
	int xpos;
	int ypos;
	int bestScore;
	float shiftX=400;
	float shiftY=500;
	boolean liveSlice=false;
	
	private DifficultyState difficulty;
	private DifficultyContext context;
	private Player player;
	
	public ClassicMode(int state) {
		
	}
	
	
	
	public void init (GameContainer gc,StateBasedGame sbg) throws SlickException{
		

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ReadXml.class);
			 state = new StateJAXB();
			state.readXML(jaxbContext);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("error");
		}
		player=Player.getInstance();
		context=new DifficultyContext(player.getCurrentScore());
		
		backGround = new Image("res/background.jpg");
		score1 = new Image("res/score.png");
		gameOver = new Image("res/GameOver.png");
		lives = new Image("res/lives.png");
		livesX = new Image("res/livesx.png");
		s = new Sound("res/start.wav");
		slice = new Sound("res/slice.wav");
		slice2 = new Sound("res/throw.wav");
		splatter = new Sound("res/splatter.wav");
		dangerSound = new Sound("res/boom.wav");
		fatalSound = new Sound("res/fatalbomb.wav");
	
	
		
		fruits.add("apple");
		fruits.add("strawberry");
		fruits.add("watermelon");
		fruits.add("special fruit");
		fruits.add("fatal bomb");
		fruits.add("dangerous bomb");
		
		
		randomNumber = rand.nextInt(6);
		
		
		gameControl=new GameControl();
		
		
		for(int i=0;i<50;i++) {
			randomNumber = rand.nextInt(6);
		   gameObjects.add(factory.create(fruits.get(randomNumber)));
		}
		
		
		
	}
	
	
	
	
	public void render(GameContainer gc,StateBasedGame sbg ,Graphics g) throws SlickException{
		backGround.draw(0,0,1200,800);
		if(player.getRemainingLives()==3) {
			lives.draw(30,30,60,60);
			lives.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==2) {
			livesX.draw(30,30,60,60);
			lives.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==1) {
			livesX.draw(30,30,60,60);
			livesX.draw(95,30,60,60);
			lives.draw(160,30,60,60);
		}
		if(player.getRemainingLives()==0) {
			livesX.draw(30,30,60,60);
			livesX.draw(95,30,60,60);
			livesX.draw(160,30,60,60);
			gameOver.draw(250,300,1.5f);
		}
		
		
	
		gameObjects.get(counter).getImage().draw(shiftX,shiftY,50,50);
		bestScore=state.getList().get(state.getList().size()-1).getBest_score();
		g.scale(2f, 2f); 
		g.drawString("Score: "+player.getCurrentScore()+" Best:"+bestScore,250, 10);
		
	}
	

	public void update(GameContainer gc,StateBasedGame sbg,int delta) throws SlickException{
		gameControl.addMemento(player.saveToMemento());
		Input input=gc.getInput();
		xpos = Mouse.getX();
		ypos = Mouse.getY();
	    context.setDifficulty(player.getCurrentScore());
		shiftY+=context.increaseSpeed();
		shiftX-=context.increaseSpeed();
		
		if(shiftY<-1) {
			shiftY+=context.increaseSpeed();
		}
		
		if(shiftX<-1) {
			shiftX+=context.increaseSpeed();
		}
		
		if(shiftX>1150) {
			shiftX-=context.increaseSpeed();
		}
	
		if(input.isMousePressed(0) && shiftX+50>=xpos && shiftX<=xpos &&((((shiftY-646)+50>=ypos)||(shiftY-646)+50>=-ypos))&&(((shiftY-646)<=ypos)||(shiftY-646)<=-ypos)) {
			switch (gameObjects.get(counter).getImage().getResourceReference()) {
			case"res/apple.png":
				slice.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
				player.setCurrentScore(player.getCurrentScore()+1);
 				break;
			case"res/watermelon.png":
				slice.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
				player.setCurrentScore(player.getCurrentScore()+1);
				break;
			case"res/strawberry.png":
				slice.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
				player.setCurrentScore(player.getCurrentScore()+1);
				break;
			case"res/special.png":
				splatter.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
				player.setCurrentScore(player.getCurrentScore()+5);
				break;
			case"res/boom.png":
				fatalSound.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
				player.setRemainingLives(0);
				break;
			case"res/bomb1.png":
				dangerSound.play();
				gameObjects.get(counter).setImage();
				gameObjects.get(counter).setSlice();
			    player.setRemainingLives(player.getRemainingLives()-1);;
				break;
			}
		}
		
		 if(shiftY>646 ) {
			if(player.getRemainingLives()>0 ) {
				if(gameObjects.get(counter).isSliced()==false) {
			player.setRemainingLives(player.getRemainingLives()-1);
				}
			shiftX=500;
			shiftY=400;
			
			}else {
				
			if(bestScore <player.getCurrentScore()) {
					try {
						JAXBContext jaxbContext = JAXBContext.newInstance(ReadXml.class);
						gameState.setBest_score(player.getCurrentScore());
						List<GameState> list =new ArrayList<>(); 
						  list.add(gameState);
						state.writeXml(jaxbContext,list);
						 state = new StateJAXB();
						state.readXML(jaxbContext);
						
					} catch (JAXBException e) {
						e.printStackTrace();
						System.out.println("error");
					}
			}
				player.setRemainingLives(3);
				player.setCurrentScore(0);
				sbg.enterState(0,new FadeOutTransition(),new FadeInTransition());
			}
			counter++;
		}
		
		
		
		
	}

	public int getID() {
		return 1;
	}
  }