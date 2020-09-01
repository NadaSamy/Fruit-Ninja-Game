package control;

public class Player {
	private static Player instance;
	//private static GameControl game;
	private int remainingLives;
	private int currentScore;
	private int bestScore;
	private int timer;

	private  Player() {
		remainingLives=3;
		currentScore=0;
		timer=0;
		
	}
		
    public static Player getInstance()
    {
	
	if(instance==null)
		return instance=new Player();
	else 
		return instance;
	
    }
    
	
    public int getRemainingLives() {
		return remainingLives;
	}

	public void setRemainingLives(int remainingLives) {
		this.remainingLives = remainingLives;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	

	public int getBestScore() {
		return bestScore;
	}

	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}

	
	 public GameState saveToMemento() {
		// System.out.println("player:saving to momento");
	        GameState stateMemento=new GameState();
	        return stateMemento;
	    }
	    public  void restoreFromMemento(GameState memento)
	    {
	        this.bestScore= memento.getBest_score();
	       // System.out.println("player: state after restoring from momento :"+bestScore);
	    }


}

