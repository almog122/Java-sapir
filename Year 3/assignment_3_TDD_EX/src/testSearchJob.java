import java.util.ArrayList;

import junit.framework.TestCase;
//Almog Fadida 315544437
//Yair Nisa-El 206005373

public class testSearchJob extends TestCase {
	
	//attributes
	private searchJob sJobs;
	ArrayList<publishAdv> testArr;

	protected void setUp() {
		
		sJobs = new searchJob("Software" , "QA tester", "haifa");
		
		//test ads
		testArr = new ArrayList<publishAdv>();
		
		testArr.add(new publishAdv("Medicine", "Doctor", "Shalom", "haifa"));
		testArr.add(new publishAdv("Software", "Programmer", "Almog", "haifa"));
		testArr.add(new publishAdv("Hardware", "IT", "Adi", "haifa"));
		testArr.add(new publishAdv("Medicine", "Doctor", "Igor", "haifa"));
		testArr.add(new publishAdv("Software", "Teacher", "Amit", "haifa"));
		
		for(publishAdv ad : testArr)
			sJobs.addJob(ad);
	}
	
	//Tests
	public void testAddJob() throws Exception {		
		assertEquals(5, sJobs.getAllJobs().size());
	}
	
	public void testContainId() throws Exception {		
		assertEquals(testArr, sJobs.filterOpenOnly());
	}
	
	public void testFilterArea() throws Exception {		
		assertEquals(testArr, sJobs.filterByArea("haifa"));
	}
	
	public void testFilterRole() throws Exception {	
		
		ArrayList<publishAdv> temp = new ArrayList<publishAdv>();
		temp.add(testArr.get(0));
		temp.add(testArr.get(3));
		
		assertEquals(temp, sJobs.filterByRole("Doctor"));
	}
	
	public void testFilterDomain() throws Exception {	
		
		ArrayList<publishAdv> temp = new ArrayList<publishAdv>();
		
		temp.add(testArr.get(0));
		temp.add(testArr.get(3));
		
		assertEquals(temp, sJobs.filterByDomain("Medicine"));
	}
	

}
