package gameobjects;


import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Apple implements GameObject {
	Random rand=new Random();
	private Image apple;
	private Image appleSlice;
	private Boolean slice;
	
	public Apple() throws SlickException {
		this.apple=new Image("res/apple.png");
		this.appleSlice = new Image("res/apple1.png");
		slice=false;
	}
	
	@Override
	public String getType() {
		
		return"apple";
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
	@Override
	public Boolean isSliced() {
		return slice;
	}
	
	
	
	public Image getImage() throws SlickException {
		return apple;
	}

	public void setImage() throws SlickException {
		this.apple=appleSlice;
	}

	@Override
	public void setSlice() {
		// TODO Auto-generated method stub
		this.slice=true;
		
	}

	
}
