package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Watermelon implements GameObject {
	Random rand=new Random();	
	private Image watermelon;
	private Image watermelonSlice;
	private boolean slice;
	
	public Watermelon() throws SlickException {
		this.watermelon = new Image("res/watermelon.png");
		this.watermelonSlice = new Image("res/watermelon1.png");
	}
	
	public Image getImage() throws SlickException {
		return watermelon;
	}
	
	@Override
	public String getType() {
		return "watermelon";
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
		this.watermelon=watermelonSlice;
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
