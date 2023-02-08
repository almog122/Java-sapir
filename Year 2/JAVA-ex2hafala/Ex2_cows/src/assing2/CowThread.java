package assing2;


public class CowThread implements Runnable{

	
	
	static int global_id = 1;
	final int id = global_id++;
	Compounds comp;
	SharedResources res;
	
	CowThread (Compounds comp , SharedResources res){
		
		this.comp = comp;
		this.res = res;
		
	}
	
	public void run() {
		
		try {
			res.sem_max_eat.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		comp.eat(id);
		
		res.sem_walk.release();
		
		try {
			Thread.sleep(comp.randomTime() * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		res.sem_max_eat.release();
		
		try {
			res.sem_max_drink.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		comp.drink(id);
		
		try {
			Thread.sleep(comp.randomTime() * 1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		res.sem_max_drink.release();
		
		try {
			res.sem_walk.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(res.sem_walk.tryAcquire()) {  // so it would be 0 - means false
			try {
				res.sem_walk2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		res.sem_walk2.release();
		
		comp.walk(id);
		
		try {
			Thread.sleep(comp.randomTime() * 1000);
		} catch (InterruptedException e1) {
		e1.printStackTrace();
		}
		
		
		
	}
}