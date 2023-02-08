import junit.framework.*;

public class JobSearchStoryTest extends JobTesting {
	
	//Constructor
	public JobSearchStoryTest(String name){
		super(name);
	}
	
	
	//Methods
	public void testFindJob() {
		login("admin", "1234"); //Must be login
		
		//valid test
		assertTrue( findJob(10000, //salary
							"freelancer",//type of job
							"B.sc",//education
							"full",//position
							"south",//area
							"developer",//role
							"software"//domain
							));
		
		//invalid test
		assertFalse(findJob(10000, //salary
				"freelancer",//type of job
				"B.sc",//education
				"full",//position
				"south",//area
				"",//role - invalid
				"software"//domain
				));	
		
		} //End-method
	
	public void testCreateWorker() {
		
		//Invalid test
		assertFalse(createWorker("123456789", //Id
				"Israel israeli",//Name
				"aaa@gmail.com",//Email
				"" //Password invalid
				));
		
		//Valid test
		assertTrue(createWorker("123456789", //Id
				"Israel israeli",//Name
				"abc@gmail.com",//Email
				"123456" //Password
				));
		
	} //End-method
	
}
