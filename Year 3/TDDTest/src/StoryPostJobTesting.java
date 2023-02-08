

public class StoryPostJobTesting extends InterfaceAndJobTest {

	public StoryPostJobTesting(String name) {
		
		super(name);
		
	}
	
	public void SearchForJobTest() {
		
		login("user" , "112233"); //login to use the website
		
		assertTrue(SearchForJob(5000 ,"Human Resources","college","clean","center","cleaner","clean")); // valid 
		
		assertFalse(SearchForJob(5000 ,"Human Resources","select all","clean","pizza hut","cleaner","clean")); //invalid location
		
	}
	
	public void checkPostInfoTest() {
		
		login("user" , "112233"); //login to use the website
		
		assertTrue(sendMessegeHR("madup@gmail.com" , "looking for a job")); //valid
		
		assertFalse(sendMessegeHR("@com", "hello")); // invalid email
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
