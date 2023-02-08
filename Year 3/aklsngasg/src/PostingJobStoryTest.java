import junit.framework.*;

public class PostingJobStoryTest extends JobTesting {

	//Constructor
	public PostingJobStoryTest(String name){
		super(name);
	}
	//Methods
	public void testNewJob() {
		login("admin", "1234"); //Must be login
		
		//valid values
		assertTrue( addJob("HeaderTest","Content") );
		
		//invalid values
		assertFalse( addJob("HeaderInvalid","") );
	} //End-method
	
	
	public void testCreateEmployeer() {
		//Invalid test
		assertFalse(createEmployeer("", //Id invalid
				"Israel israeli",//Name
				"aaa@gmail.com",//Email
				"1234567", //Password
				"10" //Package
				));
		
		//Valid test
		assertTrue( createEmployeer("123456789", //Id
				"Israel israeli",//Name
				"abc@gmail.com",//Email
				"", //Password
				"10" //Package
				));
		
	} //End-method
	
} //End-UserStory
