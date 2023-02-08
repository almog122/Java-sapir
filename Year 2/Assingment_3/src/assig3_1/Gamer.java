//Almog Fadida ID 315544437. Moran Arzi ID 200244945
package assig3_1;

public class Gamer implements Runnable{

	
	private int goodFlipsCounter;
	private GamePlay g;
	
	Gamer(int goodFlipsCounter ,GamePlay g){
		
		this.goodFlipsCounter = goodFlipsCounter;
		
		this.g = g;
		
	}
	
	public void play() {
		
		while (!Thread.currentThread().isInterrupted() && g.getNumOfRounds() < 10) {
			
			 
			if(g.flipCoin() == 1) //If after the flip we got a head
			 	goodFlipsCounter++; // then we got a good flip
			
			try  {
				
				Thread.sleep(1000); 
				
			}
			catch(InterruptedException e) {
				break;//for interrupt
			}
			
		}//end while
		
		}//end play function
	
	public int getScore() {
		return goodFlipsCounter;
	}
	
	
	public void run() {
		play();
		
		
		
	} //end run function
	
	
	
} //end Gamer class
