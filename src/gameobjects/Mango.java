package gameobjects;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Mango extends GameObject {
	Random rand=new Random();	
	Image strawberry;
	Image strawberrySlice;
	
	public Mango() throws SlickException {
		this.strawberry = new Image("res/strawberry.png");
		this.strawberrySlice = new Image("res/strawberry1.png");
	}
	
	public Image getImage() throws SlickException {
		return strawberry;
	}
	
	@Override
	public void getType() {
		
		System.out.println("Mango");
	}
	//get x location of fruit 
	@Override
	public int getXlocation() {
		
		return rand.nextInt(400);
	}
	//get y location of fruit 
	@Override
	public int getYlocation() {
		
		return rand.nextInt(600);
	}
	//checking whether fruit is sliced or not 
	@Override
	public Boolean isSliced(int x ,int y ) {
	 if(x==getXlocation()&& y==getYlocation())
		 {
		   return true;
		 }
	 else 
	 { 
	     return false ;
		 
	 }
		
	}

	public Image getImageSlice() throws SlickException {
		return strawberrySlice;
	}
}
