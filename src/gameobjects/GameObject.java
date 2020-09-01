package gameobjects;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public interface GameObject {
    public String getType();
	public int getXlocation();
	public int getYlocation();
	public Boolean isSliced();
	public void setSlice();
	public Image getImage () throws SlickException;
	public void setImage () throws SlickException;
}
