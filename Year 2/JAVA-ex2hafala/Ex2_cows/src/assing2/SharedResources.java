package assing2;

import java.util.concurrent.Semaphore;

public class SharedResources {


	//semaphore1 -max 5 cows in eat
	Semaphore sem_max_eat;
	
	//semaphore2 -max 3 cows in drink
	Semaphore sem_max_drink;
	
	//semaphore3 -a cow can go walk only after everybody else finished in eat and drink
	Semaphore sem_walk;

	Semaphore sem_walk2;
	
	SharedResources(){
		sem_max_eat  = new Semaphore (5);
		sem_max_drink = new Semaphore (3);
		sem_walk = new Semaphore (0);
		sem_walk2 = new Semaphore (0);
	}
	
	
	
}
