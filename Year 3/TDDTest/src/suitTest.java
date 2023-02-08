
import junit.framework.*;

public class suitTest {
	public static Test suite() {
		
		TestSuite StartTest = new TestSuite();
		
		TestSuite JobSearchTest = new TestSuite(StoryJobSearchTesting.class);
		TestSuite JobPostTest = new TestSuite(StoryPostJobTesting.class);
		
		StartTest.addTest(JobSearchTest);
		StartTest.addTest(JobPostTest);
		
		return StartTest;
	}
}
