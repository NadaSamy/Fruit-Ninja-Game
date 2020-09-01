   package gameobjects;

import org.newdawn.slick.SlickException;

public class GameObjectFactory {
public GameObject create(String type) throws SlickException
{
	//create

	if("apple".equalsIgnoreCase(type))
	{    	   
		return new Apple();

	}
	else if("strawberry".equalsIgnoreCase(type)) {

		return new Strawberry();
	}
	else if("watermelon".equalsIgnoreCase(type)) {

		return new Watermelon();
	}
	else if("special fruit".equalsIgnoreCase(type)) {

		return new SpecialFruit();
	}
	else if ("fatal bomb".equalsIgnoreCase(type))
	{ 
		return new FatalBomb();
	}
	else if ("dangerous bomb".equalsIgnoreCase(type))
	{  

		return new DangerousBomb();
	}
	else { 
		return null;
	}
	
	
	
}
}
