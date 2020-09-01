package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SpecialFruit implements GameObject {
	Random rand=new Random();	
	private Image special;
	private Image specialSlice;
	private boolean slice;
	public SpecialFruit() throws SlickException {
		this.special = new Image("res/special.png");
		this.specialSlice = new Image("res/special1.png");
		this.slice=false;
	}
	
	public Image getImage() throws SlickException {
		return special;
	}
	
	@Override
	public String getType() {
		return"special";
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
		this.special=specialSlice;
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
