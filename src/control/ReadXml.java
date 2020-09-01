package control;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "games")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReadXml {
	 
	@XmlElement(name="game")
	private List<GameState> gameList=new ArrayList<GameState>();
  

	public void setGameList(List<GameState> states) {
		;
		this.gameList=states;
	}

	
		public List<GameState> getGameList() {
			return gameList;
		}
	
	

}