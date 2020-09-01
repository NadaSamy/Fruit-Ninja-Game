package states;

public class DifficultyContext {
	private int score;
	private DifficultyState difficultyState;
	public DifficultyContext(int score) {
		
		this.setDifficulty(score); 
	}
	public float increaseSpeed()
	{
		return difficultyState.increaseSpeed();
	}
 	
	public void setDifficulty(int score) {
		this.score = score;
		if(score<=2)
		{
			difficultyState=new Easy();
		}
		else if(score>2&&score<=4)
		{
			difficultyState=new Medium();
			
		}
		else if(score>4)
		{
			difficultyState=new Hard();
		}
		
		    
	}


}
