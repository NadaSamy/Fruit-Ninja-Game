package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class FatalBomb implements GameObject {
	Random rand= new Random();
	private Image fatalBomb;
	private boolean slice;
	
	public FatalBomb() throws SlickException {
		this.fatalBomb = new Image("res/boom.png");
		this.slice=false;
	}
	
	public Image getImage() throws SlickException {
		return fatalBomb;
	}
	
	@Override
	public String getType() {
		return"fatal bomb";
	}
	@Override
	public int getXlocation() {
		
		return rand .nextInt(500);
	}
	//get y location of fatalbomb
	@Override
	public int getYlocation() {
		
		return rand .nextInt(500);
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
	


