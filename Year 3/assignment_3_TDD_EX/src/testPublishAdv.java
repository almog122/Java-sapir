import junit.framework.TestCase;
//Almog Fadida 315544437
//Yair Nisa-El 206005373

public class testPublishAdv extends TestCase {
	//Attributes
	publishAdv adv;
	String domain, role, desc, area;
	
	protected void setUp() {
		
		//test values of arguments
		domain = "Software";
		role = "QA tester";
		desc = "Wanted";
		area = "haifa";
		
		adv = new publishAdv(domain, role, desc, area);
	}
	
	//Tests
	public void testDomain() throws Exception {
		assertEquals(domain , adv.get_domain());
	}
	
	public void testRole() throws Exception {
		assertEquals(role , adv.get_role());
	}
	
	public void testDesc() throws Exception {
		assertEquals(desc , adv.get_desc());
	}
	
	public void testArea() throws Exception {
		assertEquals(area , adv.get_area());
	}
	
	public void testStatus() throws Exception {
		assertTrue(adv.get_status());
	}
	
}
