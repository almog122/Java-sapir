import java.util.concurrent.Semaphore;

public class SharedResources {
	
	//semaphore1 -max 5 cows in eat
	Semaphore sem_max_eat;
	
	//semaphore2 -max 3 cows in drink
	Semaphore sem_max_drink;
	
	//semaphore3 -a cow can go walk only after everybody else finished in eat and drink
	Semaphore walk;

	//semaphore4 - the cow can go drink only after she was in eat
	Semaphore drink_after_eat ;
	
	SharedResources(){
		sem_max_eat  = new Semaphore (5);
		sem_max_drink = new Semaphore (3);
		walk = new Semaphore (1);
		drink_after_eat  = new Semaphore (1);
	}
	
	
	
}
