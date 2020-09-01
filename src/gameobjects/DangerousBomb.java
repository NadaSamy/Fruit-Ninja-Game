package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class DangerousBomb implements GameObject{
	Random rand =new Random();
	private Image dangerBomb;
	private boolean slice;
	
	public DangerousBomb () throws SlickException {
		this.dangerBomb = new Image("res/bomb1.png");
		this.slice=false;
	}
	
	
	public Image getImage() throws SlickException {
		return dangerBomb;
	}
	
	//get x location of dangerous bomb 
	@Override
	public int getXlocation() {
		
		return rand .nextInt(500);
	}
	//get y location of dangerous bomb
	@Override
	public int getYlocation() {
		
		return rand .nextInt(500);
	}
	

	@Override
	public String getType() {
		return "dangerous bomb";
	}
	


	public void setImage() throws SlickException {
	}


	@Override
	public Boolean isSliced() {
		return slice;
	}


	@Override
	public void setSlice() {
		this.slice=true;
	}



}
