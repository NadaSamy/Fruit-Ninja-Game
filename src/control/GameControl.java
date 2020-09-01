package control;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.newdawn.slick.SlickException;

import gameobjects.Apple;
import gameobjects.DangerousBomb;
import gameobjects.FatalBomb;
import gameobjects.GameObject;
import gameobjects.GameObjectFactory;
import gameobjects.Strawberry;
import gameobjects.SpecialFruit;
import gameobjects.Watermelon;

public class GameControl{
	
private GameState gameState;

private ArrayList<GameState> checkpoint;
private ReadXml readXml=new ReadXml();
private ArrayList <GameObject> gameObj;
private Player player;
private StateJAXB stateJAXB=new StateJAXB();


public GameControl() {

	gameState=new GameState();
	checkpoint=new ArrayList<>();
}



public ArrayList<GameState> getCheckpoint() {
	return checkpoint;
}


public void setCheckpoint(ArrayList<GameState> checkpoint) {
	this.checkpoint = checkpoint;
}

		
   public boolean hasWon(int score,List<GameState> State) { 
	  
			 int max =0;
			 boolean winningStatue;
			    for(int i=0; i<stateJAXB.getList().size(); i++){
			    	System.out.println("for loop");
			        if(State.get(i).getBest_score() > max){
			            max =State.get(i).getBest_score();
			        }       
		     }
			    if(max>score)
		        	winningStatue=true;
		        else
		        	winningStatue=false;
			    return winningStatue;
		 }
		 
		 
		 
	
	

public void addMemento(GameState s)
{
	checkpoint.add(s);
	
}


public GameState getGameState(int index) {
	return checkpoint.get(index);
}


public Player getPlayer() {
	return player;
}


public void setPlayer(Player player) {
	this.player = player;
}





}