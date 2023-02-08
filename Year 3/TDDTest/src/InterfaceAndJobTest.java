
import junit.framework.*;

public class InterfaceAndJobTest extends TestCase{

	protected InterfaceJobStory infoTest;
	
	public InterfaceAndJobTest(String name) {
		
		super(name);
		
		setInterface("proxy"); //change the type to proxy
		
	}
	
	public void setInterface(String type) {
		if(type.equalsIgnoreCase("proxy")) {
			infoTest = new InterfaceJobProxyType();
		}
		
		else {
			infoTest = new InterfaceJobRealType();
		}
	}
	
	//a login that every user that uses the website need to complete to use the website
	public boolean login(String user , String pws) {
		
		return infoTest.login(user, pws);
	}
	
	//allow the user to post a job 
	public boolean postNewJob(String title ,String content) {
		
		return infoTest.postNewJob(title ,content);
	
	}
	
	//hidden assumption : allow to see the info about the job the user posted for example : amount of people applied.
	public boolean checkPostInfo() {
		
		return infoTest.checkPostInfo();
	
	}
	
	//allow the user to search for a job
	public boolean SearchForJob(int wage ,String job ,String education ,String scopeOfJob,String location ,String role ,String lineOfBusiness) {
		
		return infoTest.SearchForJob(wage , job ,education , scopeOfJob,location ,role ,lineOfBusiness);
	
	}
	
	// allows job seekers to contact HR
	public boolean sendMessegeHR(String email , String about) {
		
		return infoTest.sendMessegeHR(email ,about);
	
	}

}
