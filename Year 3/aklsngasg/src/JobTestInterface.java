
public interface JobTestInterface {
	
	public boolean login(String id, String password);
	
	public boolean addJob(String header, String content);
	
	public boolean createEmployeer(String id, String Name, String email, String pass, String pack);
	
	public boolean findJob(int salary, String type, String edu, String position, String area, String role, String domain);
	
	public boolean createWorker(String id, String name, String email, String pass);
	
}
