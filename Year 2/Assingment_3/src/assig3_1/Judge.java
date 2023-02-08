//Almog Fadida ID 315544437. Moran Arzi ID 200244945
package assig3_1;

public class Judge implements Runnable{
	

	GamePlay g1;
		
	Judge(GamePlay g1){
	this.g1 = g1;
}
		
	public void run() { //add here something
		

		while (!Thread.currentThread().isInterrupted()) { 
			
			g1.makeCoinAvail(false); //The judge take the coin and make it unavailable
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
				break;//for interrupt
			}
				
				
			g1.makeCoinAvail(true); //The judge give the coin to a player and make it available
				
			try {	
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
				break;//for interrupt
			}
		
	} //end while

}//end run function

}//end Judge class