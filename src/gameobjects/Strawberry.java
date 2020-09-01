package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Strawberry implements GameObject {
	Random rand=new Random();	
	private Image strawberry;
	private Image strawberrySlice;
	private boolean slice;
	
	
	public Strawberry() throws SlickException {
		this.strawberry = new Image("res/strawberry.png");
		this.strawberrySlice = new Image("res/strawberry1.png");
		this.slice=false;
	}
	
	public Image getImage() throws SlickException {
		return strawberry;
	}
	
	@Override
	public String getType() {
		return "strawberry";
		
	}
	//get x location of fruit 
	@Override
	public int getXlocation() {
		
		return rand .nextInt(500);
	}
	//get y location of fruit 
	@Override
	public int getYlocation() {
		
		return rand .nextInt(500);
	}


	public void setImage() throws SlickException {
		this.strawberry=strawberrySlice;
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
