package queen_lbs;

//Moran Arzi 200244945
//Almog Fadida 315544437

public class main {

	public static void main(String[] args) {
		int boardSize ,repeatTimes;
		
		boardSize = (int) ((Math.random() * 10) + 3);
		
		repeatTimes = (int) ((Math.random() * 10) + 3);
		
		randomRestartHillClimbing hillClimb = new randomRestartHillClimbing();
		
		hillClimb.HillClimbing(boardSize , repeatTimes);
	}

}
