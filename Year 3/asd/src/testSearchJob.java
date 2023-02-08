import java.util.ArrayList;

import junit.framework.TestCase;

public class testSearchJob extends TestCase {
	
	//Attributes
	private searchJob testSearchJob;

	protected void setUp() {
		
		//test values of arguments
		//allJobs list
		ArrayList<publishAdv> list_demo = new ArrayList<publishAdv>();
		list_demo.add(new publishAdv("Software", "Programmer", "Arbel", "Bear-sheva"));
		list_demo.add(new publishAdv("Hardware", "Teacher", "Adi", "Tel-aviv"));
		list_demo.add(new publishAdv("Medicine", "Physician", "Shaked", "Ramt-gan"));
		list_demo.add(new publishAdv("Software", "Programmer", "Ofir", "Dimona"));
		list_demo.add(new publishAdv("Software", "Teacher", "Sagi", "Hen-harod"));
		
		//search fields
		String domainParm = "Software";
		String roleParm = "Teacher";
		String areaParm = "tel-aviv";
		
		
		testSearchJob = new searchJob(domainParm , roleParm, areaParm);
		
		//addJob by instance of current searchJob
		for(publishAdv item : list_demo)
			testSearchJob.addJob(item);
	}
	
	//tests
	public void testAddJob() throws Exception {		
		assertEquals(5, testSearchJob.getJobs().length);
	}
	
}
