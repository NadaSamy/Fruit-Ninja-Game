package control;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="game")
@XmlAccessorType(XmlAccessType.FIELD)
public class GameState {
	
	@XmlElement(name = "best_score")
	private int bestScore;
	
    
	public GameState(int bestScore) {
		this.bestScore=bestScore;
	}

	public GameState() {
		
	}



	public int getBest_score() {
		
		return bestScore;
	}

	public void setBest_score(int best_score) {
		this.bestScore = best_score;
	}


	@Override
	    public String toString(){
	        String str="Current Memento State" +" , "+this.getBest_score();
	        return str;
	    }
	
	
	
	

}