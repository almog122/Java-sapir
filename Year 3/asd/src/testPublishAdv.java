import junit.framework.TestCase;

public class testPublishAdv extends TestCase {
	//attributes
	publishAdv adv;
	private String domain;
	private String role;
	private String desc;
	private String area;
	
	protected void setUp() {
		
		//test values of arguments
		domain = "Software";
		role = "Teacher";
		desc = "Hello world";
		area = "tel-aviv";
		
		adv = new publishAdv(domain, role, desc, area);
	}
	
	//tests
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
