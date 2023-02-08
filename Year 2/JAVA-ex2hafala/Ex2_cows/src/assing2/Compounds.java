package assing2;

public class Compounds {
	
	//using semaphores we'll create the following functions:
	
		SharedResources re;
	
		Compounds (SharedResources re){
			
			this.re = re;
			
		}
		int randomTime() { //this function is purely to save code length
		
				int rand = (int) (Math.random() * 9) + 2; //random number from 2-10 (included)
				return rand;
		
		}
		
		public void drink(int id) {
			
			System.out.println("The cow " + id + " is in drinking zone");
			
			if(re.sem_max_drink.availablePermits() < 0 ||  re.sem_max_drink.availablePermits() > 3)
				System.out.println("This cow " + id + " is a criminal and breaking the laws of the farm!");
			
			
		}
		
		
		public void eat(int id) {
			
			System.out.println("The cow " + id + " is in eating zone");
			
			if(re.sem_max_eat.availablePermits() < 0 || re.sem_max_eat.availablePermits() > 5)
				System.out.println("This cow " + id + " is a criminal and breaking the laws of the farm!");
		}
		
		public void walk(int id) {	
			
			System.out.println("The cow " + id + " is in walking zone");
			
		}
		
		
		
		
		
	
}
