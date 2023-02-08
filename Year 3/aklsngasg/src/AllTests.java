import junit.framework.*;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("FindJob");
		suite.addTest( new TestSuite(JobSearchStoryTest.class) );
		suite.addTest( new TestSuite(PostingJobStoryTest.class) );
		return suite;
	}
}
