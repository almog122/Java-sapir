//Almog Fadida ID 315544437. Moran Arzi ID 200244945

package assig3_1;


public class GamePlay {

	
	private boolean coin_available_; //The shared source
	private int rounds_counter_;
	
	
	GamePlay(boolean coin_available, int rounds_counter_){
		this.coin_available_ = coin_available;
		this.rounds_counter_ = rounds_counter_;
	}
	
	public synchronized void makeCoinAvail (boolean val) {
		
		if (val) { 
			coin_available_ = true;
			notifyAll();
		}
		
		else {
			coin_available_ = false;	
		}
				
	} //end makeCoinAvail function
	
	
	
	public synchronized int flipCoin(){
		
		while (!coin_available_) { //thread enter a wait if the coin is not available
			
			try {
				wait(); 
			}
			catch(InterruptedException e) {
				
				e.printStackTrace();
			}	
			
			System.out.println (Thread.currentThread().getName() + " is waiting for coin");
		}
		
		//thread take the coin and change the coin to not available
		System.out.println (Thread.currentThread().getName() + " is flipping coin");
		makeCoinAvail(false);
		rounds_counter_++; // flip the coin and advance the number of rounds
		makeCoinAvail(true); //and notify all is inside the function
		
		return (int) (Math.random() * 2); //return if he got head(1) or tail(0)
		
	} //end flipCoin function
	
	
	public int getNumOfRounds(){
		
		return rounds_counter_;
	}//end getNumOfRounds functions
	
	
	
} //end GamePlay class
