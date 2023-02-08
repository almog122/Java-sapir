//Almog Fadida ID 315544437. Moran Arzi ID 200244945
package assig3_1;

public class Main {

	public static void main(String[] args) {
		
		GamePlay ourGame = new GamePlay(true ,0);
		
		Gamer player1 = new Gamer (0,ourGame);
		Gamer player2 = new Gamer (0,ourGame);
		
		Judge judge = new Judge(ourGame);
		
		Thread p1 = new Thread(player1);
		Thread p2 = new Thread(player2);
		Thread j1 = new Thread(judge);
		
		j1.start();
		p1.start();
		p2.start();
		
		//wait until all players threads will be done
		try {
			p1.join();
			p2.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		if(ourGame.getNumOfRounds() == 10) {
			j1.interrupt(); //interrupt the judge
		}
		
		//wait until judge will be done
		try {
			j1.join();
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
		if (player1.getScore() == player2.getScore()) {
			
			System.out.println("It's a tie.");
			
		}else if (player1.getScore() > player2.getScore()) {
			
				System.out.println("Player 1 wins"); 
			
			}else {
			
				System.out.println("Player 2 wins"); 
			}
		
		
	} // end main function

} //end class main
