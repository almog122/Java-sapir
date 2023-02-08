package Testing;


public class StoryJobSearchTesting extends InterfaceAndJobTest {
	
	public StoryJobSearchTesting(String name){
		
		super(name);
	
	}
	
	public void postNewJobTest() {
		
		login("user" , "112233"); //login to use the website
		
		assertTrue(postNewJob("title", "content")); // valid 
		
		assertFalse(postNewJob("title", "")); //invalid
		
		
	}
	
	public void checkPostInfoTest() {
		
		login("user" , "112233"); //login to use the website
		
		assertTrue(checkPostInfo()); //valid
		
		assertFalse(checkPostInfo()); // invalid
		
		
	}
	
	
	
	
}
