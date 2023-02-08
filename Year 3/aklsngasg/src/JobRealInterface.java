
public class JobRealInterface implements JobTestInterface {
	//Should to be implement in next assignment by doctor Nurit
	public boolean login(String id, String password) {
		return true;
	}
	
	public boolean addJob(String header, String content) {
		return true;
	}
	
	public boolean createEmployeer(String id, String Name, String email, String pass, String pack) {
		return true;
	}
	
	public boolean findJob(int salary, String type, String edu, String position, String area, String role, String domain) {
		return true;
	}
	
	public boolean createWorker(String id, String name, String email, String pass) {
		return true;
	}
	
}
