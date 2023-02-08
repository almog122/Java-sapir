import junit.framework.*;

public class JobTesting extends TestCase {
	//attribute
	protected JobTestInterface testInf;
	
	//constructor
	public JobTesting(String name) {
		super(name);
		setTestInterface("proxy"); //default in this assignment defined "proxy"
	}
	
	//Methods
	public void setTestInterface(String interfaceType) {
		if(interfaceType.equals("real"))
			testInf = new JobRealInterface();
		else if ( interfaceType.equals("proxy") )
			testInf = new JobProxyInterface();
	}
	
	public boolean login(String id, String password) {
		return testInf.login(id, password);
	}
	
	public boolean addJob(String header, String content) {
		return testInf.addJob(header, content);
	}
	
	public boolean createEmployeer(String id, String Name, String email, String pass, String pack) {
		return testInf.createEmployeer(id, Name, email, pass, pack);
	}
	
	public boolean findJob(int salary, String type, String edu, String position, String area, String role, String domain) {
		return testInf.findJob(salary, type, edu, position, area, role, domain);
	}
	
	public boolean createWorker(String id, String name, String email, String pass) {
		return testInf.createWorker(id, name, email, pass);
	}
}
